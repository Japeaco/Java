import java.util.HashMap;
import java.util.Map;

public class Test {
	
	public static void main(String arg[]){
		
		//create map for plaintext
		Map<Character, Integer> plaintext = new HashMap<>();
		for(char c = 'a'; c < 'z'; c++){
			plaintext.put(c, 0);
		}
		
		//create map for ciphertext
		Map<Character, Integer> ciphertext = new HashMap<>();
		for(char c = 'a'; c < 'z'; c++){
			ciphertext.put(c, 0);
		}
	
		LetterCount L = new LetterCount();
		
		//count letter occurrences in plaintext
		L.countLetters("C:/university/pg1661.txt", "C:/university/plaintext.txt", plaintext);
		
		//count letter occurrences in ciphertext
		L.countLetters("C:/university/Exercise1Ciphertext.txt", "C:/university/ciphertext.txt", ciphertext);
		
		Match m = new Match();
		
		//match frequency of letters
		System.out.println(m.match(plaintext, ciphertext));
		
		Replace r = new Replace();
		
		//replace letters in ciphertext with those in plaintext and print into text file
		r.replace(m.match(plaintext, ciphertext), "C:/university/Exercise1Ciphertext.txt", "C:/university/ciphertextReplaced.txt");
 
		//create map for frequency of characters in plaintext
		Map<Character, Double> plaintextFrequency = new HashMap<>();
		for(char c = 'a'; c < 'z'; c++){
			plaintextFrequency.put(c, 0.0);
		}
		
		//create map for frequency of characters in ciphertext
		Map<Character, Double> ciphertextFrequency = new HashMap<>();
		for(char c = 'a'; c < 'z'; c++){
			ciphertextFrequency.put(c, 0.0);
		}
		
		Frequency F = new Frequency();
		
		//print frequencies of characters from plaintext
		F.frequency("C:/university/plaintextFrequency.txt", plaintext, plaintextFrequency);
		
		//print frequencies of characters from plaintext
		F.frequency("C:/university/ciphertextFrequency.txt", ciphertext, ciphertextFrequency);
		
	}

}
