import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Test {

	public static void main(String args[]){
		
		Map<Character, Integer> ciphertext = new HashMap<>();
		for(char c = 'a'; c < 'z'; c++){
			ciphertext.put(c, 0);
		}
		
		//take in a user defined password
		Scanner scan = new Scanner(System.in);
		
		System.out.print("create password: ");
		
		String password = scan.next();
		
		Encrypt E = new Encrypt();
		
		//test to encrypt 'newcastleuniversity' with the key 'ncl'
		E.encrypt(password, "C:/university/test.txt", "C:/university/ncl.txt");
		
		E.encrypt(password, "C:/university/pg1661.txt", "C:/university/VigenerePg1661Encrypted.txt");
		
		Map<Character, Double> ciphertextFrequency = new HashMap<>();
		for(char c = 'a'; c < 'z'; c++){
			ciphertextFrequency.put(c, 0.0);
		}
		
		LetterCount L = new LetterCount();
		
		Frequency F = new Frequency();
		
		//method to return the frequency of the letter occurrences of pg1661 after being encrypted with the key 'ncl'
		L.countLetters("C:/university/VigenerePg1661Encrypted.txt", "C:/university/VigenerePg1661Ciphertext.txt", ciphertext);
		
		F.frequency("C:/university/VigenerePg1661CiphertextFrequency.txt", ciphertext, ciphertextFrequency);
		
		DecryptWithKey D = new DecryptWithKey();
		
		//test to decrypt pg1661 back to its original plaintext when the key is known
		D.decrypt(password, "C:/university/VigenerePg1661Encrypted.txt", "C:/university/VigenerePg1661CiphertextDecrypted.txt");
		
		for (Entry<Character, Integer> map : ciphertext.entrySet())
   	 	{
   		 	//prints out each value of new map
   		 	System.out.println(map.getKey() + " = " + map.getValue());
   	 	}
		
		//method to find index of coincidence of ciphertext
		IndexOfCoincidence i = new IndexOfCoincidence();
		
		System.out.println(i.indexOfCoincidence(ciphertext));
		
	}
	
}
