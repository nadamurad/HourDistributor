import java.util.*;
public class SortNameAndHours {
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        introHeader();
        Vector<EmployeeHours> eh = new Vector<>();
        System.out.print("How many employees work at your store? ");
        int employees = input.nextInt();
        //creates array of employees with their info
        for (int i =0;i<employees;i++){
            System.out.print("Employee " + (i+1) + "'s First Name? ");
            String fName = input.next();
            System.out.print("Employee " + (i+1) + "'s Last Name? ");
            String lName = input.next();
            System.out.print("Employee " + (i+1) + "'s Max hours? ");
            int mHours = input.nextInt();
            EmployeeHours e = new EmployeeHours(fName,lName,mHours);
            eh.add(i,e);
            EmployeeHours.daysAvailable(e);
            System.out.println("==============================================");
        }
        EmployeeHours [] employeeArray = new EmployeeHours[employees];
        eh.copyInto(employeeArray);
        System.out.println("Employees listed by their hours: ");
        Collections.sort(eh);
        //display employee list sorted by hours
        System.out.println(eh + "\b");
        EmployeeHours emp = eh.get(0);

        EmployeeHours.printMap(emp);

    }
    //intro
    public static void introHeader(){
        System.out.println("Hello! We will begin by listing the employees and their maximum hours for the week");
    }
}
