
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;



public class UnitTests {
	@Test
	public void ValidateInput_GetCount() {
		IntArrayWorker worker = new IntArrayWorker();
	    int[][] nums = new int[3][4];
	    worker.setMatrix(nums);
	    worker.fillPattern1();
		String result =  Integer.toString(worker.getCount(1));
		assertEquals("6", result);
		System.out.println("Test Case Passed! : " + result);
	}
	
	@Test
	public void ValidateInput_GetLargestValue() {
		IntArrayWorker worker = new IntArrayWorker();
	    int[][] nums = new int[3][4];
	    worker.setMatrix(nums);
	    worker.fillPattern1();
		String result =  Integer.toString(worker.getLargest());
		assertEquals("3", result);
		System.out.println("Test Case Passed! : " + result);
	}
}
