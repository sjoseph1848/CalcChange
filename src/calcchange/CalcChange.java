
package calcchange;
import java.util.Scanner;

/*
 * @author samueljoseph
 */
public class CalcChange {

       static Scanner sc =new Scanner(System.in);
    
    public static void main(String[] args) {
        // local variables
        int h, q, d, n, p, totcents, dollars, cents;
        String choice;
        
        System.out.println("Welcome to the change calculator!");
        
        System.out.print("Do you have any change? (Y/N) : ");
        choice = sc.nextLine();
        //System.out.println("Your choice was: " + choice);
        
       //choice == "y" is not correct for String class
       
        while(!choice.isEmpty() &&
               choice.substring(0,1).equalsIgnoreCase("y")) {
           h = getCoin("half dollar");
           q = getCoin("quarters");
           d = getCoin("dimes");
           n = getCoin("nickels");
           p = getCoin("pennies");
           sc.nextLine();
           
           totcents = (h * 50) + (q * 25) + (d * 10) + (n * 5) + p;
           dollars = totcents / 100;
           cents = totcents % 100; //divide by 100, keep remainder
           System.out.println("You have " + totcents +
                   "cents, which is " + dollars + 
                   "dollar(s) and " + cents + " cent(s). \n");
           
           System.out.print("Do you have more change? (Y/N): ");
           choice = sc.nextLine();
        } //end of while 
        
        System.out.println("Thanks for using the coin calculator.");
    } // end of main
    
    public static int getCoin(String ctype) {
        int ccount = 0;
        do {
            try {
                     System.out.print("How many " + ctype +
                                       " do you have? ");                 
                 ccount = sc.nextInt();
                 if (ccount < 0) {
                     System.out.println(
                          "Value must be zero or positive. ");
                 } //end of if
            } catch (Exception e) {
                 System.out.println("Coin input error: " +
                                      e.getMessage());
                 sc.nextLine();
                 ccount = -1;
            }
        } while (ccount <0);
        
        return ccount;
    }
    
} //end of class 
