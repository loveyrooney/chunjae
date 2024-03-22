package APIs;

import java.io.*;
import java.util.Scanner;

public class IOMain {
    public static void main(String[] args) throws IOException {
        /* 입출력의 기준은 jvm 입장에서 생각한다. file 작성은 출력, file 받아오는 것은 입력.
        스트림이란? 데이터가 흐르는 단방향
        Reader : 문자 단위, 입력   InputStream : 바이트 단위, 입력
        Writer : 문자 단위, 출력   OutputStream : 바이트 단위, 출력
        기반 스트림 : 표준 입출력 (System in/out), 파일(File~), 네트워크
        보조 스트림 : 기반 스트림을 꾸며주는 기능을 가진 스트림 (decoration pattern).
        Buffered~ (성능향상), Input(Output)StreamReader (문자관련)
        */

        //InputStreamReader : 바이트 단위의 InputStream 을 문자 단위로 direct 입력
        InputStreamReader isr = new InputStreamReader(System.in); //in은 InputStream 타입이다.
        while(true){
            System.out.println("내용을 입력하세요");
            char ch = (char) isr.read();
            if(ch=='.') break;
            System.out.print(ch);
        }

        //BufferedReader : 매개변수를 Buffer에 한 문자씩 저장, Buffer가 꽉 차거나 다음 줄로 넘어가면 입력
        BufferedReader br = new BufferedReader(isr); //buffer(reader(inputStream))) 세번을 감싼 것.
        while(true){
            System.out.println("내용을 입력하세요");
            String str = br.readLine(); //한 줄씩 읽어들인다.
            if("bye".equals(str))
                break;
            System.out.println(str);
        }

        System.err.println("error");

        //OutputStream
        PrintStream ps = System.out;
        ps.append("hello")   //append 에는 String, char, CharSequence
                .append("this is")
                .append('a')
                .append(new StringBuilder("append"));
        System.out.println();
        ps.print("hello");   //print 에는 거의 다
        ps.print("this is");
        ps.print(true);
        ps.print("print");
        ps.print(1.0);

        //FileWriter : File 을 문자 단위로 작성.
        System.out.println();
        FileWriter fw = null;
        try {
            fw = new FileWriter("./cats.txt");
            fw.write("hello\n");
            fw.write("nice to meet you\n");
            System.out.println("file end");
        } catch(IOException e){
            System.out.println(e);
        } finally {
            if(fw != null) try {fw.close();} catch (IOException e){}
            //try 과정 어디에서 exception 발생해도 close 는 이루어져야 한다.
        }

        //BufferedWriter : 매개변수를 Buffer에 한 문자씩 저장, Buffer가 꽉 차거나 다음 줄로 넘어가면 출력
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter("./hello.txt")); // buffer(fileWriter)
            bw.write("hello");
            bw.write("bufferWriter");
            bw.newLine();
            bw.write("bye");
            System.out.println("file end");
        } catch (IOException e){
            System.out.println(e);
        } finally {
            if(bw !=null) try {bw.close();} catch (IOException e){}
        }

        //FileReader : AutoCloseable 을 상속하고 있다.
        try(FileReader fr = new FileReader("./src/APIs/hello.txt")){
//            while(true){
//                int data = fr.read();
//                if(data == -1)
//                    break;
//                System.out.print((char)data);
//            }
            int data;
            while((data = fr.read()) != -1){ //위의 코드 줄여서 표현할 수 있음.
                char ch = (char) data;
                System.out.print(ch);
            }
        } catch (IOException e){
            System.out.println(e);
        }


        //Scanner
        Scanner sc = new Scanner(System.in); //생성자 안에는 InputStream, File 등이 들어간다)
//        System.out.println("write name");
//        String name = sc.nextLine();
//        System.out.println("write score");
//        float score = sc.nextFloat();
//        System.out.println("write age");
//        int age = sc.nextInt();
//        System.out.printf("%s %.1f %d %.1f\n",name,score,age,score+10);

        for(int i=0; i<3; i++){
            System.out.println("name");
            String name = sc.nextLine();
            System.out.println(name);
            System.out.println("age");
            int age = sc.nextInt();
            sc.nextLine(); //next타입() 을 쓸때는 nextline 을 달아줘야 한다.
            System.out.println(age);
        }
    }
}
