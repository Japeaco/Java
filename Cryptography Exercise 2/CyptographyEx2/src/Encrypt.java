import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Encrypt {
	
	public void encrypt(String password, String inputFilename, String outputFilename){
		
		try{
			
			//Read file in from web address
			FileReader fr = new FileReader(inputFilename);
			BufferedReader bf = new BufferedReader(fr);
			
			char[] passwordChars = new char[password.length()];
			
			int j = 0;
			
			//loop through length of password
			for(int i = 0; i < password.length(); i++){
				
				//insert characters into an array
				char c = password.charAt(i);
				passwordChars[j] = c;
				
				j++;
			}
			
			try{
				
				PrintWriter print = new PrintWriter(outputFilename);
				
				String line = bf.readLine();
				int p = 0;
				
				while(line != null){
					
					//convert each line to lowercase
					line = line.toLowerCase();
					
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
						
						//statements to rotate characters
						else if(p < passwordChars.length){
							
							//Shifts the character by adding the ascii of the character of the password. modulus used if ascii goes beyond 26 to wrap characters around.
							int ascii = (( (int) c -'a' + (int) passwordChars[p] - 'a') % 26) + 'a';
							//converts ascii to character
							char rotate = (char) ascii;
							
							print.print(rotate);
							
							p++;
						}
						else if(p >= passwordChars.length){
							
							//p reset to 0 to use password from index 0
							p = 0;
							
							//Shifts the character by adding the ascii of the character of the password. modulus used if ascii goes beyond 26 to wrap characters around.
							int ascii = (( (int) c -'a' + (int) passwordChars[p] - 'a') % 26) + 'a';
							//converts ascii to character
							char rotate = (char) ascii;
							
							print.print(rotate);
							
							p++;
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
