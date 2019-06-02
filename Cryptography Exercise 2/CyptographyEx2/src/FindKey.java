import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FindKey {
	
	public Character findKey(Map<Character, Character> chars){
		
		ArrayList<Integer> differences = new ArrayList<Integer>();
		
	 	for (Entry<Character, Character> map : chars.entrySet())
	 	{
		 	int difference = (map.getKey() - 'a') - (map.getValue() - 'a');
		 	
		 	if(difference < 0){
		 		difference = Math.abs(difference);
		 	}
		 	
		 	differences.add(difference);
	 	}
/* 	
 * 
 *   attempt to count most common difference between letters
 *   
	 	Set<Integer> s = new HashSet<Integer>();
	 	
	 	Integer[] frequencies = new Integer[differences.size()];
	 	int index = 0;
	 	
	 	for(int i = 0; i < differences.size(); i++){
	 		
	 		int frequency = 0;
		
	 		for(int j = 0; j < differences.size(); j++){
	 		 		
	 		 	if(differences.get(i) == differences.get(j)){
	 		 			frequency++;
	 		 	}
	 		}
	 		
	 		frequencies[index] = frequency;
	 		index++;
	 	}
	 	
	 	for(int k = 0; k < frequencies.length; k++){
	 		System.out.println(frequencies[k]);
	 	}
	 	
	 	//sort array in descending order
	 	Arrays.sort(frequencies, Collections.reverseOrder());
*/	 	
	 	int ascii = differences.get(0) + 'a';
	 	
	 	char key = (char) ascii;
	 	
	 	return key;
	 			
	}

}
