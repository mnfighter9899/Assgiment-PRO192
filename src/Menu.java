import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Menu {
    public static int int_getChoice(ArrayList<String> options) {
        int response;
        int N = options.size();
        for (int i = 0; i < N; i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please choose an option 1.." + N + ": ");
        response = scanner.nextInt();
        return response;
    }

    public static String ref_getChoice(ArrayList<String> options) {
        int response;
        int N = options.size();
        do {
            response = int_getChoice(options);
        } while (response < 1 || response > N);
        return options.get(response - 1);
    }
}