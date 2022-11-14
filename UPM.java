import java.util.*;
import java.util.Scanner; 
import  java.text.DecimalFormat;

class Main{
  
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    //int user_Input = 0;
    String user_Input = "0";

    //person array
    Person array[] = new Person[100];

    /*for(int i = 0; i < 100; ++i){
      array[i] = null;
    }
    */

    String[] student = new String[2];
    int student_hours = 0;
    double student_GPA = 0;
  
    String[] facultyInfo = new String[4];
    String[] staffInfo = new String[4];
    String tempStr;
        
    //sees if there is student input
    int tuitionTest = 0;
    
    //user id input to search person
    String choiceId;



    System.out.println("\n\t\t\tWelcome to my Personal Management Program");
    

    // menu with user input
    while(!"7".equals(user_Input)){
      System.out.println("\nChoose one of the following options: ");
      //System.out.println("\n");
      System.out.println("1- Enter the information of a faculty");
      System.out.println("2- Enter the information of a student");
      System.out.println("3- Print tuition invoice for a student");
      System.out.println("4- Print faculty information");
      System.out.println("5- Enter the information of a staff member");
      System.out.println("6- Print the information of a staff member");
      System.out.println("7- Exit Program");
      System.out.println("");
      System.out.print("\tEnter your selection: ");

      user_Input = scan.nextLine();

        switch (user_Input){

          case "1":     // Get Faculty Information

            getFaculty(scan, facultyInfo, array);

            break;
            
          case "2":     
            // Student Information User Input
            System.out.println("");
            System.out.println("Enter the student info:");
            System.out.println("");
            System.out.print("\t Name of Student: ");
            student[0] = scan.nextLine();
            System.out.println("");
            System.out.print("\t ID: ");
            student[1] = scan.nextLine();
            System.out.println("");
            System.out.print("\t Gpa: ");
            student_GPA = scan.nextDouble();
            System.out.println("");
            System.out.print("\t Credit hours: ");
            student_hours = scan.nextInt();
            System.out.println(""); 
            System.out.println("Student added!");
            tempStr = scan.nextLine();
            ++tuitionTest;

            //for loop check for avaible space in person array
            for(int i = 0; i < 100; ++i){
              if(array[i] == null){
                //new student object created
                Student student_class = new Student(student_GPA, student_hours);

                student_class.setName(student[0]);
                student_class.setId(student[1]);

                  //without contructor, but with setter method below
                //student_class.setGpa(student_GPA);
                //student_class.setcreditHours(student_hours);
                
                //array index set to initialized student object
                array[i] = student_class;
                break;
              }
            }
            //end of for loop
            break;
        
          case "3":     // Print Student Tuition

            if(tuitionTest == 0){
              System.out.println("");
              System.out.println("Sorry! No Student info added yet...");
              System.out.println("");
              break; 
            }
            System.out.println("");
            System.out.print("Enter the student's Id: ");
            choiceId = scan.nextLine();
            //user id input for search
            
            //checks if user input for student id is found
            boolean student_Found = false;

            //For loop to check if there were any students inputted 
            for(int i = 0; i < 100; ++i){
              if(array[i] == null){
                    break;
              }
              //if id found in array, print student 
              if((array[i].getId()).equals(choiceId)){
                array[i].printCheck();
                student_Found = true;
                break;
              }
            }

            //if no user id input found, no match
            if(!student_Found){
              System.out.println("No students matched!");
              System.out.println("");
            }

            break;

          case "4":   // Print Faculty Information
              //check if there is input
              if(facultyInfo[0] == null)
              {
                System.out.println("");
                System.out.println("Sorry! No Faculty member added yet...");
                System.out.println("");
              }
              else{
                System.out.println("");
                System.out.print("Enter the faculty's Id: ");
                choiceId = scan.nextLine();

                //checks if a id for faculty is found
                boolean facultyFound = false;

                //print given id in  person array
                for(int i = 0; i < 100; ++i){
                  //if none found exit
                  if(array[i] == null){
                    break;
                  }
                  //if id found in array, print
                  if((array[i].getId()).equals(choiceId)){
                    array[i].printCheck();
                    facultyFound = true;
                    break;
                  }
                }

                //if no faculty foundly, id no match
                if(!facultyFound){
                  System.out.println("No faculty matched!");
                  System.out.println("");
                } 
              }
            break;

          case "5":     // Staff User Input

            staff_Input(staffInfo, scan);
            
            //checks for avaible person array index
            for(int i = 0; i < 100; ++i)
            {
              if(array[i] == null)
              { 
                //create new staff object
                Staff staff_class = new Staff(staffInfo[3]);

                staff_class.setName(staffInfo[0]);
                staff_class.setId(staffInfo[1]);
                staff_class.setDepartment(staffInfo[2]);
                
                //set array index to initialized staff object
                array[i] = staff_class;
                break;
              }
            }
            //end of for loop
          
            break;

          case "6":   // Print Staff Information
              //check to see for input
              if(staffInfo[0] == null){
                System.out.println("Sorry! No Staff member added yet...");
                System.out.println("");
              }
              else
              {
                System.out.println("");
                System.out.print("Enter the staff member's Id: ");
                choiceId = scan.nextLine();
                //user id input for search
                
                //sees if staff is found
                boolean staff_Found = false;

                //For loop to check if staff id inputted matches to any on record
                for(int i = 0; i < 100; ++i)
                {
                  //if none found exit
                  if(array[i] == null)
                  {
                        break;
                  }
                  //if id found in array print
                  if((array[i].getId()).equals(choiceId))
                  {
                    array[i].printCheck();
                    staff_Found = true;
                    break;
                  }
                }
                //end of for loop

                //if no staff found print no staff matched
                if(!staff_Found)
                {
                  System.out.println("");
                  System.out.println("No staff members matched!");
                  System.out.println("");
                }
              }
            break;
            
          case "7":   // Exit Case
            System.out.println("");
            System.out.println("Goodbye........");
            System.exit(0);
            break;

          default:   // Error Message
            System.out.println("");
            System.out.println("Invalid entry - please try again");
        

        }
      //end of switch statement

    }
    //end of menu while loop

  }
  //end of main function



  //faculty input info function
  public static void getFaculty(Scanner scan, String[] s, Person[] array){
    //String tempStr;
    String rankInfo, deparInfo;
    int loop = 0;
    int loop2 = 0;

    // User Input
    System.out.println("");
    System.out.println("Enter faculty info: ");
    System.out.println("");
    System.out.print("\t Name of faculty: ");
    //tempStr = scan.nextLine();
    s[0] = scan.nextLine();
    System.out.println("");
    System.out.print("\t ID: ");
    s[1] = scan.nextLine();
    System.out.println("");

    //checks for correct input 
    while(loop != 1)
    {
      System.out.print("\t Rank: ");
      rankInfo = scan.nextLine();

      // Limits User Input for Rank
      if(rankInfo.equalsIgnoreCase("professor") || rankInfo.equalsIgnoreCase("adjunct"))
      {
        s[2] = rankInfo;
        loop++;
      }
      else
      {
        // Error Message
        System.out.println("\t\t\"" + rankInfo + "\"" + " is invalid");
        System.out.println("");
      }
    }
    //end of while loop
    
    System.out.println("");

    //checks for correct input
    while(loop2 != 1)
    {
      System.out.print("\t Department: ");
      deparInfo = scan.nextLine();

        // Limits User Input for Department
        if(deparInfo.equalsIgnoreCase("mathematics") || deparInfo.equalsIgnoreCase("engineering") || deparInfo.equalsIgnoreCase("english") )
        {
          s[3] = deparInfo;
          loop2++;
        }
        else
        {
          // Error Message
          System.out.println("\t\t\"" + deparInfo + "\"" + " is invalid");
          System.out.println("");
        }
    }
    //end of while loop


    //For loop to set the name, id, title, and department of the faculty class
    for(int i = 0; i < 100; ++i){
        if(array[i] == null){
        
        //create new faculty object to hold values
        Faculty faculty_class = new Faculty();
                
        faculty_class.setName(s[0]);
        faculty_class.setId(s[1]);
        faculty_class.setTitle(s[2]);
        faculty_class.setDepartment(s[3]);

        //faculty object set to array index
        array[i] = faculty_class;         

        break;
      }
    }
    //end of for loop
    
    System.out.println("");
    
    System.out.println("Faculty seccessfully added!");

  }
