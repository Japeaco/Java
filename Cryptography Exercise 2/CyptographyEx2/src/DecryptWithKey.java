import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class DecryptWithKey {

public void decrypt(String password, String inputFilename, String outputFilename){
		
		try{
			
			//Read file in from web address
			FileReader fr = new FileReader(inputFilename);
			BufferedReader bf = new BufferedReader(fr);
			
			//array for password
			char[] passwordChars = new char[password.length()];
			
			int j = 0;
			
			//print password characters into array
			for(int i = 0; i < password.length(); i++){
				
				//place character at this poistion into array
				char c = password.charAt(i);
				passwordChars[j] = c;
				
				//increment index for array
				j++;
			}
			
			try{
				
				PrintWriter print = new PrintWriter(outputFilename);
				
				String line = bf.readLine();
				int p = 0;
				
				while(line != null){
					
					line = line.toLowerCase();
					
					//loop through length of line
					for(int i = 0; i < line.length(); i++){
						
						char c = line.charAt(i);
						
						//else statements to print symbols and numbers
						if(c == ',')
						{
							print.print(',');
							p++;
						}
						else if(c == '.')
						{
							print.print('.');
							p++;
						}
						else if(c == '"')
						{
							print.print('"');
							p++;
						}
						else if(c == '?')
						{
							print.print('?');
							p++;
						}
						else if(c == '!')
						{
							print.print('!');
							p++;
						}
						else if(c == '-')
						{
							print.print('-');
							p++;
						}
						else if(c == ' ')
						{
							print.print(' ');
							p++;
						}		
						else if(c == '(')
						{
							print.print('(');
						}
						else if(c == ')')
						{
							print.print(')');
						}
						else if(c == '[')
						{
							print.print('[');
						}
						else if(c == ']')
						{
							print.print(']');
						}
						else if(c == '{')
						{
							print.print('}');
						}
						else if(c == '*')
						{
							print.print('*');
						}
						else if(c == '#')
						{
							print.print('#');
						}
						else if(c == ':')
						{
							print.print(':');
						}
						else if(c == ';')
						{
							print.print(';');
						}
						else if(c == '-')
						{
							print.print('-');
							p++;
						}
						else if(c == ' ')
						{
							print.print(' ');
							p++;
						}		
						else if(c == '0')
						{
							print.print('0');
						}
						else if(c == '1')
						{
							print.print('1');
						}
						else if(c == '2')
						{
							print.print('2');
						}
						else if(c == '3')
						{
							print.print('3');
						}
						else if(c == '4')
						{
							print.print('4');
						}
						else if(c == '5')
						{
							print.print('5');
						}
						else if(c == '6')
						{
							print.print('6');
						}
						else if(c == '7')
						{
							print.print('7');
						}
						else if(c == '8')
						{
							print.print('8');
						}
						else if(c == '9')
						{
							print.print('9');
						}	
						
						//statements to shift characters
						else if(p < passwordChars.length){
							
							//if less than 0 wraparound characters by adding 26
							if(( ((int) c -'a') - ((int) passwordChars[p] - 'a')) < 0){
							
								//minus ascii of password character from character in text
								int original = (((int) c -'a') - ((int) passwordChars[p] - 'a')) + 26 + 'a';
								char rotate = (char) original;
							
								print.print(rotate);
							
								//increment index for password
								p++;
							}
							else{
								
								//minus ascii of password character from character in text
								int ascii = (((int) c -'a') - ((int) passwordChars[p] - 'a')) + 'a';
								char rotate = (char) ascii;
							
								print.print(rotate);
							
								p++;
							}
						}
						else if(p >= passwordChars.length){
							
							//return to index 0 of password
							p = 0;
							
							//if less than 0 wraparound characters by adding 26
							if(( ((int) c -'a') - ((int) passwordChars[p] - 'a')) < 0){
								
								//minus ascii of password character from character in text
								int original = (((int) c -'a') - ((int) passwordChars[p] - 'a')) + 26 +'a';
								char rotate = (char) original;
							
								print.print(rotate);
							
								p++;
							}
							else{
								
								//minus ascii of password character from character in text
								int ascii = (((int) c -'a') - ((int) passwordChars[p] - 'a')) + 'a';
								char rotate = (char) ascii;
							
								print.print(rotate);
							
								p++;
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
	    	System.out.println("Error: Cannot read file.");
	    }
		
	}
	
}
