import java.lang.*;
import java.util.*;

/**
 * This program calculates the root of quadratic equations.  Users are
 * asked to input the coefficient values A, B and C.  Program will continue
 * asking the user for values and solving equations until the user
 * choses to end the program.
 * 
 * @author Tavette Hepburn
 *
 */

class QuadraticRoot {

  /**
	 * Returns the larger of the two roots of the quadratic equation
	 * A*x*x + B*x + C = 0, provided it has any roots.  If A == 0 or
	 * if the discriminant, B*B - 4*A*C, is negative, then an exception
	 * of type IllegalArgumentException is thrown.
	 */

static public double root( double A, double B, double C )
	                              throws IllegalArgumentException {
	    if (A == 0) {
	      throw new IllegalArgumentException("A can't be zero.");
	    }
	    else {
	       double disc = B*B - 4*A*C;
	       if (disc < 0)
	          throw new IllegalArgumentException("Discriminant < zero.");
	       return  (-B + Math.sqrt(disc)) / (2*A);
	    }
	}

  /**
	 * Asks user for values of A, B, and C of quadratic equation.  Uses
	 * root method to calculate the larger of the two roots and
	 * prints it to the user.  Will continue asking the user for
	 * values and solving equations until the user answers 'N'.
	 */
  
  public static void main(String[] args) {

    Scanner s = new Scanner(System.in); // create new scanner object

    

    System.out.println("Welcome! You will be asked to enter" +
                      " three values for A, B and C as the coefficients" +
                      " for a quadratic equation.");
    System.out.println();
    System.out.println("Once complete, the root will be printed to the screen.");
    System.out.println();
    System.out.println("You will have the choice to continue or quit after each attempt.");

    double A, B, C; // stores values from user
    boolean continueProgram = true; // determines if the program will restart or quit

    while(continueProgram) {
      System.out.println("Please enter a value for A: ");
      A = s.nextDouble();
      System.out.println("Please enter a value for B: ");
      B = s.nextDouble();
      System.out.println("Please enter a value for C: ");
      C = s.nextDouble();

      double largeRoot;

      try {
        largeRoot = root(A, B, C);
        System.out.println("The root is " + largeRoot + ".");
        
      } catch (IllegalArgumentException e) {
        
				System.out.println("Error: " + e.getMessage());
			}

      System.out.println();
      
      System.out.println("Would you like to continue? Y/N");
      
			if (s.next().charAt(0) == 'Y') { // changes the value of 'continueProgram based on user input'
        continueProgram = true; 
      } else {
        continueProgram = false;
        System.out.println("Thank you for participating.");
      }

    
      
    } // end of while 

  } // end of main
    
} // end of class

