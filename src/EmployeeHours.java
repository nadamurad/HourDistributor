
import java.util.*;

public class EmployeeHours implements Comparable<EmployeeHours>{
    private String firstName, lastName;
    private int hours;
    //string is day name, integer is hours
    public static Map<String, int[]> hoursAvailable = new HashMap<String, int[]>();
    //constructor
    public EmployeeHours(String firstName, String lastName, int hours){
        this.firstName=firstName;
        this.lastName=lastName;
        this.hours=hours;
    }
    //setter and getter methods
    public int getHours(){return hours;}
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public Map<String, int[]> getHoursAvailable(){return hoursAvailable;}
    public void setFirstName(String firstName){this.firstName=firstName;}
    public void setLastName(String lastName){this.lastName=lastName;}
    public void setHours(int hours){this.hours=hours;}
//    public int[] getTimes(Map<String, int[]> hoursAvailable){
//
//    }
    //reset days available
    public void resetDays(){
        hoursAvailable.clear();
    }
    //will sort list by hours
    public int compareTo(EmployeeHours h){
        if(this.hours>h.getHours()){
            return 1;
            //return 1 if greater than
        }
        if(this.hours<h.getHours()){
            return -1;
            //return -1 if less than
        }
        else return 0;
        //return 0 if equal
    }
    //overridden toString displays first name last name and hours
//    public String toString(){
//        return String.format("\b\b%16s : \t%3d\n",(getFirstName()+ " " + getLastName()),getHours());
//    }
    public static void printMap(EmployeeHours e){
        for (String day: hoursAvailable.keySet()){
            String key = day.toString();
            int[] value = hoursAvailable.get(key);
            System.out.println(key + ": " + Arrays.toString(value));
        }
    }
    public static Map<String,int[]> daysAvailable(EmployeeHours e){
        System.out.println("What days is " + e.getFirstName() + " available?");
        Scanner input = new Scanner(System.in);
        String days = input.nextLine();
        boolean [] daysAv = new boolean[7];
        //monday
        if(days.contains("monday")||days.contains("Monday")){
            System.out.println("What time on Monday is " + e.getFirstName() + " available?");
            String av = input.nextLine();
            int [] fromTo = getTimeAvailable(av,e);
            hoursAvailable.put("Monday",fromTo);
        }
        //tuesday
        if(days.contains("tuesday")||days.contains("Tuesday")){
            System.out.println("What time on Tuesday is " + e.getFirstName() + " available?");
            String av = input.next();
            int [] fromTo = getTimeAvailable(av,e);
            hoursAvailable.put("Tuesday",fromTo);
        }
        //wednesday
        if(days.contains("wednesday")||days.contains("Wednesday")){
            System.out.println("What time on Wednesday is " + e.getFirstName() + " available?");
            String av = input.next();
            int [] fromTo = getTimeAvailable(av,e);
            hoursAvailable.put("Wednesday",fromTo);
        }
        //thursday
        if(days.contains("thursday")||days.contains("Thursday")){
            System.out.println("What time on Thursday is " + e.getFirstName() + " available?");
            String av = input.next();
            int [] fromTo = getTimeAvailable(av,e);
            hoursAvailable.put("Thursday",fromTo);
        }
        //friday
        if(days.contains("friday")||days.contains("Friday")){
            System.out.println("What time on Friday is " + e.getFirstName() + " available?");
            String av = input.next();
            int [] fromTo = getTimeAvailable(av,e);
            hoursAvailable.put("Friday",fromTo);
        }
        //saturday
        if(days.contains("Saturday")||days.contains("saturday")){
            System.out.println("What time on Saturday is " + e.getFirstName() + " available?");
            String av = input.next();
            int [] fromTo = getTimeAvailable(av,e);
            hoursAvailable.put("Saturday",fromTo);
        }
        //sunday
        if(days.contains("sunday")||days.contains("Sunday")){
            System.out.println("What time on Sunday is " + e.getFirstName() + " available?");
            String av = input.next();
            int [] fromTo = getTimeAvailable(av,e);
            hoursAvailable.put("Sunday",fromTo);
        }
        return hoursAvailable;
    }
    //method that will get the time available
    public static int[] getTimeAvailable(String time,EmployeeHours e){
        //takes user input 'time' that will split into an array
        String[] hrs = time.split(" ");
        int [] hours = new int[2];
        //take numbers from array, should be 2 numbers that will be placed in array 'hours'
        String s = "1";
//        for (int i = 0;i<hrs.length;i++){
//            if (hrs[i].contains(k)||hrs[i].contains("2")||hrs[i].contains("3")||hrs[i].contains("4")||hrs[i].contains("5")||hrs[i].contains("6")||hrs[i].contains("7")||hrs[i].contains("8")||hrs[i].contains("9")||hrs[i].contains("10")||hrs[i].contains("11")||hrs[i].contains("12")){
//                hours[j] = i;
//                j++;
//            }
//        }
        //put into array
        int i = 0;
        for (int j=0;j<hrs.length;j++){
            if(hrs[i].contains(s)){
                hours[j]=Integer.parseInt(s);
            }
            s=Integer.toString(Integer.parseInt(s)+1);
        }

        //make difference in hours positive if negative
        //count difference in hours
        int hr1=hours[1];
        int hr2=hours[0];
        if(hours[1]>1&&hours[1]<9){
            hr1=hours[1]+12;
        }
        if(hours[0]>1&&hours[0]<9){
            hr2=hours[1]+12;
        }
        int posHours = (hr1-hr2);
        if (posHours<0){
            posHours=-posHours;
        }
        int [] fromTo = new int[posHours+2];
        int k =0;
        //populating array with hours
        //all hours
        if(hours[1]>hours[0]){
            for (int f = hours[0]; f<= hours[1]&& f<12;f++){
                fromTo[k]=f;
                k++;
            }
        }
        int l = 0;
        if(hours[0]>hours[1]){
            for (int f = hours[0]; f<= (hours[1]+12);f++){
                fromTo[l]=f;
                if(fromTo[l]>12){
                    fromTo[l]=fromTo[l]-12;
                }
                l++;
            }
        }
        return fromTo;
    }
}
