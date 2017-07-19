package TestFiles;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fracCalc.FracCalc;
import fracCalc.FracCalcTestHelper;

public class FracCalcProduceAnswerTests {
	@Test
	public void ValidateInput_ShouldBeCorrectFormat() {
		String result = FracCalc.produceAnswer("2 + 4");
		assertEquals("6", result);
		System.out.println(result);
	}

	@Test
	public void ValidateInput_ShouldNotBeCorrectFormat() {
		assertEquals("Input is not in the correct format",
				"Input Expression is not in the correct Format. Values and operators will be separated by a single space",
				FracCalc.produceAnswer("2 +"));
	}

	@Test
	public void ValidateInput_ShouldBeCorrectFormatUsingFractions() {
		assertEquals("3_3/4", FracCalc.produceAnswer("3_1/2 + 1/4"));
	}

	@Test
	public void ValidateInput_ShouldBeCorrectFormatUsingFractionsReturnsOperand2() {
		assertEquals("6_3/4", FracCalc.produceAnswer("3_1/2 + 3_1/4"));
	}

	// Only used for Checkpoint 2
	// ParseFraction Tests
	// @Test
	// public void Validate_ParseFraction_Mixed() {
	// String fraction = "6_5/8";
	// assertEquals("Incorrect Fraction Parsing", "whole:6 numerator:5
	// denominator:8",
	// FracCalc.parseFractionCheckPoint2(fraction));
	// System.out.println(FracCalc.parseFractionCheckPoint2(fraction));
	// }
	//
	// // ParseFraction Tests
	// @Test
	// public void Validate_ParseFraction_Improper() {
	// String fraction = "5/8";
	// assertEquals("Incorrect Fraction Parsing", "whole:0 numerator:5
	// denominator:8",
	// FracCalc.parseFractionCheckPoint2(fraction));
	// System.out.println(FracCalc.parseFractionCheckPoint2(fraction));
	// }
	//
	// @Test
	// public void Validate_ParseFraction_OnlyWholeNumber() {
	// String fraction = "1";
	// assertEquals("Incorrect Fraction Parsing", "whole:1 numerator:0
	// denominator:1",
	// FracCalc.parseFractionCheckPoint2(fraction));
	// System.out.println(FracCalc.parseFractionCheckPoint2(fraction));
	// }

	// TurnImproperFractionToMixedFraction Tests
	@Test
	public void Validate_StaticVariablesSet() {
		FracCalc.parseFraction("1/4", true);
		FracCalc.parseFraction("1_3/4", false);
		assertEquals(4, FracCalc.operand2Denominator);
		assertEquals(3, FracCalc.operand2Numerator);
	}

	// Find GCD
	@Test
	public void Validate_findGcd() {
		int result = FracCalc.findGcd(54, 24);
		assertEquals(6, result);
	}

	// Convert Mixed to Improper Fraction
	@Test
	public void Validate_ConvertToImproperNumerator() {
		FracCalc.parseFraction("1_3/4", false);
		assertEquals(7, FracCalc.operand2ImproperNumerator);
	}

	// Calculation Tests
	//
	@Test
	public void Validate_CalculateAddSameDenominator() {
		FracCalc.parseFraction("3/4", true);
		FracCalc.parseFraction("2/4", false);
		FracCalc.Add();
		String result = FracCalc.finalresult;
		assertEquals("1_1/4", result);
		System.out.println(result);
	}

	@Test
	public void Validate_CalculateAddSameDenominatorResultsToWhole() {
		FracCalc.parseFraction("3/4", true);
		FracCalc.parseFraction("1/4", false);
		FracCalc.Add();
		String result = FracCalc.finalresult;
		assertEquals("1", result);
		System.out.println(result);
	}

	@Test
	public void Validate_CalculateAddDifferentDenominator() {
		FracCalc.parseFraction("3/4", true);
		FracCalc.parseFraction("1/3", false);
		FracCalc.Add();
		String result = FracCalc.finalresult;
		assertEquals("1_1/12", result);
		System.out.println(result);
	}

