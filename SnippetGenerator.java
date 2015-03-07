import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Pepe on 25.2.2015.
 */
public class SnippetGenerator

{
    private ArrayList<String> wordList;
    private BufferedReader reader;
    private File file;
    private String input;
    private StringBuilder sb;
    private StringBuffer line;

    public SnippetGenerator() throws FileNotFoundException {

        input = null;
        wordList = new ArrayList<String>();


    }

    public void readFile(String filepath) throws IOException {

        line = new StringBuffer(); // used by regex
        file = new File(filepath);
        reader = new BufferedReader(new FileReader(file));

        while ((input = reader.readLine()) != null) {

            // words = input.split("[ \n\t\r,;:(){}]"); /// Modify this to change where to split each word. I took out !? and .
            //Collections.addAll(wordList, words);


            line.append(input.replaceAll("^[^\\-a-zA-Z0-9\\s]+|[^\\-a-zA-Z0-9\\s]+$", " ")); // used by regex
            Collections.addAll(wordList, input.split("[ \n\t\r;:()'-.{}]"));


        }
    }


    public void getSnippets(String word, int snippet) throws IOException {


        sb = new StringBuilder(wordList.size()); // Set stringbuilder initial size


        // If the word is not in the file, close the reader and inform the user.
        if (!wordList.contains(word)) {

            System.out.println("Sorry, that word is not in the text file!");
            reader.close();
            System.exit(0);
        } else {

            System.out.println("Your word was: " + word.toUpperCase() + " and you asked for " + snippet + " words before & after");
            sb.setLength(0); // Clear the sb for a new line
            sb.append("The snippets are: ");
            System.out.println(sb);
            sb.setLength(0);


            for (int i = 0; i < wordList.size(); i++) {

                int end = i + snippet + 1;

                if (end > wordList.size()) {
                    end = wordList.size() - 1;
                }

                if (wordList.get(i).equals(word)) {
                    for (int k = i - snippet; k < end; k++) {

                        if (k < 0) {
                            k = 0;
                        }


                        sb.append(wordList.get(k) + " ");

                    }
                    System.out.println(sb.toString());
                    sb.setLength(0);
                }
            }
        }
    }


    // Regex way.
    public void getbyRegex(String word, int snippet) throws IOException {


        System.out.println("Your word was: " + word.toUpperCase() + " and you requested " + snippet + " words before & after it");
        System.out.println("The snippets are :" + "\n");

        // "((\\S+\\s+){0,1})" --- first group. \\S+ = one or more non-whitespace characters, \\s+ one or more white-space character
        // {0, "+snippet+"} range at least 0, look until snippet
        // Pattern.quote turns word into regex literal
        //"((\\s+\\S+){0,"+snippet+"})" second group


        Pattern pattern = Pattern.compile("((\\S+\\s+){0," + snippet + "})" + Pattern.quote(word) + "((\\s+\\S+){0," + snippet + "})");
        Matcher matcher = pattern.matcher(line.toString());
        while (matcher.find()) {
            System.out.println(matcher.group(0));

        }
    }


}





