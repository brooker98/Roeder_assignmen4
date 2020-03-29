import java.io.IOException;

public class Application {
	public static void main(String[] args) throws IOException{
		DuplicateRemover r = new DuplicateRemover();
		r.remove("problem1.txt");
		r.write("unique_words.txt");	
	}
}

