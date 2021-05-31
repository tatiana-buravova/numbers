package app;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class NumbersControllerTest {
	
	private MockMvc mockMvc;
	
	@Test
	public void testHome() throws Exception {
		mockMvc.perform(get("/numbers")).andExpect(status().isOk());
	}

	@Test
	public void testPersistenseStatus() throws Exception {
		mockMvc.perform(get("/numbers")).andExpect(status().isOk()).andExpect(model().attributeExists("numbers"));
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() {
		
	}
		
	@After
	public void tearDown() {
		
	}
	
	@Test
    public void testPrintNumbers() {
        System.out.println("printNumbers");
        Model model = null;
        NumbersController instance = new NumbersController();
        String expResult = "";
        String result = instance.printNumbers(model);
        assertEquals(expResult, result);
        
        
    }

    @Test
    public void testHandleNumbers() {
        System.out.println("handleNumbers");
        NumbersForm numbers = null;
        NumbersController instance = new NumbersController();
        String expResult = "";
        String result = instance.handleNumbers(numbers);
        assertEquals(expResult, result);
        
    }
}
