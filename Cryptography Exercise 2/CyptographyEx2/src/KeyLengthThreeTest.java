import java.util.HashMap;
import java.util.Map;

public class KeyLengthThreeTest {
	
	public static void main(String args[]){
		
		Map<Character, Integer> firstThird = new HashMap<>();
		for(char c = 'a'; c < 'z'; c++){
			firstThird.put(c, 0);
		}
		
		Map<Character, Integer> secondThird = new HashMap<>();
		for(char c = 'a'; c < 'z'; c++){
			secondThird.put(c, 0);
		}
		
		Map<Character, Integer> thirdThird = new HashMap<>();
		for(char c = 'a'; c < 'z'; c++){
			thirdThird.put(c, 0);
		}
			
		KeyLengthThree k = new KeyLengthThree();
		
		k.keyLengthThree("C:/University/Exercise2Ciphertext.txt", "C:/University/Exercise2CiphertextFirstThird.txt", "C:/University/Exercise2CiphertextSecondThird.txt",
				"C:/University/Exercise2CiphertextThirdThird.txt");
		
		LetterCount l = new LetterCount();
		
		l.countLetters("C:/University/Exercise2CiphertextFirstThird.txt", "C:/University/Exercise2CiphertextFirstThirdCount.txt", firstThird);
		
		l.countLetters("C:/University/Exercise2CiphertextSecondThird.txt", "C:/University/Exercise2CiphertextSecondThirdCount.txt", secondThird);
		
		l.countLetters("C:/University/Exercise2CiphertextThirdThird.txt", "C:/University/Exercise2CiphertextThirdThirdCount.txt", thirdThird);
		
		IndexOfCoincidence i = new IndexOfCoincidence();
		
		System.out.println(i.indexOfCoincidence(firstThird));
		
		System.out.println(i.indexOfCoincidence(secondThird));
		
		System.out.println(i.indexOfCoincidence(thirdThird));
		
	}

}
