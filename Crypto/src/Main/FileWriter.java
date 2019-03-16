package Main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWriter {
    
    public FileWriter() {
    }
    
    public static void writeToFile(ArrayList<String> arrayLines, String aFileName) throws IOException {
        Path filePath = Paths.get(aFileName);
        Files.write(filePath, arrayLines, StandardCharsets.UTF_8);
        //.flush();
    }
    
    public static ArrayList<String> stringToStringList(String input) {
        ArrayList<String> lines = Stream
                .of(input)
                .collect(Collectors.toCollection(ArrayList::new));
        return lines;
    }
}