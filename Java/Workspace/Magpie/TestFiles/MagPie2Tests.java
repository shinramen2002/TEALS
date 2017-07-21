
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MagPie2Tests {

	@Test
	public void ValidateInput_pet() {
	Magpie2 magpie = new Magpie2();
	String result = magpie.getResponse("dog");
	assertEquals("Tell me more about your pets.", result);
	System.out.println("Test Case Passed! : " + result);
	}
	
	@Test
	public void ValidateInput_teacher() {
	Magpie2 magpie = new Magpie2();
	String result = magpie.getResponse("johnson");
	assertEquals("He's pretty awesome at teaching Comp Sci AP Class", result);
	System.out.println("Test Case Passed! : " + result);
	}
	
	@Test
	public void ValidateInput_noimput() {
	Magpie2 magpie = new Magpie2();
	String result = magpie.getResponse("");
	assertEquals("Say something, please.", result);
	System.out.println("Test Case Passed! : " + result);
	}
}
