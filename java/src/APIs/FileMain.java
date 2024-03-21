package APIs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileMain {
    public static void main(String[] args) {
        File f1 = new File("d:\\");
        String[] lists = f1.list();
        for(String list: lists)
            System.out.println(list);

        File f2 = new File("d:\\fileTest");
        boolean result = f2.mkdir();
        if(result)
            System.out.println("directory created");
        else
            System.out.println("directory doesn't created");
        File f3 = new File(f2,"file.txt");
        try {
            result = f3.createNewFile();
            if(result)
                System.out.println("file created");
            else
                System.out.println("file doesn't created");
        } catch (IOException e) {
            System.out.println(e);
        }

        result = f3.exists();
        if(result)
            System.out.println("file found");
        else
            System.out.println("file not found");

        result = f3.delete();
        if(result)
            System.out.println("file delete");
        else
            System.out.println("file doesn't delete");

        f2.delete();
    }
}
