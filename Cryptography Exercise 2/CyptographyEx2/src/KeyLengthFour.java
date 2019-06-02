import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class KeyLengthFour {

	public void keyLengthFour(String input, String firstOutput, String secondOutput, String thirdOutput, String fourthOutput){
		
		 try
		 {
			
			//Read file in from web address
			FileReader fr = new FileReader(input);
			BufferedReader bf = new BufferedReader(fr);
	         
			//convert each line to lower case and then to a string
	 	 	String line = bf.readLine();
	 	 	
	 	 	//arrays for subtexts
	 	 	ArrayList<Character> firstQuarter = new ArrayList<Character>();
	 	 	ArrayList<Character> secondQuarter = new ArrayList<Character>();
	 	 	ArrayList<Character> thirdQuarter = new ArrayList<Character>();
	 	 	ArrayList<Character> fourthQuarter = new ArrayList<Character>();
	 	 	
	 	 	int index = 0;
	 	 	
	 	 	while(line != null){
	 	 		
	     		line = line.toLowerCase();   
	    	 
	    	 	//loop through length of string
	    	 	for (int i = 0; i < line.length(); i++){
	    		    
	    	 		char c = line.charAt(i);
	    	 		
	    	 		if(index == 0){
	    	 			firstQuarter.add(c);
	    	 			
	    	 			index++;

	    	 		}
	    	 		else if(index == 1){
	    	 			secondQuarter.add(c);

	    	 			index++;
	    	 		}
	    	 		
	    	 		else if(index == 2){
	    	 			thirdQuarter.add(c);

	    	 			index++;
	    	 		}
	    	 		
	    	 		else if(index == 3){
	    	 			fourthQuarter.add(c);

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
	    	 	for (int i = 0; i < firstQuarter.size(); i++)
	    	 	{
	    		 	print.print(firstQuarter.get(i));
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
	    	 	for (int i = 0; i < secondQuarter.size(); i++)
	    	 	{
	    		 	print.print(secondQuarter.get(i));
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
	    	 	PrintWriter print = new PrintWriter(thirdOutput);
	    	 
	    	 	//print each value to output file
	    	 	for (int i = 0; i < thirdQuarter.size(); i++)
	    	 	{
	    		 	print.print(thirdQuarter.get(i));
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
	    	 	PrintWriter print = new PrintWriter(fourthOutput);
	    	 
	    	 	//print each value to output file
	    	 	for (int i = 0; i < fourthQuarter.size(); i++)
	    	 	{
	    		 	print.print(fourthQuarter.get(i));
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
