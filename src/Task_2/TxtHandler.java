package Task_2;

import java.io.*;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TxtHandler {

    public static void read(String fileName, TreeSet d) throws IOException {
        File file = null;
        BufferedReader br = null;
        try {
            file = new File(fileName);
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line = null;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\s+|[,:;?!}{\\[\\]><\\\\\\/\\|#№$%^&*=_ '\"]");
                d.addAll(func(words));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    public static void write(TreeSet<String> dictionary) throws IOException {
        File file = null;
        BufferedWriter bw = null;
        try {
            file = new File("src/Task_2/dictionary.txt");
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            String firstLater = dictionary.first().substring(0, 1);

            for (String s : dictionary) {
                if (s.substring(0, 1).compareTo(firstLater) != 0) {
                    bw.newLine();
                    firstLater = s.substring(0, 1);
                }
                bw.write(s);
                bw.newLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                bw.close();
            }
        }
    }

    private static TreeSet<String> func(String[] temp) {
        Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$");
        Pattern phoneNumberPattern = Pattern.compile("\\+\\d{3}\\(\\d{2}\\)\\d{3}-\\d{2}-\\d{2}");
        Pattern wordPattern = Pattern.compile("[a-zA-Zа-яА-Я]+");

        TreeSet<String> res = new TreeSet<>();
        for (String s : temp) {
            Matcher emailMatcher = emailPattern.matcher(s);
            Matcher phoneNumberMatcher = phoneNumberPattern.matcher(s);
            Matcher wordMatcher = wordPattern.matcher(s);

            if (emailMatcher.matches() ||
                    phoneNumberMatcher.matches() ||
                    wordMatcher.matches()) {
                res.add(s.toLowerCase());
            }
        }
        return res;
    }
}
