import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;
/*    Dictionary Class                             
 *    Purpose:  this class holds the dictionary
 *    Author:  	Johan Setyobudi
 *    Data:  	dictionary: TreeMap<String,Integer> - dictionary
 *    		    word: String - the word
 *    Methods:  default constructor - initializes data to blank string, and the dictionary
 *    			addFromFile(Scanner) - reads from file, and adds to dictionary. if word is already in dictionary,
 *    								   it will increase the count by 1
 *    			addFromInput(String) - reads from a string. will add every words to string. if word is already in dictionary,
 *    								   it will increase the count by 1
 *    			clearDictionary() - will clear te dictionary
 *    			wordCount(String) - will get the word count for the passed string, if none, it will display accordingly
 *    			nodeCount() - will display the number of nodes in the TreeMap.
 */
public class Dictionary {
	private TreeMap<String,Integer> dictionary;
	private String word;

	public Dictionary() {
		dictionary = new TreeMap<String,Integer>();
		word = new String();
	}

	public void addFromFile(Scanner input) {
		try {
			while(input.hasNext()) {
				word = input.next().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
				if(dictionary.containsKey(word)) {
					dictionary.put(word, dictionary.get(word) + 1);
				} else if (word != null){
					dictionary.put(word, 1);
				}
			}
		} catch(NullPointerException e) {
			System.err.println("Error opening file. Terminating...\n");	
			return;
		} catch (NoSuchElementException e) {
			System.err.println("File improperly formed. Terminating...");
			return;
		} catch (IllegalStateException e) {
			System.err.println("Error reading from file. Terminating...");
			return;
		}
	}

	public void addFromInput(String word) {
		String[] words = word.split(" ");
		for(int i = 0; i < words.length; i++) {
			words[i] = words[i].replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
			if(dictionary.containsKey(words[i])) {
				dictionary.put(words[i], dictionary.get(words[i]) + 1);
			} else if(words != null) {
				dictionary.put(words[i], 1);
			}		
		}	
	}

	public void clearDictionary() {
		dictionary.clear();
		System.out.println("Dictionary Cleared.\n");
	}

	public void wordCount(String words) {
		word = words.toLowerCase();
		if(dictionary.containsKey(word)) {
			System.out.println(word +" occurs " +dictionary.get(word) +" times.\n");
		} else {
			System.out.println(words +" not found.\n");
		} 
	}

	public void nodeCount() {
		System.out.println("There are "+dictionary.size() +" nodes.\n");
	}
}