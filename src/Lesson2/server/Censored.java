package Lesson2.server;

import java.io.*;
import java.util.ArrayList;

public class Censored {
    private final static String FILE_NAME = "censored.txt";
    private final static File file = new File(FILE_NAME);

    public static boolean censored(String message){
        try {
            ArrayList<String> censored = new ArrayList<>();
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String tmp;
            while ((tmp = br.readLine()) != null) censored.add(tmp);

            for(int i = 0; i < censored.size(); i++){
                if(censored.get(i).equalsIgnoreCase(message)) {
                    return true;
                }
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
