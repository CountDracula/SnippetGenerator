import java.io.IOException;

/**
 * Created by Pepe on 25.2.2015.
 */
public class SnippetTester {
    public static void main(String[] args) throws IOException {

        SnippetGenerator snippetGenerator = new SnippetGenerator();
        snippetGenerator.readFile("C:\\temp\\pepe.txt");
        snippetGenerator.getSnippets("President", 2);
      // snippetGenerator.getbyRegex("President", 2);


        //SnippetGeneratorCombo snippetGeneratorCombo = new SnippetGeneratorCombo();
        // snippetGeneratorCombo.readFile("C:\\temp\\pepe.txt");
        //snippetGeneratorCombo.getSnippets("President", 500);
    }
}
