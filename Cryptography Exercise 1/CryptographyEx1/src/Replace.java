import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Replace {
	
	public void replace(Map<Character, Character> characters, String input, String output){
		
		try {
			
			//Read file in from web address
			FileReader fr = new FileReader(input);
			BufferedReader bf = new BufferedReader(fr);
			
			try{
			 
				PrintWriter print = new PrintWriter(output);
				
				String line = bf.readLine();
				
				while(line != null){

					line = line.toLowerCase();
		    	 
					//loop through length of string
					for (int i = 0; i < line.length(); i++)
					{ 
						//convert each letter in the line to a character
						char c = line.charAt(i); 
						boolean found = false;
		    	 
						//loop through characters in array
						for (Entry<Character, Character> map : characters.entrySet())
						{
							//if statements for manual tuning
							if(c == 'l' && found == false)
							{
								print.print('h');
								found = true;
							}
							if(c == 'b' && found == false)
							{
								print.print('x');
								found = true;
							}
							else if(c == 'w' && found == false)
							{
								print.print('s');
								found = true;
							}
							else if(c == 'g' && found == false)
							{
								print.print('c');
								found = true;
							}
							else if(c == 'p' && found == false)
							{
								print.print('l');
								found = true;
							}
							else if(c == 's' && found == false)
							{
								print.print('o');
								found = true;
							}
							else if(c == 't' && found == false)
							{
								print.print('p');
								found = true;
							}
							else if(c == 'h' && found == false)
							{
								print.print('d');
								found = true;
							}
							else if(c == 'c' && found == false)
							{
								print.print('y');
								found = true;
							}
							else if(c == 'v' && found == false)
							{
								print.print('r');
								found = true;
							}
							else if(c == 'q' && found == false)
							{
								print.print('m');
								found = true;
							}
							else if(c == 'k' && found == false)
							{
								print.print('g');
								found = true;
							}
							else if(c == 'j' && found == false)
							{
								print.print('f');
								found = true;
							}
							else if(c == 'a' && found == false)
							{
								print.print('w');
								found = true;
							}
							else if(c == 'y' && found == false)
							{
								print.print('u');
								found = true;
							}
							else if(c == 'u' && found == false)
							{
								print.print('q');
								found = true;
							}
							else if(c == 'n' && found == false)
							{
								print.print('j');
								found = true;
							}
							else if(c == 'o' && found == false)
							{
								print.print('k');
								found = true;
							}
							//if character matches a ciphertext character
							else if(c == map.getValue() && found == false)
							{
								//print corresponding plaintext character
								print.print(map.getKey());
								found = true;
							}
							//else statements to print symbols
							else if(c == ',' && found == false)
							{
								print.print(',');
								found = true;
							}
							else if(c == '.' && found == false)
							{
								print.print('.');
								found = true;
							}
							else if(c == '"' && found == false)
							{
								print.print('"');
								found = true;
							}
							else if(c == '?' && found == false)
							{
								print.print('?');
								found = true;
							}
							else if(c == '!' && found == false)
							{
								print.print('!');
								found = true;
							}
							else if(c == '-' && found == false)
							{
								print.print('-');
								found = true;
							}
							else if(c == '(' && found == false)
							{
								print.print('(');
								found = true;
							}
							else if(c == ')' && found == false)
							{
								print.print(')');
								found = true;
							}
							else if(c == '[' && found == false)
							{
								print.print(']');
								found = true;
							}
							else if(c == '{' && found == false)
							{
								print.print('}');
								found = true;
							}
							else if(c == '*' && found == false)
							{
								print.print('*');
								found = true;
							}
							else if(c == '#' && found == false)
							{
								print.print('#');
								found = true;
							}
							else if(c == ':' && found == false)
							{
								print.print(':');
								found = true;
							}
							else if(c == ';' && found == false)
							{
								print.print(';');
								found = true;
							}
							else if(c == ' ' && found == false)
							{
								print.print(' ');
								found = true;
							}	
							
						}
						
					}
					
					line = bf.readLine();
				}
				
				print.close();
				
			}
		    catch(IOException e)
		    {
		    	System.out.println("Error: Cannot write to file.");
		    }
						
		}
		
	    catch(IOException e)
	    {
	    	System.out.println("Error: Cannot open file.");
	    }
	}

}
