import java.util.Map;

public class IndexOfCoincidence {
	
	public Double indexOfCoincidence(Map<Character, Integer> occurrences){
		
		Double total = 0.0;
		Double occ = 0.0;
		
		//calculate total of values in map
		for (Map.Entry<Character, Integer> map : occurrences.entrySet())
	 	{
		 	total = total + map.getValue();
	 	}
		
		//numerator of index of coincidence formula
		for (Map.Entry<Character, Integer> map : occurrences.entrySet())
	 	{
		 	occ = occ + (map.getValue() * (map.getValue() - 1));
	 	}
		
		//denominator of index of coincidence formula
		Double index = occ / (total * (total - 1));
		
		return index;
		
	}

}