//end of faculty info function


  //staff input function
  public static void staff_Input(String staffInfo[], Scanner scan){
    boolean depart = false;
    boolean depart2 = false;

    System.out.println("");
    System.out.print("Name of the staff member: ");
    staffInfo[0] = scan.nextLine();

    System.out.println("");

    System.out.print("Enter the id: ");
    staffInfo[1] = scan.nextLine();

    System.out.println("");
    
    //while loop to check for correct input
    while(depart != true){
      System.out.print("Department: ");
      staffInfo[2] = scan.nextLine();
      
      //user input for department will be checked for correct input
      if(staffInfo[2].equalsIgnoreCase("mathematics") || staffInfo[2].equalsIgnoreCase("engineering") || staffInfo[2].equalsIgnoreCase("english")){
        depart = true;
      }
      else{
        System.out.print("\t\"" + staffInfo[2] + "\" is invalid");
        System.out.println("");
        System.out.println(""); 
      }
    }
    //end of while loop
    System.out.println("");
    
    //user input for working time will be checked for right input
    while(depart2 != true){
      System.out.print("Status, enter P for Part Time or Enter F for full time: ");
      staffInfo[3] = scan.nextLine();
      if(staffInfo[3].equalsIgnoreCase("p") || staffInfo[3].equalsIgnoreCase("f") ){
        depart2 = true;
      }
      else{
        System.out.println("\t\"" + staffInfo[3] + "\" is invalid");
        System.out.println("");
      }
    }
    //end of while loop

    System.out.println("");
    System.out.println("");

    System.out.println("Staff member added!");
    System.out.println("");
  }
  //end of staffinput function


}

