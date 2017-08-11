
import org.junit.Test;

public class MagPie3Tests {

	@Test
	public void ValidateInput_pet() {
	Magpie3 magpie = new Magpie3();
	int result = magpie.findKeyword("yesterday is today's day before.", "day", 0);
	System.out.println("Test Case Passed! : " + result);
	}
	
	@Test
	public void ValidateInput_Trace1() {
	Magpie3 magpie = new Magpie3();
	int result = magpie.findKeyword("She's my sister", "sister", 0);
	System.out.println("Test Case Passed! : " + result);
	}

	@Test
	public void ValidateInput_Trace2() {
	Magpie3 magpie = new Magpie3();
	int result = magpie.findKeyword("Brother Tom is helpful", "brother", 0);
	System.out.println("Test Case Passed! : " + result);
	}
	
	@Test
	public void ValidateInput_Trace3() {
	Magpie3 magpie = new Magpie3();
	int result = magpie.findKeyword("I can't catch wild cats.", "cat", 0);
	System.out.println("Test Case Passed! : " + result);
	}
	
	@Test
	public void ValidateInput_Trace4() {
	Magpie3 magpie = new Magpie3();
	int result = magpie.findKeyword("I know nothing about snow plows.", "no", 0);
	System.out.println("Test Case Passed! : " + result);
	}
	
	@Test
	public void ValidateInput_ChangedGetResponseToUseNewKeyWordMethod() {
	Magpie3 magpie = new Magpie3();
	String result = magpie.getResponse("I know nothing about snow plows.");
	System.out.println("Test Case Passed! : " + result);
	}
}