	// Calculation Tests
	// Test Case 1: 1/4 + 1_1/2 = 1_3/4
	@Test
	public void Validate_CalculateAddTestCase1() {
		FracCalc.parseFraction("1/4", true);
		FracCalc.parseFraction("1_1/2", false);
		FracCalc.Add();
		String result = FracCalc.finalresult;
		assertEquals("1_3/4", result);
		System.out.println("Test Case 1 - Passed! : " + result);
	}

	// Test Case 2: 8/4 + 2 = 4
	@Test
	public void Validate_CalculateAddTestCase2() {
		FracCalc.parseFraction("8/4", true);
		FracCalc.parseFraction("2", false);
		FracCalc.Add();
		String result = FracCalc.finalresult;
		assertEquals("4", result);
		System.out.println("Test Case 2 - Passed! : " + result);
	}

	// Test Case 3: -11/17 + -1/17 = -12/17
	@Test
	public void Validate_CalculateAddTestCase3() {
		FracCalc.parseFraction("-11/17", true);
		FracCalc.parseFraction("-1/17", false);
		FracCalc.Add();
		String result = FracCalc.finalresult;
		assertEquals("-12/17", result);
		System.out.println("Test Case 3 - Passed! : " + result);
	}

	// Multiplication
	// -1 * -1/2 = 1/2
	@Test
	public void Validate_CalculateOperatorMultiplication() {
		FracCalc.parseFraction("-1", true);
		FracCalc.parseFraction("-1/2", false);
		FracCalc.Multiply();
		String result = FracCalc.finalresult;
		assertEquals("1/2", result);
		System.out.println(result);
	}

	// Test Case 1: 0 * 25_462/543 = 0
	@Test
	public void Validate_CalculateMultiplicationTestCase1() {
		FracCalc.parseFraction("0", true);
		FracCalc.parseFraction("25_462/543", false);
		FracCalc.Multiply();
		String result = FracCalc.finalresult;
		assertEquals("0", result);
		System.out.println(result);
	}

	// Subtraction
	// Test Case 1: -3/7 - 20 = -20_3/7
	@Test
	public void Validate_CalculateSubtrationTestCase1() {
		FracCalc.parseFraction("-3/7", true);
		FracCalc.parseFraction("20", false);
		FracCalc.Subract();
		String result = FracCalc.finalresult;
		assertEquals("-20_3/7", result);
		System.out.println(result);
	}
	
	//Validate Extra Credits
	// 1 + 2 + 3 = 6
	@Test
	public void Validate_ExtraCreditTestCase1() {
		String expression = "1 + 2 + 3";
		String result = FracCalc.produceAnswer(expression);
		assertEquals("6", result);
		System.out.println(result);
	}
	
	@Test
	public void Validate_ExtraCreditTestCase2() {
		String expression = "-1/2 * 4 + 3/4";
		String result = FracCalc.produceAnswer(expression);
		assertEquals("-1_1/4", result);
		System.out.println(result);
	}
	
	@Test
	public void Validate_ExtraCreditTestCase3() {
		String expression = "5_3/4 - -6_8/8 - 5_3/4";
		String result = FracCalc.produceAnswer(expression);
		assertEquals("7", result);
		System.out.println(result);
	}
	
	@Test
	public void Validate_ExtraCreditTestCase4DivideByZero() {
		String expression = "1/0 + 1";
		String result = FracCalc.produceAnswer(expression);
		assertEquals("ERROR: Cannot divide by zero.", result);
		System.out.println(result);
	}
	
	@Test
	public void Validate_ExtraCreditTestCase4InvalidOperator() {
		String expression = "1 ++ 2";
		String result = FracCalc.produceAnswer(expression);
		assertEquals("ERROR: Input is in an invalid format.", result);
		System.out.println(result);
	}	
	
}
