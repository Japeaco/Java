import java.util.HashMap;
import java.util.Map;

public class KeyLengthFiveTest {

	public static void main(String args[]){
		
		Map<Character, Integer> firstFifth = new HashMap<>();
		for(char c = 'a'; c < 'z'; c++){
			firstFifth.put(c, 0);
		}
		
		Map<Character, Integer> secondFifth = new HashMap<>();
		for(char c = 'a'; c < 'z'; c++){
			secondFifth.put(c, 0);
		}
		
		Map<Character, Integer> thirdFifth = new HashMap<>();
		for(char c = 'a'; c < 'z'; c++){
			thirdFifth.put(c, 0);
		}
		
		Map<Character, Integer> fourthFifth = new HashMap<>();
		for(char c = 'a'; c < 'z'; c++){
			fourthFifth.put(c, 0);
		}
		
		Map<Character, Integer> fifthFifth = new HashMap<>();
		for(char c = 'a'; c < 'z'; c++){
			fifthFifth.put(c, 0);
		}
			
		KeyLengthFive k = new KeyLengthFive();
		
		k.keyLengthFive("C:/University/Exercise2Ciphertext.txt", "C:/University/Exercise2CiphertextFirstFifth.txt", "C:/University/Exercise2CiphertextSecondFifth.txt",
				"C:/University/Exercise2CiphertextThirdFifth.txt", "C:/University/Exercise2CiphertextFourthFifth.txt", "C:/University/Exercise2CiphertextFifthFifth.txt");
		
		LetterCount l = new LetterCount();
		
		l.countLetters("C:/University/Exercise2CiphertextfirstFifth.txt", "C:/University/Exercise2CiphertextfirstFifthCount.txt", firstFifth);
		
		l.countLetters("C:/University/Exercise2CiphertextsecondFifth.txt", "C:/University/Exercise2CiphertextsecondFifthCount.txt", secondFifth);
		
		l.countLetters("C:/University/Exercise2CiphertextthirdFifth.txt", "C:/University/Exercise2CiphertextthirdFifthCount.txt", thirdFifth);
		
		l.countLetters("C:/University/Exercise2CiphertextfourthFifth.txt", "C:/University/Exercise2CiphertextfourthFifthCount.txt", fourthFifth);
		
		l.countLetters("C:/University/Exercise2CiphertextfifthFifth.txt", "C:/University/Exercise2CiphertextfifthFifthCount.txt", fifthFifth);
		
		IndexOfCoincidence i = new IndexOfCoincidence();
		
		System.out.println(i.indexOfCoincidence(firstFifth));
		
		System.out.println(i.indexOfCoincidence(secondFifth));
		
		System.out.println(i.indexOfCoincidence(thirdFifth));
		
		System.out.println(i.indexOfCoincidence(fourthFifth));
		
		System.out.println(i.indexOfCoincidence(fifthFifth));
		
	}
}
