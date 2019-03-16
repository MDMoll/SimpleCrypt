package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReader {
    FileReader fileReader;
    private ROT13 ROT13;
    private BufferedReader br;
    
    public static String loadDataFromFile(String filePath) throws IOException {
        BufferedReader fileInput = new BufferedReader(new java.io.FileReader(filePath));
        String currentLine;
        ArrayList<String> fileStrings = new ArrayList<>();
        try {
            
            while ((currentLine = fileInput.readLine()) != null) {
                fileStrings.add(currentLine);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        StringBuilder sb = new StringBuilder();
        for (String s : fileStrings) {
            {
                sb.append(s);
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
