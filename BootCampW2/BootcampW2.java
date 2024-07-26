import java.util.StringTokenizer;
public class BootcampW2 {
    public static void main(String[] argv) {
        // let's go play with methods of the String class !

        String maryPoppins = "Supercalifragilisticexpialidoious";

        // So I may use the quote "be the change you want to see in the world."
        String wiseWords = "The computer was born to solve problems that did not exist before.";

        //1. How many letters are in the maryPoppins variable ?
        int i = maryPoppins.length();
        System.out.println(i);
        //2. What is the integer location of the first 'x' letter in maryPoppins?
        int j = maryPoppins.indexOf("x");
        System.out.println(j);
        //3. Create a new String that is only the second half of the word
        int k = maryPoppins.length() / 2;
        String word = maryPoppins.substring(k);
        System.out.println(word);
        //4. BONUS ! break up the quotation wiseWords into an array of Strings
        int o = 0;
        StringTokenizer st = new StringTokenizer(wiseWords);
        String[] array = new String[st.countTokens()];
        while (st.hasMoreTokens()) {
            array[o] = st.nextToken();
            o++;
        }
        for (String string : array) {
            System.out.print(string + " ");
        }
    }
}
