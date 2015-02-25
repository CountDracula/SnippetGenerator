import java.util.ArrayList;

/**
 * Created by Pepe on 25.2.2015.
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<String> dikke = new ArrayList<String>();

        dikke.add("Dikke");
        dikke.add("Dikke");
        dikke.add("Dikke");

        for (String s : dikke)
        {
            System.out.println(dikke.indexOf(s));
        }
    }
}
