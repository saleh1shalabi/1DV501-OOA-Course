import java.util.Random;
import java.util.Scanner;

public class GameSRP{   
    public static void main(String[] args){
        Random valeu = new Random();
        int me = 0;
        int dator = 0;
        int drow = 0;
           String[] SRP = new String[3];  
   
           SRP[0] = "Scissor";  
           SRP[1] = "rock";  
           SRP[2] = "paper";  
           System.out.println("Game Start!");
           System.out.println("===========");
           System.out.println("");


           int  x = 0;
            while (x != 100){
                System.out.println("Scissor (1), rock (2), paper (3) or 0 to quit:");
                System.out.println("");

                x = tet.che() ;
                if (x == 100){
                    System.out.println("Score: " + me + " (you) " + dator + " (computer) " + drow + " (draw).");
                    System.out.println("Closing...");
                }
                else{
                    int ra = valeu.nextInt(4);
                    
                    while(ra == 0) 
                        ra = valeu.nextInt(4);


                    if (x == ra){
                        drow += 1;
                        System.out.println("It's a draw!");

                    }
                    else if (x == 1 && ra == 3 || x == 2 && ra == 1 || x == 3 && ra == 2){
                        me += 1;
                        System.out.println("You won!, computer had " + SRP[(ra-1)] + "!");
                    }

                    else if (x == 1 && ra == 2 || x == 2 && ra == 3 || x == 3 && ra == 1){
                        dator += 1;
                        System.out.println("computer won!, computer had " + SRP[(ra-1)] + "!");
                }
            }
        }   
    }
}

class tet {

    static Scanner inPut = new Scanner(System.in);

    public static Integer che(){   // input checker and returner

        boolean cheKc = false;
        String play;
        while (cheKc == false)
        {   
            play = inPut.next();

            if (play.length() != 1)
            {
                System.out.println("Only Answer with (1), (2), (3)");
            }
            else if (play.length() == 1)
            {
                if ( play.equals("1")){
                    cheKc = true;
                    return 1;
                }                
                else if (play.equals("2"))
                {
                    cheKc = true;
                    return 2;
                }
                else if (play.equals("3"))
                {
                    cheKc = true;
                    return 3;
                }
                else if (play.equals("0"))
                {
                    cheKc = true;
                    return 100; // close code 
                }
                else{
                    System.out.println("Inavild, Try again!");
                }
            } 
            else{
                System.out.println("Wrong2"); 
            }
    }
		return null;

    }
}










