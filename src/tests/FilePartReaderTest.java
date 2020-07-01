import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    @Test
    public void testFilePartReaderSetup(){
        assertThrows(IllegalArgumentException.class,()-> {
           FilePartReader fpr = new FilePartReader("teszt", 9, 2);
        });
    }

    @Test
    public void testFilePartReaderRead(){
        FilePartReader fpr = new FilePartReader("C://Users/Tamás/Desktop/Projektek/OOP/filepartreader-testing-with-junit-dobitamas/TestTXT.txt", 1, 2);
        System.out.println(fpr.read());
        assertEquals("Boni egy hulye kutya\nNagyon budos ese buta\nRohadt szexi is\n", fpr.read());

    }

    @Test
    public void testFilePartReaderReadLines(){
        FilePartReader fpr = new FilePartReader("C://Users/Tamás/Desktop/Projektek/OOP/filepartreader-testing-with-junit-dobitamas/TestTXT.txt", 1, 2);
        assertEquals("Boni egy hulye kutya Nagyon budos ese buta Rohadt szexi is",fpr.readLines() );

    }
}