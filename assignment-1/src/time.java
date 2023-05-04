import java.util.Scanner;


public class time {
        
    public static void main(String[] args){

         Scanner inPut = new Scanner(System.in);
         System.out.print("Give a number of seconds:");
         String tid = null;
         boolean cheKc = false;
         int tm;

         while (cheKc == false)
        { 
            try 
            {
                tid = inPut.nextLine();
                Integer.parseInt(tid); // check if input is integer 
                tm = Integer.parseInt(tid); 

                if (tm < 0) // input larger than 0
                {
                    System.out.println("Please higher number!");
                    
                    System.out.print("Please Enter time using only digits: ");
                }
                else
                    cheKc = true;   
            }

            catch (Exception e)
            { 
                System.out.println("invaild input");

                System.out.print("Please Enter time using only digits: ");
            }
        }


        tm = Integer.parseInt(tid);
      
        int timmar = (tm / 3600);
        tm = (tm - (timmar*3600));
        int minuter = (tm / 60);
        tm = (tm - (minuter*60));
        int seconds = tm;
        
         System.out.println("This corresponds to:" + timmar + " hours, " + minuter +" minutes and "+ seconds +" seconds.");

         inPut.close();
    
    }
}
