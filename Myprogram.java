import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Myprogram {

    public static void main(String[] args) {
            HashMap<String, Integer> map = new HashMap<>();
            try {
                BufferedReader file = new BufferedReader(new FileReader("messages"), 16384);
                String line;
                while ((line = file.readLine()) != null) {
                    if (line.contains("Accepted") && line.contains("ssh")) {
                        StringBuilder sb = new StringBuilder();
                        String ip = splitStringChList(line, sb).get(10);
                        if (map.containsKey(ip)) {
                            map.put(ip, map.get(ip) + 1);
                        } else {
                            map.put(ip, 1);
                        }
                    }
                }
                file.close();
                map.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue())
                        .forEachOrdered((x) -> System.out.println(x.getValue() + " " + x.getKey()));
            } catch (FileNotFoundException e) {
                System.out.println(e);
            } catch (IOException e) {
                System.out.println(e);
            }
    }


    public static ArrayList<String> splitStringChList(String line, StringBuilder sb) {
        ArrayList<String> words = new ArrayList<String>();
        words.ensureCapacity(10);
        char[] lineArray = line.toCharArray();
        for (char c : lineArray) {
            if (c == ' ' && sb.length() > 0 ) {
                words.add(sb.toString());
                sb.delete(0, sb.length());
            } else {
                sb.append(c);
            }
        }
        return words;
    }
}


