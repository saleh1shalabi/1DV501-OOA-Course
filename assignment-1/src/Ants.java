
import java.util.ArrayList;
import java.util.Random;


public class Ants {


    

	public static int one_time() {
    
        // the simulation       
        
        ArrayList<ArrayList> bordet = null;

        bordet = theBoard.creater(theBoard.creater_2());  // creatin the board
        
        var y = whereAnt.wheHight(); // random place 
        var x = whereAnt.wheWidth(); // random place 

        var X = bordet.get(x);
        var Y = X.get(y);
        if ((int) Y == 0){
            X.set(y, 1);
        }
        else{
            X.set(y, (int) Y+1);
        }


        boolean checks = theBoard.Checker(bordet);
        while(checks){
            int dira = whereAnt.dira();

            if(dira == 0 && x == 0 || dira == 1 && x == 7)
                continue;
            else if (dira == 2 && y == 0 || dira == 3 && y == 7)
                continue;
            else if(dira == 0)
                x -= 1;
            else if(dira == 1)
                x += 1;
            else if(dira == 2)
                y -= 1;
            else if (dira == 3)
                y += 1;

            else
                continue;

            X = bordet.get(x);
            Y = X.get(y);

            X.set(y, (int) Y +1);
            
            checks = theBoard.Checker(bordet);

        }

        System.out.println(theBoard.counter(bordet));
        
        
        return theBoard.counter(bordet);
    }

   public static void main(String[] args) {
        
        int time = 0;
        double avr = 0;
        System.out.println("\nANTS");
        System.out.println("=====\n");


        
        while (time != 10){
            time += 1;

            System.out.print("Number of steps in simulation " + time + " : ");
            avr += one_time();
        }
        System.out.println("\nAverage amount of steps: " + (avr / 10));
        
    }


}


class theBoard{


    
    public static ArrayList<ArrayList> creater_2(){

        // the creater_2 function is function that creats a list with 8 lists in it 
        // and return it 

        
        var board = new ArrayList<ArrayList>(7);
        

        for (int c = 0 ; c < 8; c++){
            board.add(c, new ArrayList<ArrayList>(7));
        }
        
        
      
        return board;
    }
 
    public static ArrayList<ArrayList> creater(ArrayList<ArrayList> bord){

        // this creater function taks the previos list from creater_2 function
        // in every list it adds 8 lists again then insted it gets value 0
        // no totaly it is a list with 8 lists inside in every list ther is 8 zeros

        for (int c = 0 ; c < 8; c++){

            bord.set(c, creater_2()) ; 
        }
        
        for(int c = 0; c< bord.size(); c++){
            var D = bord.get(c);
            for( int d=0; d< D.size(); d++){
                D.set(d, 0);
            }
        }

        
        return bord;    
    }



    public static boolean Checker(ArrayList<ArrayList> bord) {

        // function that check if the ant have steped on every place on the board
        // return fasle wheń ant have steped every where!!!
        // and true when it dosent

        int tal = 0;

        for (int c = 0; c < bord.size(); c++){
            var D = bord.get(c);
            for (int cc = 0; cc < D.size(); cc++){
                if((int) D.get(cc) == 0){
                    tal += 1;
                }
            }

        }
        if (tal == 0)
            return false;

        else
            return true;
    }   



        
    public static int counter(ArrayList<ArrayList> bord) {

        // function that counts the number of steps the ant have taken on the board

        int tal = 0;

        for (int c = 0; c < bord.size(); c++){
            var D = bord.get(c);
            for (int cc = 0; cc < D.size(); cc++){
                tal += (int) D.get(cc);
                }
            }
        return tal;
    }
}


class whereAnt{


    // class whereAnt defiens wher the ant is or will be


    public static int dira(){
        // ant random movment 
        // got a return with value 0 to 3 

        
        int tal;
        Random rand = new Random();
        tal = rand.nextInt(4);
        // tal = rand.nextInt(100);
        // tal +=1;
        // if (tal < 25)
        //     return 0;
        // else if( tal > 25 && tal < 50)
        //     return 1;
        // else if ( tal >50 && tal <75)
        //     return 2;
        // else 
        //     return 3;
        return tal;
    }


    public static int wheHight() {
        // ants start point in y
        Random rand = new Random();
        return rand.nextInt(7);        
    }



    public static int wheWidth() {
        // ants start point in x
        Random rand = new Random();
        return rand.nextInt(7);
    }
}