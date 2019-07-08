package Lesson2.client;

import java.io.*;

public class History {
    private final static String FILE_NAME = "history.txt";
    private final static int MAX_MESSAGES = 10;
    private final static File file = new File(FILE_NAME);

    public static void addHistory(String message) throws FileNotFoundException {
        int numbLine = 0;
        FileOutputStream fos = new FileOutputStream(file, true);
        FileReader fr = new FileReader(file);
        LineNumberReader lnr = new LineNumberReader(fr);
        byte [] buffer = message.getBytes();

        try {
            if (file.exists()) {
                if (numbLine <= MAX_MESSAGES){
                    fos.write(buffer);
                    numbLine++;
                }else {
                    fos.write(buffer);

                }
            }
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String loadHistory () throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        int i;
        if(file.exists()) {
            try {
                while (true) {
                    if (!((i = fis.read()) != -1)) return String.valueOf(((char) i));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
