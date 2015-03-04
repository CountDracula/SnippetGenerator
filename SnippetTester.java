import java.io.IOException;

/**
 * Created by Pepe on 25.2.2015.
 */
public class SnippetTester {
    public static void main(String[] args) throws IOException {

       SnippetGenerator snippetGenerator = new SnippetGenerator();
    //snippetGenerator.getSnippets("Jewish", 2);
   snippetGenerator.getbyRegex("Jewish", 3);

    //snippetGenerator.printResults();

        SnippetGeneratorCombo snippetGeneratorCombo = new SnippetGeneratorCombo();
        snippetGeneratorCombo.readFile();
        snippetGeneratorCombo.getSnippets("Jewish", 3);
    }
}
