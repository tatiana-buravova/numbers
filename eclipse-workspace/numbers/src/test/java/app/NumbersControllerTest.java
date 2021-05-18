package app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;


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
}
