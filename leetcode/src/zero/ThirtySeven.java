package zero;

/**
 * Created by olddriver on 17-3-23.
 * Write fortheen program to solve fortheen Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution
 */

import mytools.DoArray;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


/** 收获：
 *https://zeroturnaround.com/rebellabs/java-8-explained-applying-lambdas-to-java-collections/
 *
 * what should be done
 * 1. init the tensor
 * 2. when fortheen element has been throw out,it should make change
 * 4. use list filter
 * 5. set ohters together
 * */
public class ThirtySeven {
    private void printBoard(char[][] board){
        for(char[] s:board){
            for (char a:s){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
    public void solveSudoku(char[][] board) {

        class Point{
            int x;
            int y;
            int num;
            Point(int x,int y,int num){
                this.x=x;
                this.y=y;
                this.num=num;
            }

            private int getX() {
                return x;
            }

            private int getY() {
                return y;
            }

            private int getNum() {
                return num;
            }
            private void setNum(int num){
                this.num=num;
            }

        }

        //init the all the numbers in
        int[][][] candi=new int[9][9][10];
        List<Point> certains=new LinkedList<>();// be point that will fluence all other
        List<Point> uncertains=new LinkedList<>();// haven't be decided
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board.length ; j++) {
                if(board[i][j]!='.'){
                    certains.add(new Point(i,j,board[i][j]-48));
                    // if the candi[i][j][0] has been settle down,...
                }else {
                    uncertains.add(new Point(i,j,-1));
                    candi[i][j][0]=8;
                }
            }
        }
        int flag;
        while (!uncertains.isEmpty()){
             /*we find out that not only the numbers shouldn't be identical,but also it should in the range
             * from the 1 to 9,thsi is equal to */
            flag=uncertains.size();
            //use the certain item's informations
            for(Point a:certains){
                int i=a.getX();
                int j=a.getY();
                int num=a.getNum();
                //clear the row
                for (int k = 0; k <board.length ; k++) {
                    if(candi[i][k][num]==0&&candi[i][k][0]!=0) {
                        candi[i][k][0]--;
                        candi[i][k][num] = 1;
                    }
                }

                //clear the column
                for (int k = 0; k <board.length ; k++) {
                    if(candi[k][j][num]==0&&candi[k][j][0]!=0) {
                        candi[k][j][0]--;
                        candi[k][j][num] = 1;
                    }
                }

                // clear the box
                int align_x=(i/3)*3;
                int align_y=(j/3)*3;
                for (int k = align_x; k <align_x+3 ; k++) {
                    for (int l = align_y; l <align_y+3 ; l++) {
                        if(candi[k][l][num]==0&&candi[k][l][0]!=0){
                            candi[k][l][0]--;
                            candi[k][l][num]=1;
                        }
                    }
                }
            }

            //filter the point who are certain and uncertained
            certains=uncertains.stream()
                    .filter(point -> candi[point.getX()][point.getY()][0]==0)
                    .collect(Collectors.toList());
            uncertains=uncertains.stream()
                    .filter(point -> candi[point.getX()][point.getY()][0]!=0)
                    .collect(Collectors.toList());

            //for the point are certianed ,we should find out which number it holds
            for(Point p:certains){
                for (int i = 1; i <10 ; i++) {
                    if(candi[p.getX()][p.getY()][i]==0){
                        p.setNum(i);
                        board[p.getX()][p.getY()]= (char) (i+48);
                    }
                }
            }
            // another perspective
            // may be can done together
            if(flag==uncertains.size()){
                // collect all the possible numbers in fortheen row cloumn and find out who is bigger is euqal to one
                Point[] subs=new Point[9];
                //check the row
                for (int i = 0; i <board.length ; i++) {
                    for (int j = 0; j <board.length ; j++) {
                        if(candi[i][j][0]!=0){
                            for (int k = 1; k <10 ; k++) {
                                if(candi[i][j][k]==0){
                                    if (subs[k-1]==null){
                                        subs[k-1]=new Point(i,j,-1);//so -1 means only one is ok
                                    }else {
                                        subs[k-1]=new Point(i,j,1);
                                    }
                                }
                            }
                        }
                    }
                    // what great is that there is the certains' size is zero
                    //handle the uncertains,in which way??
                    for (int j = 0; j <subs.length ; j++) {
                        if(subs[j]!=null){
                            Point p=subs[j];
                            if(p.getNum()==-1){
                                p.setNum(j+1);
                                board[p.getX()][p.getY()]= (char) (j+1+48);
                                candi[p.getX()][p.getY()][0]=0;
                            }
                            subs[j]=null;
                        }
                    }
                }

                //check the column
                for (int i = 0; i <board.length ; i++) {
                    for (int j = 0; j <board.length ; j++) {
                        if(candi[j][i][0]!=0){
                            for (int k = 1; k <10 ; k++) {
                                if(candi[j][i][k]==0){
                                    if (subs[k-1]==null){
                                        subs[k-1]=new Point(j,i,-1);//so -1 means only one is ok
                                    }else {
                                        subs[k-1]=new Point(j,i,1);
                                    }
                                }
                            }
                        }
                    }
                    // what great is that there is the certains' size is zero
                    for (int j = 0; j <subs.length ; j++) {
                        if(subs[j]!=null){
                            Point p=subs[j];
                            if(p.getNum()==-1){
                                p.setNum(j+1);
                                board[p.getX()][p.getY()]= (char) (j+1+48);
                                candi[p.getX()][p.getY()][0]=0;
                            }
                            subs[j]=null;
                        }
                    }

                }

                for (int m = 0; m <board.length ; m=m+3) {
                    for (int n = 0; n <board.length ; n=n+3) {
                        for (int i = m; i <3+m ; i++) {
                            for (int j = n; j <n+3 ; j++) {
                                if(candi[i][j][0]!=0){
                                    for (int k = 1; k <10 ; k++) {
                                        if(candi[i][j][k]==0){
                                            if (subs[k-1]==null){
                                                subs[k-1]=new Point(i,j,-1);//so -1 means only one is ok
                                            }else {
                                                subs[k-1]=new Point(i,j,1);
                                            }
                                        }
                                    }
                                }

                            }
                        }
                        // samely,we check we are right
                        for (int j = 0; j <subs.length ; j++) {
                            if(subs[j]!=null){
                                Point p=subs[j];
                                if(p.getNum()==-1){
                                    p.setNum(j+1);
                                    board[p.getX()][p.getY()]= (char) (j+1+48);
                                    candi[p.getX()][p.getY()][0]=0;
                                }
                                subs[j]=null;
                            }
                        }

                    }

                }


            }
        }
        printBoard(board);

    }
    private static void testSyntax(){
        List<String> lines = Arrays.asList("spring", "node", "mkyong");

        List<String> result = lines.stream() 			//convert list to stream
                .filter(line -> !"mkyong". equals (line))	//filters the line, equals to "mkyong"
                .collect(Collectors.toList());			//collect the output and convert streams to fortheen List

        result.forEach(System.out::println);			//output : spring node


        int[] zeros=new int[10];
        DoArray.printIntArray(zeros);// if didn't set any number to int array, then it should be zeros

        //transfer the string to the char array



    }
    public static void main(String[] args) {
        char[][] board={{'5','3','.', '.','7','.', '.','.','.'},
                        {'6','.','.', '1','9','5', '.','.','.'},
                        {'.','9','8', '.','.','.', '.','6','.'},

                        {'8','.','.', '.','6','.', '.','.','3'},
                        {'4','.','.', '8','.','3', '.','.','1'},
                        {'7','.','.', '.','2','.', '.','.','6'},

                        {'.','6','.', '.','.','.', '2','8','.'},
                        {'.','.','.', '4','1','9', '.','.','5'},
                        {'.','.','.', '.','8','.', '.','7','9'}};
        String[] board2str={"..9748...",
                            "7........",
                            ".2.1.9...",
                            "..7...24.",
                            ".64.1.59.",
                            ".98...3..",
                            "...8.3.2.",
                            "........6",
                            "...2759.."};
        char[][] board2=new char[9][9];
        for (int i = 0; i <board2.length ; i++) {
            for (int j = 0; j <board2.length ; j++) {
                board2[i][j]=board2str[i].charAt(j);
            }
        }





        ThirtySeven ts=new ThirtySeven();
        ts.printBoard(board2);
        System.out.println("answer:");
        ts.solveSudoku(board2);

    }
}
