import java.io.IOException;

/**
 * Created by Pepe on 25.2.2015.
 */
public class SnippetTester {
    public static void main(String[] args) throws IOException {

       SnippetGenerator snippetGenerator = new SnippetGenerator();
       snippetGenerator.getSnippets("Feyenoord", 5);

    snippetGenerator.printResults();


    }
}
