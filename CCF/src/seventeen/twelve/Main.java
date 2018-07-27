package seventeen.twelve;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;


public class Main {
    private int[] accumulateDays;
    class Time implements Comparable<Time>{
        int year;
        int month;
        int day;
        int hour;

        public Time(int year, int month, int day, int hour, int minute) {
            this.year = year;
            this.month = month;
            this.day = day;
            this.hour = hour;
            this.minute = minute;
        }

        @Override
        public String toString() {
            return
                    "" + year +
                            "" + month +
                            "" + day +
                            "" + hour +
                            "" + minute;
        }
        int minute;

        // sort by the time
        @Override
        public int compareTo(Time o) {
            return 0;
        }
    }
    LinkedList<String> commands;
    class Output implements Comparable<Output>{
        Time time;
        String command;

        @Override
        public int compareTo(Output o) {
            if(time.compareTo(o.time) < 0) return -1;
            if(time.compareTo(o.time) > 0) return  1;
            // so the commands appear first will print first !
            return commands.indexOf(command) - commands.indexOf(command);
        }
    }
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        Main main = new Main();
        main.three();
    }


    private void three() throws URISyntaxException, FileNotFoundException {
        URL url = Main.class.getResource("/input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in

        // year month day is is what ?
        // 1970 zero and then
        accumulateDays = new int[2100];
        for (int i = 1971; i <= 2099; i++) {
            accumulateDays[i] = accumulateDays[i - 1] + yearDays(i);
        }

        int N = in.nextInt();
        long start = in.nextLong();
        long end = in.nextLong();
        Time S = getDate(start);
        Time E = getDate(end);
        in.nextLine();


        int thisYear = S.year;

        // contains the time
        // read item's separate all the time and added new Class and print it !
        for (int i = 0; i < N; i++) {
            String str = in.nextLine();
            String[] slices = str.split(" ");
            // min
            LinkedList<Integer> mins = new LinkedList<>();
            if(slices[0].equals("*")){
                for (int j = 0; j < 60; j++) {
                    mins.add(j);
                }
            }else{
                String[] parts = slices[0].split(",");
                for(String s: parts){
                    if(s.indexOf('-') > 0){
                        //
                        int left = Integer.valueOf(s.split("-")[0]);
                        int right = Integer.valueOf(s.split("-")[1]);
                        for(int k = left; k <= right; k ++){
                            mins.add(k);
                        }
                    }else{
                        mins.add(Integer.valueOf(s));
                    }
                }
            }


            // hour
            LinkedList<Integer> hours = new LinkedList<>();
            if(slices[1].equals("*")){
                for (int j = 0; j < 24; j++) {
                    hours.add(j);
                }
            }else{
                String[] parts = slices[1].split(",");
                for(String s: parts){
                    if(s.indexOf('-') > 0){
                        //
                        int left = Integer.valueOf(s.split("-")[0]);
                        int right = Integer.valueOf(s.split("-")[1]);
                        for(int k = left; k <= right; k ++){
                            hours.add(k);
                        }
                    }else{
                        hours.add(Integer.valueOf(s));
                    }
                }
            }
            // days

            LinkedList<Integer> days = new LinkedList<>();
            if(slices[2].equals("*")){
                for (int j = 1; j <= 31; j++) {
                    days.add(j);
                }
            }else{
                String[] parts = slices[2].split(",");
                for(String s: parts){
                    if(s.indexOf('-') > 0){
                        //
                        int left = Integer.valueOf(s.split("-")[0]);
                        int right = Integer.valueOf(s.split("-")[1]);
                        for(int k = left; k <= right; k ++){
                            days.add(k);
                        }
                    }else{
                        days.add(Integer.valueOf(s));
                    }
                }
            }
            // month

            LinkedList<Integer> months = new LinkedList<>();
            if(slices[3].equals("*")){
                for (int j = 1; j <= 31; j++) {
                    months.add(j);
                }
            }else{
                String[] parts = slices[3].split(",");
                for(String s: parts){
                    if(s.indexOf('-') > 0){
                        //
                        int left = Integer.valueOf(s.split("-")[0]);
                        int right = Integer.valueOf(s.split("-")[1]);
                        for(int k = left; k <= right; k ++){
                            months.add(k);
                        }
                    }else{
                        months.add(Integer.valueOf(s));
                    }
                }
            }
            // day of week
            LinkedList<Integer> weeks = new LinkedList<>();
            if(slices[4].equals("*")){
                for (int j = 1; j <= 6; j++) {
                    weeks.add(j);
                }
            }else{
                String[] parts = slices[4].split(",");
                for(String s: parts){
                    if(s.indexOf('-') > 0){
                        int left = Integer.valueOf(s.split("-")[0]);
                        int right = Integer.valueOf(s.split("-")[1]);
                        for(int k = left; k <= right; k ++){
                            weeks.add(k);
                        }
                    }else{
                        weeks.add(Integer.valueOf(s));
                    }
                }
            }
        }

        // merge all the data


    }
    // 0-6 return
    // year's days accumulate !
    private int data(int year, int month, int day){
        int feb;
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            feb = 29;
        }else{
            feb = 28;
        }
        int[] monthDays = new int[] {31, feb, 31, 30, 31, 30, 31, 31, 30, 31, 30};

        int days = accumulateDays[year];
        for (int i = 0; i < month - 1; i++) {
            days += monthDays[i];
        }

        days += day;

        days = (days + 3) % 7;

        return days;
    }

    private int yearDays(int year){
        int feb;
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            feb = 29;
        }else{
            feb = 28;
        }
        int[] month = new int[] {31, feb, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        int sum = 0;
        for(int i: month){
            sum += i;
        }
        return sum;
    }

    private Time getDate(long start){
        int MM = (int)(start % 100);
        start = start / 100;
        int hh = (int)(start % 100);
        start = start / 100;
        int dd = (int)(start % 100);
        start = start / 100;
        int mm = (int)(start % 100);
        start = start / 100;
        return new Time((int)start, mm, dd, hh, MM);
    }
}

