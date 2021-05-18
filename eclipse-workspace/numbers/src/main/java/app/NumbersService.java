package app;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Iterator;
import org.springframework.stereotype.Service;

@Service
public class NumbersService {
	
	public NumbersForm changeEnteredNumber(NumbersForm numbers) {
		
		int[] digits = Integer.toString(numbers.getNumberEnteredByUser()).chars().map(c -> c - '0').toArray();
		
		int pom[] = new int[digits.length];
		for (int i = 0; i < digits.length - 1; i++) {
	        while (digits[i] <= 3) {
	                pom[i] = digits[i];
	                digits[i] = digits[i - 1];
	                digits[i - 1] = pom[i];
	                break;
	        }
		}
		
		for (int i = 0; i < digits.length - 1; i++) {
	        if (digits[i] == 8 || digits[i] == 9) {
	                digits[i] = digits[i] * 2;
	        }
	    }
		
		List<Integer> listFromDigits = new ArrayList<>();
        for (int d : digits) {
            listFromDigits.add(d);
        }
        
        Iterator<Integer> listFromDigitIterator = listFromDigits.iterator();
        while (listFromDigitIterator.hasNext()) {
            Integer next = listFromDigitIterator.next();
            if (next == 7) {
                listFromDigitIterator.remove();
            }
        }
        
        int countOddDigits = 0;
        for (Integer listFromDigit : listFromDigits) {
			if(listFromDigit % 2 == 1)
				countOddDigits++;
		}
        
        String listString = listFromDigits.stream()
        		.map(String::valueOf)
        		.collect(Collectors.joining(","))
        		.replaceAll("[\\[\\]]", "").replaceAll(",", "");
        
        int value = (int) Math.floor(Integer.parseInt(listString) / (double) countOddDigits);
        
        numbers.setResult(value);
        
		return numbers;
	}

}
