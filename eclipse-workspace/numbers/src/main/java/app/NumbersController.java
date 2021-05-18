package app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NumbersController {
	
	@Autowired
	private NumbersService numbersService;
	
	@GetMapping("/numbers")
	public String printNumbers(Model model) {
		model.addAttribute("numbers", new NumbersForm());
		return "numbers";
	}
	
	@PostMapping("/numbers")
	public String handleNumbers(@ModelAttribute NumbersForm numbers) {
		numbersService.changeEnteredNumber(numbers);
		return "result";
		}
	

}
