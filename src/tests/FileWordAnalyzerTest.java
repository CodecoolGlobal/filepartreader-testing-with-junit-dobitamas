import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {
    @Test
    public void testAlphabeticalOrder(){
        String[] excepted =new String[]{"Boni", "buta", "budos", "egy", "hulye", "is", "kutya", "Nagyon", "Rohadt", "szexi", "ese"};
        FileWordAnalyzer fwa = new FileWordAnalyzer("C://Users/Tamás/Desktop/Projektek/OOP/filepartreader-testing-with-junit-dobitamas/TestTXT.txt", 1, 2);
        System.out.println("Aplhabet expected: " + Arrays.deepToString(excepted));
        String[] words = fwa.getWordsOrderedAlphabetically().toArray(new String[0]);
        System.out.println("Words: " + Arrays.deepToString(words));
        assertArrayEquals(excepted, words);
    }

    @Test
    public void testIfContainsSubstring(){
        String[] excepted = {"kutya", "buta", };
        FileWordAnalyzer fwa = new FileWordAnalyzer("C://Users/Tamás/Desktop/Projektek/OOP/filepartreader-testing-with-junit-dobitamas/TestTXT.txt", 1, 2);
        String[] words =  fwa.getWordsContainingSubstring("ut").toArray(new String[0]);
        assertArrayEquals(excepted, words);

    }

    @Test
    public void testIfPalindrome(){
        String excepted = "ese";
        FileWordAnalyzer fwa = new FileWordAnalyzer("C://Users/Tamás/Desktop/Projektek/OOP/filepartreader-testing-with-junit-dobitamas/TestTXT.txt", 1, 2);
        assertEquals(excepted, fwa.getStringsWhichPalindromes().get(0));
    }
}