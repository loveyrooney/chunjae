package APIs;

import java.io.*;
import java.util.StringTokenizer;

public class FileExam {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder info = new StringBuilder();

        //파일 작성
        try (BufferedWriter fw = new BufferedWriter(new FileWriter("./src/APIs/info.txt",true))){
            while(true){
                info.replace(0,info.capacity(),"");
                System.out.println("이름");
                info.append(input.readLine());
                System.out.println("나이");
                info.append(", ")
                    .append(input.readLine())
                    .append("\n");
                info.trimToSize();
                fw.write(info.toString());
                System.out.println("계속 입력?");
                if(".".equals(input.readLine())) { //'.'==input.read() 로 하면 이름\n나이\n 이 한 덩어리이다.
                    break;
                }
            }
        } catch (IOException e){
            System.out.println(e);
        }

        //파일 출력
        try (BufferedReader fr = new BufferedReader(new FileReader("./src/APIs/info.txt"))){
            String data;
            //(data = fr.read()) != -1 로 하면 해당 char를 검사 후 다음 char로 넘어간다.
            while((data = fr.readLine()) != null){
                //문자열 추출 1.spilt()
                String[] result = data.split(",");
                for(String i:result)
                    System.out.print(i);
                System.out.println();
                //문자열 추출 2.StringTokenizer
//                StringTokenizer token = new StringTokenizer(data,",");
//                while(token.hasMoreTokens()){
//                    String result = token.nextToken();
//                    System.out.print(result);
//                }
//                System.out.println();
            }

        } catch (IOException e){
            System.out.println(e);
        }



    }
}
