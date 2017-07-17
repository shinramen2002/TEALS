package TestFiles;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import fracCalc.FracCalc;
import fracCalc.FracCalcTestHelper;



public class FracCalcProduceAnswerTests {
	   @Test public void ValidateInput_ShouldBeCorrectFormat() 
	    {
		  assertEquals("4", FracCalc.produceAnswer("2 + 4"));		   
	    }
	   
	   @Test public void ValidateInput_ShouldNotBeCorrectFormat() 
	    {
		  assertEquals("Input is not in the correct format","Input Expression is not in the correct Format. Values and operators will be separated by a single space", FracCalc.produceAnswer("2 +"));		   
	    }
	   
	   @Test public void ValidateInput_ShouldBeCorrectFormatUsingFractions() 
	    {
		  assertEquals("4", FracCalc.produceAnswer("3_1/2 + 1/4"));		   
	    }
	   
	   @Test public void ValidateInput_ShouldBeCorrectFormatUsingFractionsReturnsOperand2() 
	    {
		  assertEquals("4", FracCalc.produceAnswer("3_1/2 + 3_1/4"));		   
	    }
	   
	   // ParseFraction Tests
	   @Test public void Validate_ParseFraction_Mixed() 
	    {
		   String fraction = "6_5/8";   
		   assertEquals("Incorrect Fraction Parsing","whole:6 numerator:5 denominator:8", FracCalc.parseFractionCheckPoint2(fraction));
		   System.out.println(FracCalc.parseFractionCheckPoint2(fraction));   
	    }
	   
	   // ParseFraction Tests
	   @Test public void Validate_ParseFraction_Improper() 
	    {
		   String fraction = "5/8";   
		   assertEquals("Incorrect Fraction Parsing","whole:0 numerator:5 denominator:8", FracCalc.parseFractionCheckPoint2(fraction));
		   System.out.println(FracCalc.parseFractionCheckPoint2(fraction));   
	    }
	   
	   @Test public void Validate_ParseFraction_OnlyWholeNumber() 
	    {
		   String fraction = "1";   
		   assertEquals("Incorrect Fraction Parsing","whole:1 numerator:0 denominator:1", FracCalc.parseFractionCheckPoint2(fraction));
		   System.out.println(FracCalc.parseFractionCheckPoint2(fraction));   
	    }
	   
	   
	   //TurnImproperFractionToMixedFraction Tests
	   @Test public void Validate_StaticVariablesSet()
	    {
	     	FracCalc.parseFraction("1/4", true);	
	     	FracCalc.parseFraction("1_3/4", false);
	     	 assertEquals(4,FracCalc.operand2Denominator);
	     	 assertEquals(3, FracCalc.operand2Numerator);
	    }
	   
	   //Calculation Tests
	   //Test Case 1: 1/4 + 1_1/2 =	1_3/4
	   @Test public void Validate_CalculateExpression_Add()
	    {
		   String fraction = "6_5/8";
		   
	    }
	   
	   //Test Case 2: 8/4 + 2	= 4
	   //Test Case 3: -1 * = -1/2
	   //Test Case 4: -11/17 + -1/17 = -12/17
	   //Test Case 5: 0 * 25_462/543	0
}
