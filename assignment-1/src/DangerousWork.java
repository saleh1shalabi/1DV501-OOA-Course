import java.util.Scanner;

public class DangerousWork {
    
    public static void main(String[] args) {

        Scanner inPut = new Scanner(System.in);
        System.out.print("How much would you like to earn? ");
        String money = null;
        boolean cheKc = false;
        float mn;

        while (cheKc == false)
        { 
            try 
            {
                money = inPut.nextLine();
                Float.parseFloat(money); // check if input is integer 
                mn = Float.parseFloat(money); 

                if (mn <= 0) // input larger than 0
                {
                    System.out.println("Please higher number!");
                    
                    System.out.print("Please Enter amount using only digits: sajkas");
                }
                else
                {
                    cheKc = true;   
                    mn = Float.parseFloat(money);
                    int counter = 0;
                    while (mn >= 0.01 ){
                        counter += 1;
                        mn = (mn/2);
                    }                    
                    if (counter > 30)
                        System.out.println("You will be lost and you cant work this long");
                    else
                        System.out.println("You will have your money in " + counter + " days.");
                }
            }

            catch (Exception e)
            { 
                System.out.println("invaild input");
                System.out.print("Please Enter amount using only digits: "); 
            }
        }
        inPut.close();
    }
}