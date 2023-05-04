import java.util.Scanner;

public class Diamonds {

    public static void main(String[] args) {

        Scanner inPut = new Scanner(System.in);
        String hiGht = null;
        boolean cheKc = false;
        int tHi;

        while (cheKc == false)
        { 
            try 
            {
                System.out.print("Give a positive number: ");
                hiGht = inPut.nextLine();
                System.out.println("");

                Integer.parseInt(hiGht); // check if input is integer 
                tHi = Integer.parseInt(hiGht); 

                if (tHi == 0) // input larger than 0
                {
                    System.out.println("Please higher number to drow a diamond. negative to close");
                    
                }
                else if (tHi < 0){
                    cheKc = true;
                    System.out.println("Program closing!");
                }
                else
                {                    
                    tHi = Integer.parseInt(hiGht);
                    for (int c = 1;c <= (tHi); c+=1)
                    {
                        int y = (c*2)-1;
                        int x = c-1;
                        while (Math.floorDiv((tHi - x) , 2) > 0)
                        {
                            System.out.print(" ");
                            x += 1;
                        }
                        while(y != 0)
                        {
                            System.out.print("*");
                            y-= 1;
                        }
                        System.out.println("");
                    }
                    
                    for(int c = 1; c <= (tHi); c += 1){
                        int y = ((tHi-c)*2)-1;
                        int x = c;
                        while (x != 0)
                        {
                            System.out.print(" ");
                            x -= 1;
                        }
                        while((y-1) >= 0)
                        {
                            System.out.print("*");
                            y-= 1;
                        }
                        System.out.println("");   
                    }
                }
            }

            catch (Exception e)
            { 
                System.out.println("invaild input");
                System.out.print("Please Enter number using only digits (negative to close!): "); 
            }
        }
        inPut.close();
    }
    
}
