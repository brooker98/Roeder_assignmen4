import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.*;

public class DuplicateRemover {

	Set<String> uniqueWords = new HashSet<String>();
	
	public void remove(String dataFile) throws FileNotFoundException {
		File data = new File(dataFile);
		Scanner in = new Scanner(data);
		Set<String> duplicate = new HashSet<String>();
		
		while (in.hasNext()) {
			String input = in.next().toString();
			String word = cleanWord(input);
			
			if(!uniqueWords.add(word)) {
				duplicate.add(word);
			}	
		}
		uniqueWords.removeAll(duplicate);
		in.close();
	}
	
	
	public void write(String outputFile) throws java.io.IOException {
		File output = new File (outputFile);
		if (!output.exists()) {
			output.createNewFile();
		}
		FileWriter fw = new FileWriter(output);
		BufferedWriter bw = new BufferedWriter(fw);
		Iterator<String> word = uniqueWords.iterator();
		while(word.hasNext()) {
			String nextWord = word.next().toString();
			bw.write(nextWord + "\n");
		}
		bw.close();
	}
	
	// converts word to lowercase and removes any punctuation
	private String cleanWord(String input) {
		String temp = input.toLowerCase();
		String word = "";
		for (int i=0; i<temp.length(); i++) {
			if (temp.charAt(i)>='a' && temp.charAt(i)<='z') {
				word = word + temp.charAt(i);
			}
		}
		return word;
	}
}
