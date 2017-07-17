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
			//Checkpoint 1: Parsing one line of input
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
        else
        {
        	String operand1 = arrayinput[0];
        	String operator = arrayinput[1];
        	String operand2 = arrayinput[2];
        	//Input values may be in the form of
        	//mixed fractions 1_3/4
        	//proper fractions 2/5
        	//improper fractions  8/4 
        	//integers. -1 
        	//The integer and fraction parts of a mixed fraction will be separated by an underscore (_) (e.g., “1_3/4” is one and three fourth to distinguish it from “13/4” which is thirteen fourth).
        	return parseFraction(operand2);	
        }        
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
    public static String parseFraction(String operand) {
    	   String fraction = operand;   
		   String wholenumber = "0";
		   String numerator = "0";
		   String denominator = "0";
		   String[] splitwholenumber = fraction.split("_");
		   if (splitwholenumber.length == 2)
		   {
			   //Mixed Fraction Condition
			   wholenumber = fraction.split("_")[0];
			   numerator = fraction.split("_")[1].split("/")[0];
			   denominator = fraction.split("_")[1].split("/")[1];
		   }
		   else
		   {
			   //Check if it's whole number only
			   String[] splitnumeratoranddenominator = fraction.split("/");
			   //If there are 2 values in array, this means it's a fraction else it's only a whole number
			   if (splitnumeratoranddenominator.length == 2)
			   {
				   numerator = splitnumeratoranddenominator[0];
				   denominator = splitnumeratoranddenominator[1];				   
			   }
			   else
			   {
				   wholenumber = operand;
				   denominator = "1";
			   }
		   }	   
		  
		   return "whole:" + wholenumber + " numerator:" + numerator + " denominator:" + denominator;    	
    }
    
    public static String turnImproperFractionToMixedFraction(int numerator , int denominator) {
        //Integer a = numerator / denominator;
        //Integer b = numerator % denominator);
        //return a != 0 ? (a + " " + b + "/" + denominator) : (b + "/" + denominator);
    	return "";
    }   
    
}
