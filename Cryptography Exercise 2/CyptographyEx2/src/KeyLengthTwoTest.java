import java.util.HashMap;
import java.util.Map;

public class KeyLengthTwoTest {

	public static void main(String args[]){
		
		Map<Character, Integer> firstHalf = new HashMap<>();
		for(char c = 'a'; c < 'z'; c++){
			firstHalf.put(c, 0);
		}
		
		Map<Character, Integer> secondHalf = new HashMap<>();
		for(char c = 'a'; c < 'z'; c++){
			secondHalf.put(c, 0);
		}
			
		KeyLengthTwo k = new KeyLengthTwo();
		
		k.keyLengthTwo("C:/University/Exercise2Ciphertext.txt", "C:/University/Exercise2CiphertextFirst.txt", "C:/University/Exercise2CiphertextSecond.txt");
		
		LetterCount l = new LetterCount();
		
		l.countLetters("C:/University/Exercise2CiphertextFirst.txt", "C:/University/Exercise2CiphertextFirstCount.txt", firstHalf);
		
		l.countLetters("C:/University/Exercise2CiphertextSecond.txt", "C:/University/Exercise2CiphertextSecondCount.txt", secondHalf);
		
		IndexOfCoincidence i = new IndexOfCoincidence();
		
		System.out.println(i.indexOfCoincidence(firstHalf));
		
		System.out.println(i.indexOfCoincidence(secondHalf));
		
	}
	
}
