import java.io.IOException;

public class Application {
	public static void main(String[] args) throws IOException{
		DuplicateCounter c = new DuplicateCounter();
		c.count("problem2.txt");
		c.write("unique_word_counts.txt");
	}
}
