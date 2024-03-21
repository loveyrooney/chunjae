package APIs;

import java.io.Closeable;
import java.io.IOException;

class AutoClose implements Closeable, AutoCloseable {
    public AutoClose() throws IOException {
        System.out.println("constructor");
    }

    public void prt(){
        System.out.println("prt");
    }

    @Override  //Closeable method
    public void close() throws IOException {
        System.out.println("close");
    }
}

public class AutoCloseMain {
    public static void main(String[] args) {
//        AutoClose c = null;
//        try{
//            c= new AutoClose();
//            c.prt();
//        } catch (IOException e){
//            System.out.println(e);
//        } finally {
//            if(c !=null) try{ c.close();} catch (IOException e){}
//        }

        //try with resources : try 에 괄호를 써서 객체를 생성
        //기존에 finally 에서 써야 하는 close 메서드를 자동 호출 (AutoCloseable 상속받은 경우)
        try (AutoClose c2 = new AutoClose()) {
            c2.prt();
        } catch (IOException e){
            System.out.println(e);
        }


    }
}
