package fracCalc;

import java.util.Scanner;

public class FracCalc {

	// Operand 1
	public static int operand1Wholenumber = 0;
	public static int operand1Numerator = 0;
	public static int operand1Denominator = 0;
	public static int operand1ImproperNumerator = 0;

	// Operand 2
	public static int operand2Wholenumber = 0;
	public static int operand2Numerator = 0;
	public static int operand2Denominator = 0;
	public static int operand2ImproperNumerator = 0;

	// Operator
	public static String operator = "";
	public static String finalresult = "";

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Please enter your equation (quit to quit): ");
		String equation = console.nextLine();

		while (!equation.toLowerCase().equals("quit")) {
			String results = produceAnswer(equation);
			// Checkpoint 1: Parsing one line of input
			System.out.println(results);
			System.out.print("Please enter your equation (quit to quit): ");
			equation = console.nextLine();
		}
		console.close();
		System.out.print("Fraction Calculator is Closed!");
	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"
	public static String produceAnswer(String input) {
		// Requirement 1
		// Input will be in the form of a value, followed by an arithmetic operator, and
		// then another value. Values and operators will be separated by a single space.
		// Values will contain no spaces.
		String[] arrayinput = input.split(" ");
		if (arrayinput.length != 3) {
			return "Input Expression is not in the correct Format. Values and operators will be separated by a single space";
		} else {
			String operand1 = arrayinput[0];
			String operator = arrayinput[1];
			String operand2 = arrayinput[2];
			// Input values may be in the form of
			// mixed fractions 1_3/4
			// proper fractions 2/5
			// improper fractions 8/4
			// integers. -1
			// The integer and fraction parts of a mixed fraction will be separated by an
			// underscore (_) (e.g., “1_3/4” is one and three fourth to distinguish it from
			// “13/4” which is thirteen fourth).
			parseFraction(operand1, true);
			parseFraction(operand2, false);
			FracCalc.operator = operator;
			if (operator.equalsIgnoreCase("+")) {
				FracCalc.Add();
			}
			return FracCalc.finalresult;
		}
	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need

	public static void parseFraction(String operand, Boolean operand1) {
		String fraction = operand;
		String wholenumber = "0";
		String numerator = "0";
		String denominator = "0";
		String[] splitwholenumber = fraction.split("_");
		if (splitwholenumber.length == 2) {
			// Mixed Fraction Condition
			wholenumber = fraction.split("_")[0];
			numerator = fraction.split("_")[1].split("/")[0];
			denominator = fraction.split("_")[1].split("/")[1];
		} else {
			// Check if it's whole number only
			String[] splitnumeratoranddenominator = fraction.split("/");
			// If there are 2 values in array, this means it's a fraction else it's only a
			// whole number
			if (splitnumeratoranddenominator.length == 2) {
				numerator = splitnumeratoranddenominator[0];
				denominator = splitnumeratoranddenominator[1];
			} else {
				wholenumber = operand;
				denominator = "1";
			}
		}

		SetStaticFieldValues(operand1, Integer.parseInt(wholenumber), Integer.parseInt(numerator),
				Integer.parseInt(denominator));

	}

	public static void SetStaticFieldValues(Boolean operand1, int wholenumber, int numerator, int denominator) {

		if (operand1) {
			FracCalc.operand1Wholenumber = wholenumber;
			FracCalc.operand1Numerator = numerator;
			FracCalc.operand1Denominator = denominator;
			if (wholenumber != 0) {
				FracCalc.operand1ImproperNumerator = (wholenumber * denominator) + numerator;
			} else {
				FracCalc.operand1ImproperNumerator = numerator;
			}

		} else {
			FracCalc.operand2Wholenumber = wholenumber;
			FracCalc.operand2Numerator = numerator;
			FracCalc.operand2Denominator = denominator;
			if (wholenumber != 0) {
				FracCalc.operand2ImproperNumerator = (wholenumber * denominator) + numerator;
			} else {
				FracCalc.operand2ImproperNumerator = numerator;
			}
		}
	}

	public static int findGcd(int number1, int number2) {
		// In Euclid's algorithm, we start with two numbers X and Y. If Y is zero then
		// greatest common divisor of both will be X, but if Y is not zero then we
		// assign the Y to X and Y becomes X%Y. Once again we check if Y is zero, if yes
		// then we have our greatest common divisor or GCD otherwise we keep continue
		// like this until Y becomes zero. Since we are using modulo operator, the
		// number is getting smaller and smaller at each iteration, so the X%Y will
		// eventually become zero.
		if (number2 == 0) {
			return number1;
		}
		return findGcd(number2, number1 % number2);
	}

	public static String turnImproperFractionToMixedFraction(int numerator, int denominator) {
		Integer wholenumber = numerator / denominator;
		Integer remainder = numerator % denominator;
		return wholenumber != 0 ? (wholenumber + "_" + remainder + "/" + denominator) : (remainder + "/" + denominator);
	}

	public static String Add() {
		// Algorithm
		// 1) Set all Fractions to Improper Fractions to make operations easier
		// 2) Check to see if the denominators are the same
		// 3) If yes, simply add the numerator then set the display to either whole
		// number or fraction
		// 4) If no, Check the common denominator
		// 4.1) Perform normal operation
		// 4.2) Simply the improper Fraction
		int tempnumerator = 0;
		int commondenominator = 0;
		if (FracCalc.operand1Denominator == FracCalc.operand2Denominator) {
			tempnumerator = FracCalc.operand1ImproperNumerator + FracCalc.operand2ImproperNumerator;
			//Since the denominator are the same let's just use Operand1 denom
			SetResult(tempnumerator, FracCalc.operand1Denominator);
		} else {
			commondenominator = FracCalc.operand1Denominator * FracCalc.operand2Denominator;
			FracCalc.operand1ImproperNumerator = FracCalc.operand1ImproperNumerator
					* (commondenominator / FracCalc.operand1Denominator);
			FracCalc.operand2ImproperNumerator = FracCalc.operand2ImproperNumerator
					* (commondenominator / FracCalc.operand2Denominator);
			tempnumerator = FracCalc.operand1ImproperNumerator + FracCalc.operand2ImproperNumerator;
			SetResult(tempnumerator, commondenominator);
		}
		return FracCalc.finalresult;
	}

	public static void SetResult(int numerator, int denominator) {
		if (numerator % denominator == 0) {
			FracCalc.finalresult = Integer.toString(numerator / denominator);
		} else {
			int gcd = FracCalc.findGcd(numerator, denominator);
			int simplifiednumerator =  numerator / gcd;
			int simplifieddenominator =  denominator / gcd;
			//FracCalc.finalresult = Integer.toString(numerator / gcd) + "/" + Integer.toString(denominator / gcd);
			//Replace to convert to Mixed Fraction if need be:
			FracCalc.finalresult = turnImproperFractionToMixedFraction(simplifiednumerator, simplifieddenominator);
		}
	}

	public static String parseFractionCheckPoint2(String operand) {
		String fraction = operand;
		String wholenumber = "0";
		String numerator = "0";
		String denominator = "0";
		String[] splitwholenumber = fraction.split("_");
		if (splitwholenumber.length == 2) {
			// Mixed Fraction Condition
			wholenumber = fraction.split("_")[0];
			numerator = fraction.split("_")[1].split("/")[0];
			denominator = fraction.split("_")[1].split("/")[1];
		} else {
			// Check if it's whole number only
			String[] splitnumeratoranddenominator = fraction.split("/");
			// If there are 2 values in array, this means it's a fraction else it's only a
			// whole number
			if (splitnumeratoranddenominator.length == 2) {
				numerator = splitnumeratoranddenominator[0];
				denominator = splitnumeratoranddenominator[1];
			} else {
				wholenumber = operand;
				denominator = "1";
			}
		}

		return "whole:" + wholenumber + " numerator:" + numerator + " denominator:" + denominator;
	}
}
