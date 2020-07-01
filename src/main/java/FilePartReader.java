import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilePartReader {
    private String filePath;
    private int fromLine;
    private int toLine;


    public FilePartReader(String filePath, int fromLine, int toLine) {
        setup(filePath, fromLine, toLine);
    }

    public void setup(String filePath, int fromLine, int toline) {
        if (toline < fromLine) throw new IllegalArgumentException("The starting line is bigger than the last line.");
        else {
            this.filePath = filePath;
            this.fromLine = fromLine;
            this.toLine = toline;
        }

    }

    public String read() {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(this.filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }

    public String readLines() {
        String returnLines = "";
        String[] lines = read().split("\n");
        if (this.fromLine == this.toLine) {
            returnLines = lines[fromLine - 1];
        } else {
            for (int i = this.fromLine - 1; i < this.toLine + 1; i++) {
                returnLines += lines[i];
                returnLines += " ";
            }
        }

        return returnLines;

    }

    public int getFromLine() {
        return this.fromLine;
    }

    public int getToLine() {
        return this.toLine;
    }
}
