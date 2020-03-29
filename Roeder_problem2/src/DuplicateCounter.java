import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DuplicateCounter {
	
	Map<String,Integer> wordCounter = new HashMap<String,Integer>();
	
	public void count (String dataFile) throws FileNotFoundException {
		File data = new File(dataFile);
		Scanner in = new Scanner(data);
		
		while (in.hasNext()) {
			String input = in.next().toString();
			String word = cleanWord(input);
			
			if (wordCounter.containsKey(word)) {
				int val = wordCounter.get(word);
				wordCounter.put(word, val+1);
			}
			else {
				wordCounter.put(word, 1);
			}
		}
		in.close();
	}
	
	
	public void write(String outputFile) throws IOException {
		File output = new File (outputFile);
		if (!output.exists()) {
			output.createNewFile();
		}
		
		Set<Map.Entry<String,Integer>> countSet = wordCounter.entrySet();
		FileWriter fw = new FileWriter(output);
		BufferedWriter bw = new BufferedWriter(fw);
		
		for (Map.Entry<String,Integer> e:countSet) {
			String word = e.getKey().toString();
			String num = e.getValue().toString();
			bw.write(word + "\t" + num + "\n");
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
