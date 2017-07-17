package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) 
    {
    	Scanner console = new Scanner(System.in);
		System.out.print("Please enter your equation (quit to quit): ");
		String equation = console.nextLine();
	

		while (!equation.toLowerCase().equals("quit"))
		{
			String results = produceAnswer(equation);
			System.out.println(results);
			System.out.print("Please enter your equation (quit to quit): ");
			equation = console.nextLine();			
		}
		console.close();
		System.out.print("Fraction Calculator is Closed!");
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // Requirement 1
    	//Input will be in the form of a value, followed by an arithmetic operator, and then another value. Values and operators will be separated by a single space. Values will contain no spaces.
    	String[] arrayinput = input.split(" ");    	
        if (arrayinput.length != 3)
        {
        	return "Input Expression is not in the correct Format. Values and operators will be separated by a single space";
        }
    	
        return "3";//Integer.toString(arrayinput.length);
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
