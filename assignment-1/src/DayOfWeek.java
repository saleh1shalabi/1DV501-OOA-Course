import java.util.Scanner;

class tEt {

    static Scanner inPut = new Scanner(System.in);

    public static Integer year(){   // input checker and returner
        
        boolean cheKc = false;
        String theOne;
        theOne = "";

        int x;
        while (cheKc == false)
        {   
            System.out.print("Enter year: ");

            theOne = inPut.next();

            try 
            {
                if(Integer.parseInt(theOne) < 0){
                    System.out.println("pleas enter a year over 0.");
                }
                else{
                    cheKc = true;
                }
            }

            catch (Exception e)
            { 
                System.out.println("invaild input");
                System.out.print("Try again! "); 
            }
        }
        x = Integer.parseInt(theOne);
		return x;
    }

    public static Integer month(){   // input checker and returner
        
        boolean cheKc = false;
        String theOne;
        theOne = "";

        int x;
        while (cheKc == false)
        {   
            System.out.print("Enter month (1-12): ");

            theOne = inPut.next();

            try 
            {
                if(Integer.parseInt(theOne) <= 0 || Integer.parseInt(theOne) >= 13){
                }
                else{
                    cheKc = true;
                }
            }

            catch (Exception e)
            { 
                System.out.println("invaild input");
                System.out.print("Try again! "); 
            }
        }
        x = Integer.parseInt(theOne);
		return x;
    }

    public static Integer day(){   // input checker and returner
        
        boolean cheKc = false;
        String theOne;
        theOne = "";

        int x;
        while (cheKc == false)
        {   
            System.out.print("Enter day of the month (1-31): ");

            theOne = inPut.next();
            try 
            {
                if(Integer.parseInt(theOne) <= 0 || Integer.parseInt(theOne) > 31){
                    System.out.println("Pleas day of month only between (1-31): ");
                }
                else{
                    cheKc = true;
                }
            }

            catch (Exception e)
            { 
                System.out.println("invaild input");
                System.out.print("Try again! "); 
            }
        }
        x = Integer.parseInt(theOne);
		return x;
    }



}



public class DayOfWeek {

    public static void main(String[] args) {

        System.out.println("Welcom to day counter!");
        System.out.println("=======================\n"); 
        

        
        System.out.println(counter(tEt.year(),tEt.month(),tEt.day()));
        

    }
  
    


    public static String counter(int year, int month, int day){
        // day counter
        String[] theDay = new String[7];
        
        theDay[0] = "Saturday";
        theDay[1] = "Sunday";
        theDay[2] = "Monday";
        theDay[3] = "Tuesday";
        theDay[4] = "Wednsday";
        theDay[5] = "Thursday";
        theDay[6] = "Friday";

        if (month == 1 || month == 2){
            month += 12;
            year -= 1;
        }
        
        

        int whatDay = (int) ((day + ( (26 / (double) 10) * (month + 1) ) + (year % 100) + ( (year % 100) / 4) + ( (year / 100) /4) + ((year/100)*5) ) % 7);

        
        


        return theDay[(whatDay)];

    }

}


















