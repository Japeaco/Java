import java.util.HashMap;
import java.util.Map;

public class vigenereFrequency {

	public static void main(String args[]){
		
		
		//creating lists to store characters and their respective occurrences in each subtext
		Map<Character, Integer> plaintext = new HashMap<>();
		for(char c = 'a'; c <= 'z'; c++){
			plaintext.put(c, 0);
		}
		
		Map<Character, Integer> ciphertext = new HashMap<>();
		for(char c = 'a'; c <= 'z'; c++){
			ciphertext.put(c, 0);
		}
		
		Map<Character, Integer> ciphertextOne = new HashMap<>();
		for(char c = 'a'; c <= 'z'; c++){
			ciphertextOne.put(c, 0);
		}
		
		Map<Character, Integer> ciphertextTwo = new HashMap<>();
		for(char c = 'a'; c <= 'z'; c++){
			ciphertextTwo.put(c, 0);
		}
		
		Map<Character, Integer> ciphertextThree = new HashMap<>();
		for(char c = 'a'; c <= 'z'; c++){
			ciphertextThree.put(c, 0);
		}
		
		Map<Character, Integer> ciphertextFour = new HashMap<>();
		for(char c = 'a'; c <= 'z'; c++){
			ciphertextFour.put(c, 0);
		}
		
		Map<Character, Integer> ciphertextFive = new HashMap<>();
		for(char c = 'a'; c <= 'z'; c++){
			ciphertextFive.put(c, 0);
		}
		
		LetterCount L = new LetterCount();
		
		//counting letter occurrences in 
		L.countLetters("C:/university/pg1661.txt", "C:/university/plaintext.txt", plaintext);
		
		L.countLetters("C:/university/Exercise2CiphertextFirstFifth.txt", "C:/university/Exercise2CiphertextFirstFifthCount.txt", ciphertextOne);
		
		L.countLetters("C:/university/Exercise2CiphertextSecondFifth.txt", "C:/university/Exercise2CiphertextSecondFifthCount.txt", ciphertextTwo);
		
		L.countLetters("C:/university/Exercise2CiphertextThirdFifth.txt", "C:/university/Exercise2CiphertextThirdFifthCount.txt", ciphertextThree);
		
		L.countLetters("C:/university/Exercise2CiphertextFourthFifth.txt", "C:/university/Exercise2CiphertextFourthFifthCount.txt", ciphertextFour);
		
		L.countLetters("C:/university/Exercise2CiphertextFifthFifth.txt", "C:/university/Exercise2CiphertextFifthFifthCount.txt", ciphertextFive);
		
		Match m = new Match();
		
		System.out.println("Subtext One: " + m.match(plaintext, ciphertextOne));
		
		System.out.println("Subtext Two: " + m.match(plaintext, ciphertextTwo));
		
		System.out.println("Subtext Three: " + m.match(plaintext, ciphertextThree));
		
		System.out.println("Subtext Four: " + m.match(plaintext, ciphertextFour));
		
		System.out.println("Subtext Five: " + m.match(plaintext, ciphertextFive));
		
		FindKey f = new FindKey();
		
		//combine individual characters into key string
		String key = (f.findKey(m.match(plaintext, ciphertextOne)) + "" + "" + f.findKey(m.match(plaintext, ciphertextTwo))
						+ "" + "" + f.findKey(m.match(plaintext, ciphertextThree)) + "" + "" + f.findKey(m.match(plaintext, ciphertextFour))
						+ "" + "" + f.findKey(m.match(plaintext, ciphertextFive)));
		
		DecryptWithKey d = new DecryptWithKey();
		
		d.decrypt(key, "C:/university/Exercise2Ciphertext.txt", "C:/university/Exercise2CiphertextDecrypted.txt");
		
	}
	
}