// Start of Classes 

abstract class Person{
  
  protected String name; 
  protected String personId;

  //DEFAULT Constructor
  public Person(){
    name = "No Name";
    personId = "No ID";
  }

  // Overloaded Constructor
  public Person(String name, String personId){
    this.name = name;
    this.personId = personId;
  }
  
  //name getter method
	public String getName(){
    return name;
  }

  //name setter method
	public void setName(String name) {
		this.name = name;
	}

  //id getter method
  public String getId(){
    return personId;
  }

  //if setter method
	public void setId(String personId) {
		this.personId = personId;
	}
  
  //abstract print method (means other sub classes has to have this method)
  public abstract void printCheck();
	
}
///////////////////////////////////////////////////////////////
 class Student extends Person{

  private int creditHours;
  private double gpa;

  private final double C_HOUR = 236.45; 
  private double tuition;
  private double tuitionDiscounted, discount;
  
  //default constructor
  public Student(){
    creditHours = -1;
    gpa = -1;
  }
  
  //overloaded constructor
  public Student(double gpa, int creditHours){
    this.gpa = gpa;
    this.creditHours = creditHours;
  }

  //gpa setter method
  public void setGpa(double gpa){
    this.gpa = gpa;
  }

  //credit hour setter method
  public void setcreditHours(int creditHours){
    this.creditHours = creditHours;
  }

  //gpa getter method 
  public double getGpa(){
    return gpa;
  }

  //credit hour getter method
  public int getcreditHours(){
    return creditHours;
  }

  //print method 
  @Override
  public void printCheck(){    

    // Decimal format to look like money
    String pattern = "###,###.00";
    DecimalFormat decimalFormat = new DecimalFormat(pattern);

    // Printing Hours and Fees
    System.out.println("");
    System.out.println("Here is the tuition invoice for " + name + ": ");

        System.out.println("----------------------------------------------------------------------");
        System.out.println(name + "\t\t\t" + personId);
        System.out.println("Credit Hours: " + creditHours + " \t($236.45/credt hour)");
        System.out.println("Fees: $52");
        System.out.println("");

        // Tuition calculation
        tuition = C_HOUR * creditHours;
        tuition += 52.0;
        
        // Discount calculation
        discount = tuition * 0.15;
        tuitionDiscounted = tuition - discount; 

        // Formatting so it looks like money (1,111.11)
        String total1 = decimalFormat.format(tuition);
        String totalWithD1 = decimalFormat.format(tuitionDiscounted);
        String disc1 = decimalFormat.format(discount);

        // Checking for discount critera and printing
        if (gpa >= 3.85)
        {
          System.out.println("Total payment (after discount): $" + totalWithD1 + "\t\t\t" + "($" + disc1 + " discount applied)");
        }
        else
        {
          System.out.println("Total payment (after discount): $" + total1 + "\t\t\t" + "($0 discount applied)");
        }
        System.out.println("----------------------------------------------------------------------");
  }
  
}

