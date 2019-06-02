/************************************************/
/*** Purpose: Search methods                  ***/
/***                                          ***/
/***                                          ***/
/*** Author: J. A. Peacock                    ***/
/*** Date: 03/11/2016                         ***/
/***                                          ***/
/*** Note: Based on skeleton code provided by ***/
/*** Jason Steggles 23/09/2016                ***/
/************************************************/

import java.io.*;
import java.text.*;
import java.util.*;

public class Search {

/** Global variables for counting comparisons **/
public int compSeq=0;
public int compBin=0;
public int compHash=0;

/** Array of values to be searched and size **/
private int[] A;
private int size;

/** Hash array and size **/
private int[] H;
private int hSize;

/** Constructor **/
Search(int n, int hn)
{
    /** set size of array **/
    size = n;
    hSize = hn;

    /** Create arrays **/
    A = new int[size];
    H = new int[hSize];

    /** Initialize hash array **/
    /** Assume -1 indicates a location is empty **/
    for (int i=0; i<hSize; i++)
    {
        H[i] = -1;
    }
}


/********************************************/
/*** Read a file of numbers into an array ***/
/********************************************/
public void readFileIn(String file)
{
   try
   {
       /** Set up file for reading **/
       FileReader reader = new FileReader(file);
       Scanner in = new Scanner(reader);

       /** Loop round reading in data **/
       for (int i=0;i<size;i++)
       {
          /** Get net value **/
          A[i] = in.nextInt();
       }
    }
    catch (IOException e)
    {
       System.out.println("Error processing file " + file);
    }
}


/*********************/
/*** Hash Function ***/
/*********************/
public int hash(int value)
{
    return value%hSize;
}


/*****************************/
/*** Display array of data ***/
/*****************************/
public void displayData(int line, String header)
{
    /* ** Integer Formatter ** */
    NumberFormat FI = NumberFormat.getInstance();
    FI.setMinimumIntegerDigits(3);

    /** Print header string **/
    System.out.print("\n\n"+header);

    /** Display array data **/
    for (int i=0;i<size;i++)
    {
        /** New line? **/
        if (i%line == 0) 
        { 
             System.out.println(); 
        }
   
        /** Display value **/     
        System.out.print(FI.format(A[i])+" ");
    }
}

/**************************/
/*** Display hash array ***/
/**************************/
public void displayHash(int line)
{
    /** Integer Formatter **/
    NumberFormat FI = NumberFormat.getInstance();
    FI.setMinimumIntegerDigits(3);

    /** Print header string **/
    System.out.print("\n\nHash Array of size " + hSize);

    /** Display array data **/
    for (int i=0;i<hSize;i++)
    {
        /** New line? **/
        if (i%line == 0) 
        { 
             System.out.println(); 
        }
   
        /** Display value **/     
        System.out.print(FI.format(H[i])+" ");
    } 
}

/*********************************/
/*** Sequential Search Algorithm  ***/
/*********************************/
public int seqSearch(int key) {
	
	/* Loop through values in list */
	for(int i = 0; i < size; i++){
		
		/* Check if value is larger than key */
		compSeq++;
		/* if value in position is greater than or equal to the key */
		if(A[i] >= key){	
			/* Check for if value in position is equal to key */
			compSeq++;
			if(A[i] == key){
				return i;
			}
			else{
				return -1;
			}
		}
	}	
	return -1;
}

/*********************************/
/*** Binary Search Algorithm  ***/
/*********************************/
public int binSearch(int key, int L, int R)
{
	/* If right pointer is less than left pointer, return -1 */
	if (R < L){
		return -1;
	}
	
	/* Calculate mid point */
	int m = (R + L)/2;
	
	/* Comparison if key equals value in position */
	compBin++;
	if (key == A[m]){
		return m;
	}
	
	/* Comparison for if key is larger than value in position */
	compBin++;
	if (key > A[m]){
		return binSearch(key, m+1, R);
	}
	else{
		return binSearch(key, L, m-1);
	}
}

/**************************/
/*** Add to Hash Array  ***/
/**************************/
private void addToHash(int value)
{
	/* Hash function on value */
	int loc = hash(value);
	
	/* While there's an empty position */
	while(H[loc] != -1){
		
		/* loop around if location is greater than the size of the array */
		if(loc > hSize){
			loc = 0;
		}
		
		else{
			/* Increment and search next position for empty space */
			loc = (loc + 1)%hSize;
		}
	}
	
	/* Insert value into position in array */
	H[loc] = value;
}

/**********************************/
/*** Read Data into Hash Array  ***/
/**********************************/
public void readIntoHash(String file)
{
	try
	   {
	       /* Set up file for reading */
	       FileReader reader = new FileReader(file);
	       Scanner in = new Scanner(reader);

	       /* While there's another input from the file */
	       while(in.hasNextInt())
	       {
	    	   /* Convert next value in file to an integer */
	    	   int value = in.nextInt();
	    	   /* Add value to hash array using method */
	    	   addToHash(value);
	       }	       
	   	
	    }
		/* Catch exception */
	    catch (IOException e)
	    {
	    	/* Print error message */
	    	System.out.println("Error processing file " + file);
	    }
}

/**************************/
/*** Search Hash Table  ***/
/**************************/
public int hashSearch(int key)
{
	/* Hash function on key */
	int loc = hash(key);
	
	/* Check for if it is equal to the value */
	compHash++;
	if(H[loc] == key){
		return loc;
	}

	/* While there's an empty position i.e. while the position is -1 */
    while(H[loc] != -1) {
    	int end = 0;
    	end++;
    	/* Check for -1 */
    	compHash++;
    	/* Check for the value */
    	compHash++;
    	/* If the key is in the position, return the position */
    	if(H[loc] == key){
    		return loc;
    	}
    	
    	/* loop around if location is greater than the size of the array */
    	if(loc > hSize){
    		loc = 0;
    	}
    	
    	/* return -1 if loop has been through every element */
    	if(end == hSize){
    		return -1;
    	}
    	
    	else{
    		/* Increment and search next position */
    		loc = (loc + 1)%hSize;
    	}
    }
	/*Comparison with -1*/
	compHash++;
    /* If key not found return -1 */
    return -1;
}

} /*** End of class Search ***/
 