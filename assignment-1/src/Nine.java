import java.util.Random;
import java.util.Scanner;


class te {

    static Scanner inPut = new Scanner(System.in);

    public static boolean che(){   // input checker

        boolean cheKc = false;
        String play;
        while (cheKc == false)
        {   
            play = inPut.next();

            if (play.length() != 1)
            {
                System.out.println("Only Answer with  Y or N");
            }
            else if (play.length() == 1)
            {
                if ( play.equals("n") || play.equals("N"))
                {return cheKc;}
                else if (play.equals("y") || play.equals("Y"))
                {
                    cheKc = true;
                }
                else
                    System.out.println("Inavild, Try again!");
            } 
            else
                System.out.println("Wrong2"); 
        }
        return cheKc;
    }

}

public class Nine {

    public static int generator(){ // random number between 1 and 6

        Random rand = new Random();
        int num = rand.nextInt(6); // between 0 and 5
        num += 1;   // add one it will be from 1 to 6
        return num;
    }

    public static void main(String[] args){

        
        System.out.println("Playing a game");
        System.out.println("===============");
        System.out.println("");
        System.out.println("Ready to play?  (Y/N)");
        
        
        if (te.che())
        {
            int firstTry = generator();
            int secondTry = 0;

            int compFirst = 0;

            int compSecond = 0;

            System.out.println("You rolled " + firstTry);
            System.out.println("Would you like to roll again? (Y/N)");

           
            
            
            
            if (te.che()) 
            {
                secondTry = generator();
                System.out.println("you rolled " + secondTry + " in total you have " + (firstTry + secondTry));
                
                compFirst = generator();
                System.out.println("The computer rolled " + compFirst);

                if (compFirst <= 4)
                {
                    compSecond = generator();
                    System.out.println("The computer rolls again and gets " + compSecond + " in total" + (compFirst + compSecond ));
                }

                else 
                {
                    System.out.println("The computer rolled once!");     
                }
            }
 
            else
            {
                System.out.println("you rolled once and got " + firstTry );
                compFirst = generator();
                compSecond = 0;
                System.out.println("The computer rolled " + compFirst);

                if (compFirst <= 4)
                {
                    compSecond = generator();
                    System.out.println("The computer rolls again and gets " + compSecond + " in total" + (compFirst + compSecond ));
                }

                else
                {
                    System.out.println("The computer rolled once!");
                }
            }

            if ((firstTry + secondTry) > 9)
            {
                System.out.println("You got more than 9");
                System.out.println("unfortunately you lose!");
            }
            else if ((compFirst + compSecond) > 9 )
            {
                System.out.println("The computer got " + (compFirst + compSecond) + ", it is more than 9");
                System.out.println("You Won!");
            }

            else if ((firstTry + secondTry) > (compFirst + compSecond))
            {
                System.out.println("You Won!");
            }
            else if ((firstTry + secondTry) < (compFirst + compSecond))
            {
                System.out.println("You lose!");
            }

            else
            {
                System.out.println("You and the computer got the same resulte");
            }
        }
        else
        {
            System.out.println("Exiting Game");
            System.exit(0);
        }
	}
}







