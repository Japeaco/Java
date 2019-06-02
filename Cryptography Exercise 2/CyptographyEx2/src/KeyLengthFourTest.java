import java.util.HashMap;
import java.util.Map;

public class KeyLengthFourTest {
	
public static void main(String args[]){
		
		Map<Character, Integer> firstQuarter = new HashMap<>();
		for(char c = 'a'; c < 'z'; c++){
			firstQuarter.put(c, 0);
		}
		
		Map<Character, Integer> secondQuarter = new HashMap<>();
		for(char c = 'a'; c < 'z'; c++){
			secondQuarter.put(c, 0);
		}
		
		Map<Character, Integer> thirdQuarter = new HashMap<>();
		for(char c = 'a'; c < 'z'; c++){
			secondQuarter.put(c, 0);
		}
		
		Map<Character, Integer> fourthQuarter = new HashMap<>();
		for(char c = 'a'; c < 'z'; c++){
			fourthQuarter.put(c, 0);
		}
			
		KeyLengthFour k = new KeyLengthFour();
		
		k.keyLengthFour("C:/University/Exercise2Ciphertext.txt", "C:/University/Exercise2CiphertextFirstQuarter.txt", "C:/University/Exercise2CiphertextSecondQuarter.txt",
				"C:/University/Exercise2CiphertextThirdQuarter.txt", "C:/University/Exercise2CiphertextFourthQuarter.txt");
		
		LetterCount l = new LetterCount();
		
		l.countLetters("C:/University/Exercise2CiphertextFirstQuarter.txt", "C:/University/Exercise2CiphertextFirstQuarterCount.txt", firstQuarter);
		
		l.countLetters("C:/University/Exercise2CiphertextThirdQuarter.txt", "C:/University/Exercise2CiphertextSecondQuarterCount.txt", secondQuarter);
		
		l.countLetters("C:/University/Exercise2CiphertextThirdQuarter.txt", "C:/University/Exercise2CiphertextThirdQuarterCount.txt", thirdQuarter);
		
		l.countLetters("C:/University/Exercise2CiphertextFourthQuarter.txt", "C:/University/Exercise2CiphertextFourthQuarterCount.txt", fourthQuarter);
		
		IndexOfCoincidence i = new IndexOfCoincidence();
		
		System.out.println(i.indexOfCoincidence(firstQuarter));
		
		System.out.println(i.indexOfCoincidence(secondQuarter));
		
		System.out.println(i.indexOfCoincidence(thirdQuarter));
		
		System.out.println(i.indexOfCoincidence(fourthQuarter));
		
	}

}
