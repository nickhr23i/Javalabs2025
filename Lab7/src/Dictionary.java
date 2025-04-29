import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dictionary {
    private final List<String> words = new ArrayList<>();
    public Dictionary(String path) {
        try (var in = new BufferedReader(new FileReader(path))) {
            String line;
            while(in.ready()) {
                line = in.readLine();
                words.add(line);
            }
        } catch (IOException ex){
            Logger.getLogger(Dictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean isWord(String word) {
        for(String w : words) {
            if(w.equals(word)) return true;
        }
        return false;
    }
}
