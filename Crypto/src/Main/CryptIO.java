package Main;

import java.io.IOException;
import java.util.ArrayList;

public class CryptIO {
    
    public static boolean CryptoIOTest(String filePath, String aFileName) throws IOException {
        String originalText = FileReader.loadDataFromFile(filePath);
        String codedText = ROT13.appendCipher('a', 'b', originalText, true);
        ArrayList<String> lines = FileWriter.stringToStringList(codedText);
        FileWriter.writeToFile(lines, aFileName);
        String reReadText = FileReader.loadDataFromFile(aFileName);
        String unCodedText = ROT13.appendCipher('a', 'b', reReadText, false);
        //Still prints out one extra new line
        System.out.println(originalText.equals(unCodedText));
        return originalText.equals(unCodedText);
    }
}
