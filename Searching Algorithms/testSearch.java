/******************************************************/
/*** Purpose: Test class to illustrate Search class ***/
/***                                                ***/
/*** Author: J. A. Peacock                          ***/
/*** Date: 03/11/2016                               ***/
/******************************************************/

import java.io.*;
import java.util.Scanner;

public class testSearch
{
   public static void main(String[] args) throws FileNotFoundException 
   {
         
       Search S = new Search(100, 151);
      
       /** Read in test data **/
       S.readFileIn("C:/pc/swap/university/Year 2/"
         		+ "Algorithm Design and Analysis/studSearch/data1.txt");
       
       /** Read file into hash array **/
       S.readIntoHash("C:/pc/swap/university/Year 2/"
         		+ "Algorithm Design and Analysis/studSearch/data1.txt");
       
       /** Sequential search on Array **/
       System.out.println("Sequential search on array: ");
       
       FileReader seqReader = new FileReader("C:/pc/swap/university/Year 2/"
    		   + "Algorithm Design and Analysis/studSearch/search1.txt");
       Scanner seqIn = new Scanner(seqReader);

       int seqAdd = 0;
       
       while(seqIn.hasNextInt())
       {
    	   S.compSeq = 0;
    	   int x = seqIn.nextInt();
    	   seqIn.nextLine();
           System.out.printf("\nLocation of value %d in array: %d", x,
        		   S.seqSearch(x));
           System.out.println("\nNumber of comparisons: " + S.compSeq);
           seqAdd += S.compSeq;
       }
       
       int seqAverage = seqAdd/10;
       System.out.printf("\nSequential search average: %d", seqAverage);
       
       /** Binary search on Array **/
       System.out.println("\n\nBinary search on array: ");
       
       FileReader binReader = new FileReader("C:/pc/swap/university/Year 2/"
    		   + "Algorithm Design and Analysis/studSearch/search1.txt");
       Scanner binIn = new Scanner(binReader);
       
       int binAdd = 0;
       
       while(binIn.hasNextInt())
       {
    	   S.compBin = 0;
    	   int x = binIn.nextInt();
    	   binIn.nextLine();
           System.out.printf("\nLocation of value %d in array: %d", x,
        		   S.binSearch(x, 0, 100));
           System.out.println("\nNumber of comparisons: " + S.compBin); 
           binAdd += S.compBin;
       }
       
       int binAverage = binAdd/10;
       System.out.printf("\nBinary search average: %d", binAverage);
       
       /** Hash search on Array **/
       System.out.println("\n\nHash search on array: ");
       
       FileReader hashReader = new FileReader("C:/pc/swap/university/Year 2/"
    		   + "Algorithm Design and Analysis/studSearch/search1.txt");
       Scanner hashIn = new Scanner(hashReader);
          
       int hashAdd = 0;
       
       while(hashIn.hasNextInt())
       {
       	   S.compHash = 0;
       	   int x = hashIn.nextInt();
       	   hashIn.nextLine();
       	   System.out.printf("\nLocation of value %d in array: %d", x,
           		   S.hashSearch(x));
       	   System.out.println("\nNumber of comparisons: " + S.compHash); 
       	   hashAdd += S.compHash;
       }
       
       int hashAverage = hashAdd/10;
       System.out.printf("\nHash search average: %d", hashAverage);
       
/**************************************************************************************/
       
       Search S2 = new Search(1000, 1499);
       
       /** Read in test data **/
       S2.readFileIn("C:/pc/swap/university/Year 2/"
    		   + "Algorithm Design and Analysis/studSearch/data2.txt");
       
       /** Read file into hash array **/
       S2.readIntoHash("C:/pc/swap/university/Year 2/"
    		   + "Algorithm Design and Analysis/studSearch/data2.txt");
       
       /** Sequential search on Array **/
       System.out.println("\n\nSequential search on array: ");
       
       FileReader seqReader2 = new FileReader("C:/pc/swap/university/Year 2/"
    		   + "Algorithm Design and Analysis/studSearch/search2.txt");
       Scanner seqIn2 = new Scanner(seqReader2);
       
       int seqAdd2 = 0;

       while(seqIn2.hasNextInt())
       {
    	   S2.compSeq = 0;
    	   int x = seqIn2.nextInt();
    	   seqIn2.nextLine();
    	   System.out.printf("\nLocation of value %d in array: %d", x,
       		   S2.seqSearch(x));
    	   System.out.println("\nNumber of comparisons: " + S2.compSeq); 
    	   seqAdd2 += S2.compSeq;
       }
       
       int seqAverage2 = seqAdd2/10;
       System.out.printf("\nSequential search average: %d", seqAverage2);
      
       /** Binary search on Array **/
       System.out.println("\n\nBinary search on array: ");
      
       FileReader binReader2 = new FileReader("C:/pc/swap/university/Year 2/"
    		   + "Algorithm Design and Analysis/studSearch/search2.txt");
       Scanner binIn2 = new Scanner(binReader2);
       
       int binAdd2 = 0;
      
       while(binIn2.hasNextInt())
       {
    	   S2.compBin = 0;
    	   int x = binIn2.nextInt();
    	   binIn2.nextLine();
    	   System.out.printf("\nLocation of value %d in array: %d", x,
    			   S2.binSearch(x, 0, 1000));
    	   System.out.println("\nNumber of comparisons: " + S2.compBin); 
    	   binAdd2 += S2.compBin;
       }
       
       int binAverage2 = binAdd2/10;
       System.out.printf("\nBinary search average: %d", binAverage2);
      
       /** Hash search on Array **/
       System.out.println("\n\nHash search on array: ");
      
       FileReader hashReader2 = new FileReader("C:/pc/swap/university/Year 2/"
    		   + "Algorithm Design and Analysis/studSearch/search2.txt");
       Scanner hashIn2 = new Scanner(hashReader2);
       
       int hashAdd2 = 0;
         
       while(hashIn2.hasNextInt())
       {
      	   S2.compHash = 0;
      	   int x = hashIn2.nextInt();
      	   hashIn2.nextLine();
      	   System.out.printf("\nLocation of value %d in array: %d", x,
          		   S2.hashSearch(x));
      	   System.out.println("\nNumber of comparisons: " + S2.compHash); 
      	   hashAdd2 += S2.compHash;
       }
       
       int hashAverage2 = hashAdd2/10;
       System.out.printf("\nHash search average: %d", hashAverage2);
   }
   
}
