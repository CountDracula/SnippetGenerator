import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by Veera on 2.3.2015.
 */
public class SnippetGeneratorCombo {
    private ArrayList<String> wordList;
    private String[] words;
    private BufferedReader reader;
    private File file;
    private String input;

    private HashMap<String, ArrayList<Integer>> indexes;


    public SnippetGeneratorCombo() throws FileNotFoundException {
        file = new File("C:\\temp\\pepe.txt");
        reader = new BufferedReader(new FileReader(file));
        input = null;
        wordList = new ArrayList<String>();

        indexes = new HashMap<String, ArrayList<Integer>>();


    }

    public void readFile() throws IOException {
        while ((input = reader.readLine()) != null) {

            words = input.split("[ \n\t\r,;:(){}]"); /// Modify this to change where to split each word. I took out !? and .
            Collections.addAll(wordList, words);
            //System.out.println(wordList.toString());
        }


        for (int i = 0; i < wordList.size(); i++) {
            ArrayList<Integer> positions = new ArrayList<Integer>();
            if (indexes.containsKey(wordList.get(i))) {
                positions = indexes.get(wordList.get(i));
            }
            positions.add(i);
            indexes.put(wordList.get(i), positions);


        }

        System.out.println(indexes.toString());

    }

    public void getSnippets(String word, int snippet) {

        ArrayList<Integer> dikke = indexes.get(word);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < dikke.size(); i++) {
            int position = dikke.get(i);
            for (int k = position - snippet + 1; k < position + snippet + 1; k++) {

               stringBuilder.append(wordList.get(k) + " ");

                if (k>=(position+snippet))
                {
                    System.out.println(stringBuilder.toString());
                    stringBuilder.setLength(0); /// Reset the string on every iteration
                }

            }


        }

    }
}




