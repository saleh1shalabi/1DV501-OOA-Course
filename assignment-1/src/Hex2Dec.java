import java.util.Scanner;

public class Hex2Dec {

    public static int hexToDecimal(String hex){

        hex = hex.toUpperCase();
        int rak = 0;
        String numbers = "0123456789ABCDEF";
        for (int c = 0; c < hex.length(); c++){

            rak = (16*rak) + numbers.indexOf(hex.charAt(c));
        }
        return rak;
    }
    
    public static void main(String[] args){    
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter a hex number: ");
        
        String intake = inp.nextLine();

        System.out.print("The decimal value for " + intake + " is " + hexToDecimal(intake) + ".\n");
        
        inp.close();
    }
}
