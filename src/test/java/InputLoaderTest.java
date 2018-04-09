import org.junit.Test;

import com.target.barrenland.Farm;
import com.target.barrenland.InputLoader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class InputLoaderTest {

	Farm myFarm;
		
	@Test
	public void testZeroInput() {
	
		myFarm = new Farm();
		String input = new String("");
		boolean thrown = false;
		try {
			InputLoader.readInput(input,myFarm);
		}catch (Exception e){
			thrown = true;
			System.out.print(e.getMessage());
			return;
		}

		assertEquals(0,myFarm.getAllBarrenLands().size());
	}

	@Test
	public void testInvalidInput() throws Exception{
	
		myFarm = new Farm();
		String input = new String("{“0.2 -292 399 307”}");
		boolean thrown = false;
		try {
			InputLoader.readInput(input,myFarm);
		}catch (Exception e){
			thrown = true;
		}

		assertTrue(thrown);
	}
	
	@Test
	public void testOneBarren() throws Exception{
	
		myFarm = new Farm();
		String input = new String("{“48 192 351 207”}");
        boolean thrown = false;
		try {
			InputLoader.readInput(input,myFarm);
		}catch (Exception e){
            thrown = true;
			System.out.print(e.getMessage());
			return;
		}

		assertEquals(1,myFarm.getAllBarrenLands().size());
	}

	@Test
	public void testMultiBarren() throws Exception{

		myFarm = new Farm();
		String input = new String("{“10 10 20 20”, “20 20 30 30”, “5 20 10 30”, “10 30 20 40”}");
        boolean thrown = false;
		try {
			InputLoader.readInput(input,myFarm);
		}catch (Exception e){
            thrown = true;
			System.out.print(e.getMessage());
			return;
		}

		assertEquals(4,myFarm.getAllBarrenLands().size());
	}

}