///////////////////////////////////////////////////////////

 abstract class Employee extends Person{

  protected String department;

  //getters method
  public String getDepartment(){
    return department;
  }

  //setter method
  public void setDepartment(String department){
    this.department = department;
  }

  //overloaded constructor
  public Employee(String department){
    this.department = department;
  }
  
  //default contructor
  public Employee(){
    department = "";
  }

  @Override
  abstract public void printCheck();

}

//////////////////////////////////////////////////////

 class Faculty extends Employee{

  private String title;     //faculty rank

  //make first letter cap
  private String rankCap;
  private String deparCap;


  //rank Getters method
  public String getTitle(){
    return title;
  }

  //rank setter method
  public void setTitle(String title){
    this.title = title;
  }

  //Overloaded constructor
  public Faculty(String title){
    this.title = title;
  }

  //Default constructor
  public Faculty(){
    title = "";
  }

  @Override
  // Function that prints faculty information
  public void printCheck(){ 
    
    //Converts department and title to lower case then capitalizes the first letter.
    title = title.toLowerCase();
    rankCap = title.substring(0,1).toUpperCase() + title.substring(1);
    
    department = department.toLowerCase();
    deparCap = department.substring(0,1).toUpperCase() + department.substring(1);
     
    System.out.println("");
    System.out.println("------------------------------------------------------------");
    System.out.println("" + name + "\t\t\t" + personId);
    System.out.println(deparCap + " Department, " + rankCap);
    System.out.println("------------------------------------------------------------");
    System.out.println("");
  }
  

}

///////////////////////////////////////////////////

 class Staff extends Employee{

  private String status;  //employee status 

  //overloaded constructor
  public Staff(String status){
    this.status = status;
  }

  //default constructor
  public Staff(){
    status = "No status";
  }

  //status getter method
  public String getStatus(){
    return status;
  }


  //status setter method
  public void setStatus(String status){
    this.status = status;
  }

  //print method for staff
  @Override
  public void printCheck(){ 

    if(this.status.equals("P") || this.status.equals("p")){
      this.status = "Part-time";
    }
    else{
      this.status = "Full-time";
    }
    //adjusts users input to print full term for output
    
    //changes department wording to only have first letter capitalized
    this.department = this.department.toLowerCase(); 
    String deparCap = this.department.substring(0,1).toUpperCase() + this.department.substring(1);

    System.out.println("");
    System.out.println("------------------------------------------------------------");
    System.out.println("" + this.name + "\t\t\t" + this.personId);
    System.out.println(deparCap + " Department, " + this.status);
    System.out.println("------------------------------------------------------------");
    System.out.println("");
  

  }
}
