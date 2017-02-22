import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*    Class Assign4                             
 *    Purpose:  This class holds the main and openfile methods for the assignment 4 project
 *    Author:  Johan Setyobudi, Linda Crane
 *    Data:   Scanner input, keyboard: 2 instances of Scanner class, one for user input, one to read file
 *    Methods:  main(String): The method will then attempt to read a file and add all the words to the dictionary. 
 *    				  User can also add their own words/phrase/sentance from keyboard. Also to search for the word,
 *    				  and display then number of nodes. 
 *    		openFile(): This method will take user input for the file name they want to process, and pass 
 *    				  scanner object to main. Also the various exceptions when trying to open the file.
 *    				  Adapted from Linda Crane's assign1 class in Assignment 1 solution.
 *            
 */
public class Assign4 {
	public static void main(String[] args) {
		Dictionary dictionary = new Dictionary();
		String choice;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Enter 1 to clear dictionary,"
					+ "\n2 to add text from keyboard,"
					+ "\n3 to add text from file,"
					+ "\n4 to search for a word count,"
					+ "\n5 to display number of nodes,"
					+ "\n6 to quit");
			choice = input.nextLine();
			switch(choice) {
			case "1":
				dictionary.clearDictionary();
				break;
			case "2":
				System.out.println("Please enter text: ");
				dictionary.addFromInput(input.nextLine());
				System.out.println();
				break;
			case "3":
				Scanner keyboard;
				keyboard = openFile();
					dictionary.addFromFile(keyboard);
				System.out.println();
				break;
			case "4":
				System.out.println("Please enter a word to search: ");
				dictionary.wordCount(input.nextLine());
				break;
			case "5":
				dictionary.nodeCount();
				break;
			case "6":
				System.out.println("Quitting...");
				break;
			default:
				System.out.println("Invalid choice. Please choose an option.\n");
				break;	
			}
		} while(!choice.equalsIgnoreCase("6"));
	}

	public static Scanner openFile() {
		Scanner keyboard = new Scanner(System.in);
		Scanner inFile = null;
		System.out.print("Enter name of file to process: ");
		String temp = keyboard.next();
		File file = new File(temp);
		try {
			if (file.exists()) {
				inFile = new Scanner(file);
			}
			return inFile;
		} catch (NoSuchElementException e) {
			System.err.println("File improperly formed. Terminating...");
			return null;
		} catch (IllegalStateException e) {
			System.err.println("Error reading from file. Terminating...");
			return null;
		} catch (FileNotFoundException e) {
			System.err.println("Error opening file. Terminating...");	
			return null;
		} 
	}
}