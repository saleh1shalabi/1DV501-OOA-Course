import java.util.ArrayList;
import java.util.Scanner;

public class PrintCalendar {

    static int start = salih.counter(salih.year(), salih.month());  // user input getter
    public static void main(String[] args) {
        
        System.out.println();
        System.out.println();

        System.out.println(salih.monthToPrint + salih.year);
        System.out.println("==============================================================");

        var schema = creater();
     
        firstRow();
        adder(schema);

        // print empty place so if month starts on friday
        // it will be printed under friday and so on

        int just = salih.index;

        for (int c = 0; c < just; c++){
            System.out.print("          ");
    
        }

        printer(schema);

        System.out.println();
    }

    private static ArrayList<ArrayList> creater(){

        // this function is function that creats a list with 7 lists in it which will be the days
        // and return it 
        
        var table = new ArrayList<ArrayList>(7);
        
        for (int c = 0 ; c < 7; c++){
            table.add(c, new ArrayList<Integer>());
        }
      
        return table;
    }

    private static void firstRow() {
       // only printing weekdays

        ArrayList<String> days =  new ArrayList<String>();

        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednsday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");
        for(int c = 0; c < days.size(); c++)
            System.out.print(days.get(c) + "  ");
        System.out.println();

        System.out.println("==============================================================");

    }

    private static ArrayList adder(ArrayList<ArrayList> arse){

        // days adding to lists in a big list
        // each list of will be a dey and the date in this month that will be this day
        int just = start;
        for (int c = 1; c <= salih.what_mo(); c++){
            
            if (just == 7)
                just = 0;

            arse.get(just).add(c);    
            
            just += 1;
        }
        
        // because of the function day counter wich give value 0 for saturday and so on
        // and we want to start on monday
        // then the first to list (saturday and sunday) should move to the end 
        // and whopp it starts on monday now

        var lo = arse.get(0);
        var so = arse.get(1);
        arse.remove(0);
        arse.remove(0);
        arse.add(lo);
        arse.add(so);
		return arse;

    }

    private static void printer(ArrayList<ArrayList> arse){
        //this function will print out the days from each list
        // it will itterate throw the big list with all list 
        // printing the first value of each list then remobing it, when it hade printed 7 times
        // it jumps to new row

        int just = salih.index; // to get started in the list (day) that the month starts in 
        
        for (int c = 0 ; c < salih.what_mo();){
            
            for(int cc = just; cc < 7 ;cc++){
                int x = (int) arse.get(cc).get(0);
                String xx = String.valueOf(x);
                if(xx.length() == 1){
                    System.out.print(" " + arse.get(cc).get(0)+"        ");
                }
                else{
                    System.out.print(arse.get(cc).get(0)+"        ");
                }
                
                arse.get(cc).remove(0);   

                if(x == salih.what_mo()){
                    c++;
                    break;
                }    
                c++;
            }

            System.out.println();
            just = 0;
             
        }
    }	 
}

class salih {
    
    /* this class has the necessary functions to count   */

    static Scanner inPut = new Scanner(System.in);
    static int year;
    static int month;
    static String monthToPrint; 

    public static Integer year(){   // input checker and returner
        
        boolean cheKc = false;
        String theOne;

        theOne= "";

        int x;

        while (cheKc == false)
        {   
            System.out.print("Enter year after 1800: ");

            theOne = inPut.next();

            try 
            {
                if(Integer.parseInt(theOne) <= 1800){
                    System.out.println("pleas enter a year over 1800.");
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
        year = x;
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

        String[] the_month = new String[12];

        the_month[0] = "January: ";
        the_month[1] = "February: ";
        the_month[2] = "Mars: ";
        the_month[3] = "April: ";
        the_month[4] = "May: ";
        the_month[5] = "June: ";
        the_month[6] = "July: ";
        the_month[7] = "August: ";
        the_month[8] = "September: ";
        the_month[9] = "October: ";
        the_month[10] = "November: ";
        the_month[11] = "December: ";

        monthToPrint = the_month[x-1];
        month = x;

        return x;
    }

    public static int what_mo() {
        // this function will basicly return the length of given month 
        
        if (month == 2){
            if (leapChe())
                return 29;
            else
                return 28;
        }
        
        else if(month == 4 || month == 6 || month == 9 || month == 11){
            return 30;
        }
        else{
            return 31;
        }

    }


    public static boolean leapChe() {
    //     Leap Years are any year that can be exactly divided by 4
 	//  	except if it can be exactly divided by 100, then it isn't 
 	//  		except if it can be exactly divided by 400, then it is

        if (year % 4 == 0){

            if (year % 100 == 0){

                if (year % 400 == 0){
                    return true;
                }

                return false;
            } 
            return true;          
        }
        
        else
            return false;
    }

    static int index;

    public static int counter(int year, int month){
        
        // start day of month counter

        int day = 1;

        if (month == 1 || month == 2){
            month += 12;
            year -= 1;
        }
        
        int whatDay = (int) ((day + ( (26 / (double) 10) * (month + 1) ) + (year % 100) + ( (year % 100) / 4) + ( (year / 100) /4) + ((year/100)*5) ) % 7);

        String c = "2345601";
        String x = String.valueOf(whatDay);
        index = c.indexOf(x); // starting on monday will give index 0 and so on

        return whatDay; // this returns 0 as saturday

    }
}
