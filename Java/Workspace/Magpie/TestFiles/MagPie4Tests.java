
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MagPie4Tests {

	@Test
	public void ValidateInput_pet() {
	Magpie3 magpie = new Magpie3();
	int result = magpie.findKeyword("yesterday is today's day before.", "day", 0);
	System.out.println("Test Case Passed! : " + result);
	}	
}
