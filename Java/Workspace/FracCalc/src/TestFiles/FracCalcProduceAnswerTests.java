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
		assertEquals("4", FracCalc.produceAnswer("2 + 4"));
	}

	@Test
	public void ValidateInput_ShouldNotBeCorrectFormat() {
		assertEquals("Input is not in the correct format",
				"Input Expression is not in the correct Format. Values and operators will be separated by a single space",
				FracCalc.produceAnswer("2 +"));
	}

	@Test
	public void ValidateInput_ShouldBeCorrectFormatUsingFractions() {
		assertEquals("4", FracCalc.produceAnswer("3_1/2 + 1/4"));
	}

	@Test
	public void ValidateInput_ShouldBeCorrectFormatUsingFractionsReturnsOperand2() {
		assertEquals("4", FracCalc.produceAnswer("3_1/2 + 3_1/4"));
	}

	// ParseFraction Tests
	@Test
	public void Validate_ParseFraction_Mixed() {
		String fraction = "6_5/8";
		assertEquals("Incorrect Fraction Parsing", "whole:6 numerator:5 denominator:8",
				FracCalc.parseFractionCheckPoint2(fraction));
		System.out.println(FracCalc.parseFractionCheckPoint2(fraction));
	}

	// ParseFraction Tests
	@Test
	public void Validate_ParseFraction_Improper() {
		String fraction = "5/8";
		assertEquals("Incorrect Fraction Parsing", "whole:0 numerator:5 denominator:8",
				FracCalc.parseFractionCheckPoint2(fraction));
		System.out.println(FracCalc.parseFractionCheckPoint2(fraction));
	}

	@Test
	public void Validate_ParseFraction_OnlyWholeNumber() {
		String fraction = "1";
		assertEquals("Incorrect Fraction Parsing", "whole:1 numerator:0 denominator:1",
				FracCalc.parseFractionCheckPoint2(fraction));
		System.out.println(FracCalc.parseFractionCheckPoint2(fraction));
	}

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
	// Test Case 1: 1/4 + 1_1/2 = 1_3/4
	@Test
	public void Validate_CalculateAddSameDenominator() {
		FracCalc.parseFraction("3/4", true);
		FracCalc.parseFraction("2/4", false);
		String result = FracCalc.Add();
		assertEquals("5/4", result);
		System.out.println(result);
	}

	@Test
	public void Validate_CalculateAddSameDenominatorResultsToWhole() {
		FracCalc.parseFraction("3/4", true);
		FracCalc.parseFraction("1/4", false);
		String result = FracCalc.Add();
		assertEquals("1", result);
		System.out.println(result);
	}

	@Test
	public void Validate_CalculateAddDifferentDenominator() {
		FracCalc.parseFraction("3/4", true);
		FracCalc.parseFraction("1/3", false);
		String result = FracCalc.Add();
		assertEquals("13/12", result);
		System.out.println(result);
	}

	// Calculation Tests
	// Test Case 1: 1/4 + 1_1/2 = 1_3/4
	@Test
	public void Validate_CalculateAddTestCase1() {
		FracCalc.parseFraction("1/4", true);
		FracCalc.parseFraction("1_1/2", false);
		String result = FracCalc.Add();
		assertEquals("7/4", result);
		System.out.println("Test Case 1 - Passed! : " + result);
	}

	// Test Case 2: 8/4 + 2 = 4
	@Test
	public void Validate_CalculateAddTestCase2() {
		FracCalc.parseFraction("8/4", true);
		FracCalc.parseFraction("2", false);
		String result = FracCalc.Add();
		assertEquals("4", result);
		System.out.println("Test Case 2 - Passed! : " + result);
	}



	// Test Case 3: -1 * -1/2 = 1/2
	// Test Case 4: -11/17 + -1/17 = -12/17
	// Test Case 5: 0 * 25_462/543 0
}
