import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

public class LetterCount {
	
	public void countLetters(String filename, String output, Map<Character, Integer> letters){
		
		 try
		 {
			
			//Read file in from web address
			FileReader fr = new FileReader(filename);
			BufferedReader bf = new BufferedReader(fr);
	         
			//convert each line to lower case and then to a string
	 	 	String line = bf.readLine();
		     			
	 	 		//continue to read input of file until stream ends
		     	while(line != null){
		     		
		     		line = line.toLowerCase();   
		    	 
		    	 	//loop through length of string
		    	 	for (int i = 0; i < line.length(); i++){
		    		    
		    		 	//convert each letter in the line to a character
		    		 	char c = line.charAt(i); 

		    		 	//If letter exists as a key in the map
		    		 	if(letters.containsKey(c)){
		    			 	//increment value/counter of that character
		    			 	letters.put(c, letters.get(c) + 1);
		    		 	}
		    	 	 
		    		 	//If it is anything but a letter skip and continue while loop
		    		 	else {
		    			 	continue;
		    		 	}	    
		    	 	}
		    	 	
		    	 	line = bf.readLine();   
		     	}
		     
		     	try
		     	{
		    	 	//create new file to print text
		    	 	PrintWriter print = new PrintWriter(output);
		    	 
		    	 	//print each value to output file
		    	 	for (Map.Entry<Character, Integer> map : letters.entrySet())
		    	 	{
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
		 
		 	//catches if file is unreadable
		 	catch (IOException e)
		 	{
			 	System.out.println("Error: cannot read file.");
		 	}

		}

}
