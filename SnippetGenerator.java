import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Pepe on 25.2.2015.
 */
public class SnippetGenerator

{
    private ArrayList<String> wordList;
    private String[] words;
    private BufferedReader reader;
    private File file;
    private String input;
    private ArrayList<String> finalWords;

    private StringBuilder sb;

    public SnippetGenerator() throws FileNotFoundException {

        file = new File("C:\\temp\\test.txt");

        reader = new BufferedReader(new FileReader(file));
        input = null;

    }


    public void getSnippets(String word, int snippet) throws IOException {
        sb = new StringBuilder(snippet * 3); // Big capacity to test this shit properly
        sb.append("The snippet is: ");


        while ((input = reader.readLine()) != null && reader.ready()) {
            words = input.split("[ \n\t\r,;:(){}]");


            wordList = new ArrayList<String>(Arrays.asList(words));

            /// Why does this get printed even if the word is in the file?
            if (!wordList.contains(word)) {
            reader.close();
                System.out.println("Sorry, that word is not in the text file!");

        }


                for (String s : wordList) {
                    int previous;
                    int next;

                    if (word.equals(s)) {
                        previous = wordList.indexOf(s) - snippet;
                        next = wordList.indexOf(s) + snippet;
                        System.out.println("Your word was: " + word + " and you asked for " + snippet + " words before & after");

                        finalWords = new ArrayList<String>(wordList.subList(previous, next + 1)); // Needs to be next+1 or the last entry is not included?


                        /// append each string in finalwords to stringbuilder
                        for (String toPrint : finalWords) {
                            sb.append(toPrint + " ");
                        }


                    }

                }
            }
    }


public String printResults()
{
    // Display the snippet
    System.out.println(sb.toString());
return sb.toString();
}
}





