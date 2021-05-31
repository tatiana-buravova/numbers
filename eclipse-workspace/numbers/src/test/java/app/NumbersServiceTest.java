package app;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class NumbersServiceTest {
	//private static final int STANDARTNUMBER = 43256791;
	private static final int ZERONUMBER = 0;
		

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPrepareData() {
        System.out.println("prepareData");
        int numberEnteredByUser = 43256791;
        NumbersService instance = new NumbersService();
        int[] expResult = {4,3,2,5,6,7,9,1};
        int[] result = instance.prepareData(numberEnteredByUser);
        assertArrayEquals(expResult, result);
        
    }
	
	 @Test
	 public void testMoveDigitsSmallerThreeToOnePositionRight() {
	    System.out.println("moveDigitsSmallerThreeToOnePositionRight");
	    NumbersService instance = new NumbersService();
	    int[] resultFromPrepareData = {4,3,2,5,6,7,9,1};
	    int[] expResult = {3,2,4,5,6,7,9,1};
	    int[] result = instance.moveDigitsSmallerThreeToOnePositionRight(resultFromPrepareData);
	    assertArrayEquals(expResult, result);
	 }
	 
	 @Test
	 public void testmultiplyDigitsEightOrNineByTwo() {
		 System.out.println("moveDigitsSmallerThreeToOnePositionRight");
		 NumbersService instance = new NumbersService();
		 int[] resultFromMoveDigitsToRight = {3,2,4,5,6,7,9,1};
		 int[] expResult = {3,2,4,5,6,7,9,1};
		 int[] result = instance.multiplyDigitsEightOrNineByTwo(resultFromMoveDigitsToRight);
		 assertArrayEquals(expResult, result); 
	 }
	   
}
