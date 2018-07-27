package zero;

/**
 * Created by olddriver on 17-3-23.
 * checkbox's size should be 9
 */

/** others' answer haven't been read
 * */
public class ThirtySix {
    public boolean isValidSudoku(char[][] board) {



        //check the row    write the sub-program find out is there,make fortheen array length 9
        boolean []checkbox=new boolean[10];
        for(char[]a:board){
            for (char b:a){
               if(b!='.'){
                    int index= b-48;
                    if(!checkbox[index]){
                        checkbox[index]=true;
                    }else{
                        return false;
                    }
                }
            }
            checkbox = new boolean[10];
        }
        //chcek the columu
        for (int i = 0; i <board.length; i++) {
            for (int j = 0; j <board.length ; j++) {
                char b=board[j][i];
                if(b!='.'){
                    int index= b-48;
                    if(!checkbox[index]){
                        checkbox[index]=true;
                    }else{
                        return false;
                    }
                }
            }
            checkbox = new boolean[10];
        }
        //check the box
        for (int i = 0; i <board.length ; i=i+3) {
            for (int j = 0; j <board.length ; j=j+3) {
                //now the (i j) is the left up corner for the box
                for (int k = i; k <i+3 ; k++) {
                    for (int l = j; l <j+3 ; l++) {
                        char b=board[k][l];
                        if(b!='.'){
                            int index= b-48;
                            if(!checkbox[index]){
                                checkbox[index]=true;
                            }else{
                                return false;
                            }
                        }
                    }
                }
                checkbox = new boolean[10];
            }
        }
        return true;
    }
    public void testSyntax(){
        System.out.println('9'-48);
        System.out.println('.');
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
        ThirtySix ts=new ThirtySix();
        ts.testSyntax();
        System.out.println(ts.isValidSudoku(board));
    }
}
