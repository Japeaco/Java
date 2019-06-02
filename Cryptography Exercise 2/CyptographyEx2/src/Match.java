import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Match {
	
	public Map<Character, Character> match(Map<Character, Integer> plaintext, Map<Character, Integer> ciphertext){
		
		//create map to store letters that match in frequency
		Map<Character, Character> matched = new LinkedHashMap();
		
		//Arrays to store values
		Integer[] plaintextArray = new Integer[plaintext.size()];
		Integer[] ciphertextArray = new Integer[ciphertext.size()];
		
		//Arrays to store characters
		Character[] plaintextChars = new Character[plaintext.size()];
		Character[] ciphertextChars = new Character[ciphertext.size()];
		
		int i = 0;
		int j = 0;
		
		//populate array with map values
		for (Entry<Character, Integer> map : plaintext.entrySet())
		{
			plaintextArray[i] = map.getValue();
			i++;
		}
		
		//populate array with map values
		for (Entry<Character, Integer> map : ciphertext.entrySet())
		{
			ciphertextArray[j] = map.getValue();
			j++;
		}
		
		//sort array in descending order
		Arrays.sort(plaintextArray, Collections.reverseOrder());
				
		//sort array in descending order
		Arrays.sort(ciphertextArray, Collections.reverseOrder());
	
		int a = 0;
		
		//loop through values in array
		for(int b = 0; b < plaintextArray.length; b++){
			
			boolean found = false;
			
			//loop through entries in map
			for (Entry<Character, Integer> map : plaintext.entrySet())
	   	 	{
				//if the value in the array matches the value in the map
	   	 		if(plaintextArray[b] == map.getValue() && found == false){
	   	 			found = true;
	   	 			//insert corresponding character from map into the array
	   	 			plaintextChars[a] = map.getKey();
	   		 		a++;
	   	 		}	   
	   	 	}
		}
		
		int m = 0;
		
		//loop through values in array
		for(int n = 0; n < ciphertextArray.length; n++){
			
			boolean found = false;
			
			//loop through entries in map
			for (Entry<Character, Integer> map : ciphertext.entrySet())
	   	 	{				
				//if the value in the array matches the value in the map
				if(ciphertextArray[n] == map.getValue() && found == false){
					found = true;
					//insert corresponding character from map into the array
	   	 			ciphertextChars[m] = map.getKey();
	   	 			m++;
	   	 		}
  	 		}			
		}	
		
		//populate map with sorted characters from both arrays
		for(int c = 0; c < plaintextChars.length; c++){
			matched.put(plaintextChars[c], ciphertextChars[c]);
		}

		return matched;
		
	}

}
