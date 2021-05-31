package app;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Iterator;
import org.springframework.stereotype.Service;

@Service
public class NumbersService {
	private int[] digits;
	
    NumbersForm numbers;
	public int[] prepareData(int numberEnteredByUser) {
	  digits = Integer.toString(numbers.getNumberEnteredByUser()).chars().map(c -> c - '0').toArray();
		return digits; 
	}
	
	public int[] moveDigitsSmallerThreeToOnePositionRight(int[] digits) {
	  int temp[] = new int[digits.length];
	  for (int i = digits.length / 2; i > 0; i--) {
	    if (digits[i] <= 3) {
	      temp[i] = digits[i];
	      digits[i] = digits[i - 1];
	      digits[i - 1] = temp[i];
	    }
	  } return digits;
	}
		
	public int[] multiplyDigitsEightOrNineByTwo(int[] digits) {
	  for (int i = 0; i < digits.length - 1; i++) {
	    if (digits[i] == 8 || digits[i] == 9) {
	      digits[i] = digits[i] * 2;
	    }
	  } return digits;
	}
	
	List<Integer> listFromDigits = new ArrayList<>();
	public void changeTypeToList() {
	  for (int d : digits) {
        listFromDigits.add(d);
      }
    }
	
	public void deleteDigitsSeven( ) {
	  Iterator<Integer> listFromDigitIterator = listFromDigits.iterator();
      while (listFromDigitIterator.hasNext()) {
        Integer next = listFromDigitIterator.next();
          if (next == 7) {
                listFromDigitIterator.remove();
          }
       }
	}
        
	int countOddDigits = 0;
	public void countOddDigits() {
      for (Integer listFromDigit : listFromDigits) {
        if(listFromDigit % 2 == 1) {
		  countOddDigits++;
		}
	  }
	}
        
    String listString;   
	public void changeTypeToString() {
		listString = listFromDigits.stream()
        		.map(String::valueOf)
        		.collect(Collectors.joining(","))
        		.replaceAll("[\\[\\]]", "").replaceAll(",", "");
	}
	
	int endValue;
	public void divideByCountOddDigits() {
	  endValue = (int) Math.floor(Integer.parseInt(listString) / (double) countOddDigits);
	}
        
    public void changeEnteredNumber() {
        numbers.setResult(endValue);
    }

}
