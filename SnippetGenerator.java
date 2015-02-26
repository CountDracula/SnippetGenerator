import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private String endResult;
    private StringBuilder sb;

    public SnippetGenerator() throws FileNotFoundException {

        file = new File("C:\\temp\\pepe.txt");
        reader = new BufferedReader(new FileReader(file));
        input = null;
        wordList = new ArrayList<String>();


    }

    // TODO fix array out of bounds && split snippets better at endResult
    public void getSnippets(String word, int snippet) throws IOException {




        while ((input = reader.readLine()) != null) {

            words = input.split("[ \n\t\r,;:(){}]"); /// Modify this to change where to split each word. I took out !? and .
            Collections.addAll(wordList, words);

        }
        sb = new StringBuilder(words.length); // Set stringbuilder initial size
        sb.append("The snippet is: ");

            // If the word is not in the file, close the reader and inform the user.
            if (!wordList.contains(word)) {

                System.out.println("Sorry, that word is not in the text file!");
                reader.close();
                System.exit(0);
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

                // If there are more than 1 occurrence ...
            } else {
                finalWords = new ArrayList<String>();
                System.out.println("Your word was: " + word.toUpperCase() + " and you asked for " + snippet + " words before & after");
                sb.setLength(0); // Clear the sb
                sb.append("The snippets are: ");

                for (int j = 0; j < wordList.size(); j++) {


                    if (wordList.get(j).equals(word)) {

                        int p = j - snippet;
                        int n = j + snippet;


                        /// Option one
                        finalWords.addAll(wordList.subList(p, n + 1));




                    }
                }

            }
        }

// Regex way. Only works with 2 words though
public void getbyRegex(String word, int snippet) throws IOException {



    StringBuffer line = new StringBuffer();

    while ((input = reader.readLine()) != null) {

        line.append(input); // Append every word into a single string
    }

    System.out.println("Your word was: " + word.toUpperCase() + " and you requested " + snippet + " words before & after it");
    System.out.println("The snippets are :" + "\n");

    // "((\\S+\\s+){0,1})" --- first group. \\S+ = one or more whitespace, \\s+ one or more non white-space character
    // {0, "+snippet+"} range at least 0, look until snippet
    // Pattern.quote turns word into regex literal
    //"((\\s+\\S+){0,"+snippet+"})" second group


Pattern pattern = Pattern.compile("((\\S+\\s+){0,"+snippet+"})" + Pattern.quote(word) + "((\\s+\\S+){0,"+snippet+"})");
    Matcher matcher = pattern.matcher(line.toString());
    while (matcher.find())
    {
        System.out.println(matcher.group(0));

    }
}

    public String printResults() {
        // Display the snippet
        /// append each string in finalwords to stringbuilder
        for (String toPrint : finalWords) {
            sb.append(toPrint + " ");
        }
        endResult = sb.toString();
        System.out.println(endResult);
        return endResult;
    }
}





