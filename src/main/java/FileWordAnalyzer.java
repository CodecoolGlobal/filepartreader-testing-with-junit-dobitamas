import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWordAnalyzer {
    private FilePartReader fpr;


    public FileWordAnalyzer(String filePath, int fromLine, int toLine){
        this.fpr = new FilePartReader(filePath, fromLine, toLine);
    }

    public FilePartReader getFpr() {
        return fpr;
    }

    public ArrayList<String> getWordsOrderedAlphabetically(){
        String text = fpr.readLines();
        String[]words = text.split(" ");
        Arrays.sort(words);

        return new ArrayList<String>(Arrays.asList(words));
    }

    public ArrayList<String> getWordsContainingSubstring(String subString){
        String text = fpr.readLines();
        String[]words = text.split(" ");

        ArrayList<String> returnList = new ArrayList<String>();

        for(int i = 0; i < words.length; i++){
            if(words[i].contains(subString)){
                returnList.add(words[i]);
            }
        }
        return returnList;

    }

    public ArrayList<String> getStringsWhichPalindromes(){
        String text = fpr.readLines();
        String[]words = text.split(" ");

        ArrayList<String> returnList = new ArrayList<>();
        for(String word : words){
            String reverse = "";
            int length = word.length();
            for(int i = length - 1;i >= 0; i--){
                reverse += word.charAt(i);
            }
            if(word.equals(reverse)){
                returnList.add(word);
            }

        }

        return returnList;
    }

}
