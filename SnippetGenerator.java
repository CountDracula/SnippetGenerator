import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
            words = input.split("[ \n\t\r,;:(){}]"); /// Modify this to change where to split each word. I took out !? and .


            wordList = new ArrayList<String>(Arrays.asList(words));

            // If the word is not in the file, close the reader and inform the user.
            if (!wordList.contains(word)) {
                reader.close();
                System.out.println("Sorry, that word is not in the text file!");

            }


            if (Collections.frequency(wordList, word) == 1) {
                /// toUpperCase so it's easier to spot the given word in this long long sentence...
                System.out.println("Your word was: " + word.toUpperCase() + " and you asked for " + snippet + " words before & after");
                for (String s : wordList) {
                    int previous;
                    int next;


                    if (s.equals(word)) {
                        previous = wordList.indexOf(s) - snippet;
                        next = wordList.indexOf(s) + snippet;


                        finalWords = new ArrayList<String>(wordList.subList(previous, next + 1)); // Needs to be next+1 or the last entry is not included?


                    }

                }
            } else {
                finalWords = new ArrayList<String>();
int p;
                int n;
                for(int i=0; i<wordList.size(); i++){
                    if(wordList.get(i).equals(word))
                    {
                        /// ERROR IS HERE. P and N don't update!
                       p = wordList.indexOf(wordList.get(i)) - snippet;
                       n = wordList.indexOf(wordList.get(i)) + snippet;
                        //System.out.println(i); /// Get i to get index of each occurrence of the word
                        /// So far so good...
                        /// But 2nd iteration fucks everything up.

                        finalWords.add(wordList.get(p));
                        finalWords.add(wordList.get(i));
                        finalWords.add(wordList.get(n));

                        System.out.println("i on : " + i);
                        System.out.println("P = " + p);
                        System.out.println("N =" + n);
                        System.out.println(finalWords.toString());






                    }
                }
                }


            }
        }




    public String printResults() {
        // Display the snippet
        /// append each string in finalwords to stringbuilder
        for (String toPrint : finalWords) {
            sb.append(toPrint + " ");
        }

        System.out.println(sb.toString());
        return sb.toString();
    }
}





