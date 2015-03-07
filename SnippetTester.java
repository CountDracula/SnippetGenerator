import java.io.IOException;

/**
 * Created by Pepe on 25.2.2015.
 */
public class SnippetTester {
    public static void main(String[] args) throws IOException {

        SnippetGenerator snippetGenerator = new SnippetGenerator();
        snippetGenerator.readFile("C:\\temp\\pepe.txt");
        snippetGenerator.getSnippets("Jewish", 500);
        // snippetGenerator.getbyRegex("President", 5);


        //SnippetGeneratorCombo snippetGeneratorCombo = new SnippetGeneratorCombo();
        // snippetGeneratorCombo.readFile("C:\\temp\\pepe.txt");
        //snippetGeneratorCombo.getSnippets("President", 500);
    }
}
