import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by prasanthnair on 5/9/15.
 * https://leetcode.com/problems/text-justification/
 */
public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List output = new ArrayList();
        ArrayList lineArray = new ArrayList();
        int lineLength = 0;
        int wordsAccountedFor = 0;
        int minSpaces = 0;

        while (true) {
            for (int i = wordsAccountedFor; i < words.length; i++) {
                if (words[i].length() + lineLength + wordsAccountedFor - 1<= maxWidth) {
                    lineArray.add(words[i]);
                    lineLength += words[i].length();
                    wordsAccountedFor++;
                    minSpaces++;
                } else {
                    break;
                }
            }

            minSpaces--;
            lineLength += minSpaces;
            int spaceDiff = maxWidth - lineLength;
            int spaceMod = spaceDiff % minSpaces;
            if (minSpaces  == lineArray.size()) {
                for (int i = 0; i < lineArray.size() - 1; i++) {
                    output.add(lineArray.get(i) + " ");
                }
                output.add(lineArray.get(lineArray.size() - 1));
                minSpaces = 0;
                lineArray.clear();
                lineLength = 0;
            }
            if (wordsAccountedFor == words.length) {
                break;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        TextJustification tj = new TextJustification();
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        List output  = tj.fullJustify(words, 10);
        System.out.println(Arrays.asList(output));
//
//        for (int i = 0; i < output.size(); i++) {
//            System.out.println(output.get(i));
//        }
    }
}
