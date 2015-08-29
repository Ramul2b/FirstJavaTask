package ru.apache_maven.FirstJavaTask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Collections;
import java.util.ArrayList;
import java.io.IOException;

/**Reads a strings from a text file input.txt, sort and write them into the file output.txt.

*@version 1.8.
*@author Vdovichenko A.A.
*/
public class ReadAndSortFile {
	
/**
 * Reads a string of characters in the text file input.txt and writes them into an array. 
 * The file specified in the run configuration.
 * @param inputTextFile - text file input.txt from which the symbols are read. 
 * @return textArray - array of sorted rows. For sorting used static method {@link sort}.
 * @throws IOException  when an IO error occurs. Triggered when not right given the way of the files.
*/
  public static ArrayList<String> writeInArrayAndSort (String inputTextFile){

/**
 * ArrayList - no fixed-size array.
 * An array in which to store the character string taken from a file.
*/
    ArrayList<String> textArray = new ArrayList<String>();

/**Started handling of exceptions.*/
   try{
	 
/**	   
* Class BufferedReader reads characters from the input character stream and buffering to effectively read them.
* Class FileReader used to read the character (text) files.
*/
    BufferedReader readTextFile = new BufferedReader(new FileReader(inputTextFile));
			
/** Strings of characters taken from the file. */
    String stringOfSymbols;
			
/** 
 * As long as a character string not null, they are added in the array textArray.
 * This means that an array of lines from input.txt.do recorded as long as have something recording.
*/
    while((stringOfSymbols = readTextFile.readLine())!=null)
        textArray.add(stringOfSymbols);
			
/** Closes the input stream of symbols.*/
    readTextFile.close();

/** Sorting an array.*/
    Collections.sort(textArray);}   

/** Handling of exceptions*/
    catch(IOException input){
        System.out.println("File is not founded.");
    }

/**Returns a sorted array.*/
    return textArray;
  }

/**
 * Records sorted lines to the file output.txt. The file specified in the run configuration.
 * @param textArray - an array that contains a sorted string.
 * @param outputTextFile - a text file in which records sorted lines.
 * @throws IOException if an error occurs IO. Triggered when not right given the way the files.
*/
  public static void writeInOutputFile (ArrayList<String> textArray, String outputTextFile){

/** 
 * Class BufferedWriter writes characters to the output character stream and 
 * their buffering for recording. 
*/
	  
   try{
    BufferedWriter writeTextFile = new BufferedWriter(new FileWriter(outputTextFile)); 

/** The size of an array of character strings.*/
    int arraySize = textArray.size(); 

/** Recording an array to file output.txt.*/
    for (int i = 0; i < arraySize; i++)           		
        writeTextFile.write(textArray.get(i) + "\r\n"); 

/** Closing the output symbol stream and handling of exceptions.*/
    writeTextFile.close();
   }catch(IOException output){
	   System.out.println("File is not founded.");
   }   
   
  }	
		
  public static void main(String[] args){
	  
/** Handling of exceptions.*/
   try{
    writeInOutputFile(writeInArrayAndSort(args[0]), args[1]);
   } catch(ArrayIndexOutOfBoundsException Arr){
	   System.out.println("Index of args[] is wrong. Check path-name of files.");
   }
   
  }
  
}
