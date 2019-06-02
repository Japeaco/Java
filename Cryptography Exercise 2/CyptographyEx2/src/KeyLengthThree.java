import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class KeyLengthThree {
	
	public void keyLengthThree(String input, String firstOutput, String secondOutput, String thirdOutput){
		
		 try
		 {
			
			//Read file in from web address
			FileReader fr = new FileReader(input);
			BufferedReader bf = new BufferedReader(fr);
	         
			//convert each line to lower case and then to a string
	 	 	String line = bf.readLine();
	 	 	
	 	 	//arrays for subtexts
	 	 	ArrayList<Character> firstThird = new ArrayList<Character>();
	 	 	ArrayList<Character> secondThird = new ArrayList<Character>();
	 	 	ArrayList<Character> thirdThird = new ArrayList<Character>();
	 	 	
	 	 	int index = 0;
	 	 	
	 	 	while(line != null){
	 	 		
	     		line = line.toLowerCase();   
	    	 
	    	 	//loop through length of string
	    	 	for (int i = 0; i < line.length(); i++){
	    		    
	    	 		char c = line.charAt(i);
	    	 		
	    	 		if(index == 0){
	    	 			firstThird.add(c);
	    	 			
	    	 			index++;

	    	 		}
	    	 		else if(index == 1){
	    	 			secondThird.add(c);

	    	 			index++;
	    	 		}
	    	 		
	    	 		else if(index == 2){
	    	 			thirdThird.add(c);

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
	    	 	for (int i = 0; i < firstThird.size(); i++)
	    	 	{
	    		 	print.print(firstThird.get(i));
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
	    	 	for (int i = 0; i < secondThird.size(); i++)
	    	 	{
	    		 	print.print(secondThird.get(i));
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
	    	 	for (int i = 0; i < thirdThird.size(); i++)
	    	 	{
	    		 	print.print(thirdThird.get(i));
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
