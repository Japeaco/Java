import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class KeyLengthFive {

	public void keyLengthFive(String input, String firstOutput, String secondOutput, String thirdOutput, String fourthOutput, String fifthOutput){
		
		 try
		 {
			
			//Read file in from web address
			FileReader fr = new FileReader(input);
			BufferedReader bf = new BufferedReader(fr);
	         
			//convert each line to lower case and then to a string
	 	 	String line = bf.readLine();
	 	 	
	 	 	//arrays for subtexts
	 	 	ArrayList<Character> firstFifth = new ArrayList<Character>();
	 	 	ArrayList<Character> secondFifth = new ArrayList<Character>();
	 	 	ArrayList<Character> thirdFifth = new ArrayList<Character>();
	 	 	ArrayList<Character> fourthFifth = new ArrayList<Character>();
	 	 	ArrayList<Character> fifthFifth = new ArrayList<Character>();
	 	 	
	 	 	int index = 0;
	 	 	
	 	 	while(line != null){
	 	 		
	     		line = line.toLowerCase();   
	    	 
	    	 	//loop through length of string
	    	 	for (int i = 0; i < line.length(); i++){
	    		    
	    	 		char c = line.charAt(i);
	    	 		
	    	 		if(index == 0){
	    	 			firstFifth.add(c);
	    	 			
	    	 			index++;

	    	 		}
	    	 		else if(index == 1){
	    	 			secondFifth.add(c);

	    	 			index++;
	    	 		}
	    	 		
	    	 		else if(index == 2){
	    	 			thirdFifth.add(c);

	    	 			index++;
	    	 		}
	    	 		
	    	 		else if(index == 3){
	    	 			fourthFifth.add(c);

	    	 			index++;
	    	 		}
	    	 		
	    	 		else if(index == 4){
	    	 			fifthFifth.add(c);

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
	    	 	for (int i = 0; i < firstFifth.size(); i++)
	    	 	{
	    		 	print.print(firstFifth.get(i));
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
	    	 	for (int i = 0; i < secondFifth.size(); i++)
	    	 	{
	    		 	print.print(secondFifth.get(i));
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
	    	 	for (int i = 0; i < thirdFifth.size(); i++)
	    	 	{
	    		 	print.print(thirdFifth.get(i));
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
	    	 	for (int i = 0; i < fourthFifth.size(); i++)
	    	 	{
	    		 	print.print(fourthFifth.get(i));
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
	    	 	PrintWriter print = new PrintWriter(fifthOutput);
	    	 
	    	 	//print each value to output file
	    	 	for (int i = 0; i < fifthFifth.size(); i++)
	    	 	{
	    		 	print.print(fifthFifth.get(i));
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
