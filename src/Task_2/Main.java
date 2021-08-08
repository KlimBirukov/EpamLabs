package Task_2;

import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String... args) throws IOException {
        Scanner in = new Scanner(System.in);
        TreeSet<String> dictionary = new TreeSet<>();

        System.out.println("Введите полный путь к file.txt");
        String fileName = in.next();

        if(TxtHandler.check(fileName)) {
            TxtHandler.read(fileName, dictionary);
            TxtHandler.write(dictionary);
        }
    }
}
