package bools;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Pavitra on 11/8/2015.
 */
public class BooleanMatrix {
    public static void main(String[] args) {

        File file = new File("file.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);

        int x, y;

        x = scanner.nextInt();
        System.out.println(x + " has been read");

        y = scanner.nextInt();
        System.out.println(y + " has been read");


        ArrayList<ArrayList<Boolean>> pixelMap;
        pixelMap = new ArrayList<ArrayList<Boolean>>();
        ArrayList<Boolean> buffer_line = new ArrayList<Boolean>();

        Boolean buffer;


        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                buffer = scanner.nextBoolean();
                System.out.println(buffer + " has been read");
                //buffer_line.add(buffer);
            }
            //pixelMap.add(buffer_line);
            //buffer_line.clear();
        }
    }
}
