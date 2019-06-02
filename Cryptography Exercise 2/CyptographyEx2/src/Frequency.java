import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;

public class Frequency {
	
		public void frequency(String output, Map<Character, Integer> letters, Map<Character, Double> frequency){
		
		double total = 0.0;
		
		try
	     {
	    	 //create new file to print text
	    	 PrintWriter print = new PrintWriter(output);
	    	 
	    	 //adds together each value in the map
	    	 for (Map.Entry<Character, Integer> map : letters.entrySet())
	    	 {
	    		  total = total + map.getValue();
	    	 }
	    	 
	    	 //prints total of all values in map
	    	 print.println("Total: " + total);

	    	 for (Map.Entry<Character, Integer> map : letters.entrySet())
	    	 {
	    		 //divides in value in map by total and inserts into new map
	    		 frequency.put(map.getKey(), (map.getValue()/total));
	    	 }
	    	 
	    	 for (Entry<Character, Double> map : frequency.entrySet())
	    	 {
	    		 //prints out each value of new map
	    		 print.println(map.getKey() + " = " + map.getValue());
	    	 }
	    	 
	    	 //closes stream
	    	 print.close();
	     }
	     //catches if cannot write to file
	     catch(IOException e)
	     {
	    	 System.out.println("Error: Cannot write to file.");
	     }
		
	}

}
