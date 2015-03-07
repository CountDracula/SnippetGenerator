import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Pepe on 7.3.2015.
 */
public class SnippetTimes {
    private static SnippetGenerator snippetGenerator;
    private static SnippetGeneratorCombo snippetGeneratorCombo;


    public static void main(String[] args) throws IOException {

    testTimes();
    }


    public static void testTimes() throws IOException {
        snippetGenerator = new SnippetGenerator();
        snippetGeneratorCombo = new SnippetGeneratorCombo();

        int numberOfTests = 100;
        //snippetGenerator.readFile("C:\\temp\\def8000.txt");

        snippetGeneratorCombo.readFile("C:\\temp\\def8000.txt");


        double start = System.nanoTime();
        for (int i = 0; i < numberOfTests; i++)
        {

            //snippetGenerator.getSnippets("and", 5);
            snippetGeneratorCombo.getSnippets("and", 5);
           // snippetGenerator.getbyRegex("and", 5);
        }
        double elapsed = (System.nanoTime() - start)/ 1000000;
        double average = (elapsed / numberOfTests);
        System.out.println("The average running time in milliseconds is: ");
        System.out.println(average);
    }


}
