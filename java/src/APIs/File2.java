package APIs;

import java.io.FileReader;
import java.io.IOException;

public class File2 {
    public static void main(String[] args) {
        //FileReader는 AutoCloseable을 상속하고 있다.
        try(FileReader fr = new FileReader("./src/APIs/hello.txt")){
//            while(true){
//                int data = fr.read();
//                if(data == -1)
//                    break;
//                System.out.print((char)data);
//            }
            int data;
            while((data = fr.read()) != -1){
                char ch = (char) data;
                System.out.print(ch);
            }
        } catch (IOException e){
            System.out.println(e);
        }
    }
}
