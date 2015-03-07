import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by Veera on 2.3.2015.
 */
public class SnippetGeneratorCombo {
    private ArrayList<String> wordList;
    private BufferedReader reader;
    private File file;
    private String input;

    private HashMap<String, ArrayList<Integer>> indexes;


    public SnippetGeneratorCombo() throws FileNotFoundException {

        input = null;
        wordList = new ArrayList<String>();
        indexes = new HashMap<String, ArrayList<Integer>>();


    }

    public void readFile(String filepath) throws IOException {

        file = new File(filepath);
        reader = new BufferedReader(new FileReader(file));

        while ((input = reader.readLine()) != null) {


            Collections.addAll(wordList, input.split("[ \n\t\r,;:(){}]"));

        }


        for (int i = 0; i < wordList.size(); i++) {
            ArrayList<Integer> positions = new ArrayList<Integer>();
            if (indexes.containsKey(wordList.get(i))) {
                positions = indexes.get(wordList.get(i));
            }
            positions.add(i);
            indexes.put(wordList.get(i), positions);


        }


    }

    public void getSnippets(String word, int snippet) {

        ArrayList<Integer> wordsAround = indexes.get(word);

        StringBuilder stringBuilder = new StringBuilder();

        System.out.println("Your word was " + word + " and you asked for " + snippet + " words before & after : " + "\n");

        for (int i = 0; i < wordsAround.size(); i++) {
            int position = wordsAround.get(i);


            int end = position + snippet;

            // Check that word and snippet are within bounds
            if (end > wordList.size()) {
                end = wordList.size() - 1;
            }
            for (int k = position - snippet; k < end + 1; k++) {

                /// Check for bounds
                if (k < 0) {
                    k = 0;
                }

                stringBuilder.append(wordList.get(k) + " ");

            }
            System.out.println(stringBuilder.toString());
            stringBuilder.setLength(0); /// Reset the string on every iteration

        }

    }
}




