import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

public class KeyLengthTwo {
	
	public void keyLengthTwo(String input, String firstOutput, String secondOutput){
		
		 try
		 {
			
			//Read file in from web address
			FileReader fr = new FileReader(input);
			BufferedReader bf = new BufferedReader(fr);
	         
			//convert each line to lower case and then to a string
	 	 	String line = bf.readLine();
	 	 	
	 	 	//arrays for subtexts
	 	 	ArrayList<Character> firstHalf = new ArrayList<Character>();
	 	 	ArrayList<Character> secondHalf = new ArrayList<Character>();
	 	 	
	 	 	int index = 0;
	 	 	
	 	 	while(line != null){
	 	 		
	     		line = line.toLowerCase();   
	    	 
	    	 	//loop through length of string
	    	 	for (int i = 0; i < line.length(); i++){
	    		    
	    	 		char c = line.charAt(i);
	    	 		
	    	 		if(index == 0){
	    	 			firstHalf.add(c);
	    	 			
	    	 			index++;

	    	 		}
	    	 		else{
	    	 			secondHalf.add(c);

	    	 			index = 0;
	    	 		}
	    	 			
	    	 	}
	    	 	
	    	 	line = bf.readLine();
	 	 	}
	 	 	
	 	 	try
	     	{
	    	 	//create new file to print text
	    	 	PrintWriter print = new PrintWriter(firstOutput);
	    	 
	    	 	//print each value to output file
	    	 	for (int i = 0; i < firstHalf.size(); i++)
	    	 	{
	    		 	print.print(firstHalf.get(i));
	    	 	}
	    	 
	    	 	//closes stream
	    	 	print.close();
	     	}
	     	//catches if cannot write to file
	     	catch(IOException e)
	     	{
	    	 	System.out.println("Error: Cannot write to file.");
	     	}
	 	 	
	 	 	try
	     	{
	    	 	//create new file to print text
	    	 	PrintWriter print = new PrintWriter(secondOutput);
	    	 
	    	 	//print each value to output file
	    	 	for (int i = 0; i < secondHalf.size(); i++)
	    	 	{
	    		 	print.print(secondHalf.get(i));
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
