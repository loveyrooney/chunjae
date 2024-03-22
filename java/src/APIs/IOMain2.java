package APIs;

import java.io.*;

class Person1 implements Serializable{
    private String name;
    private int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
public class IOMain2 {
    public static void main(String[] args) {
        /* 보조 스트림
        DataInput(Output)Stream : data 의 primitive 타입을 가지고 입출력.
        ObjectInput(Output)Stream :
        직렬화(serialization) - 객체를 스트림화 하는 것. Object 를 byte 단위로 쪼개기
        역직렬화(deserialization) - 스트림을 객체화 하는 것. byte 단위로 쪼갠 것을 다시 Object 로 만들기
        */

        //FileOutputStream
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("./src/APIs/DataStream.txt"));
            dos.writeUTF("안녕하세요");
            dos.writeInt(20);
            dos.writeBoolean(true);
            dos.writeDouble(10.5);
            System.out.println("dos write end");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if(dos != null) try {dos.close();} catch (IOException e) {}
        }

        //FileInputStream
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("./src/APIs/DataStream.txt"));
            /* 입력된 타입의 순서와 다르게 read 하면 제대로 출력되지 않는다.
            입력될 때 그 타입의 공간만큼 공간이 배정되기 때문에, read 할때 타입의 순서가 달라지면 공간이 어긋나게 된다.
            */
            String data = dis.readUTF();
            int data2 = dis.readInt();
            boolean data3 = dis.readBoolean();
            double data4 = dis.readDouble();
            System.out.println(data);
            System.out.println(data2+5);
            System.out.println(!data3);
            System.out.println(data4+3.2);
        } catch (IOException e){
            System.out.println(e.getMessage());
        } finally {
            if(dis != null) try {dis.close();} catch (IOException e) {}
        }

        //ObjectOutputStream
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("./src/APIs/ObjectStream.txt"));
            //이 때 들어가는 객체는 Serializable interface 를 상속받고 있어야 한다.
            oos.writeObject(new Person1("hong",20));
            //객체 자체를 스트림화해서 저장한 게 아니라 객체 필드의 값만 byte 로 바꿔서 저장하는 원리.
            System.out.println("oos write end");
        } catch (IOException e){
            System.out.println(e.getMessage());
        } finally {
            if(oos != null) try {oos.close();} catch (IOException e) {}
        }

        //ObjectInputStream
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/APIs/ObjectStream.txt"))){
            Object o = ois.readObject();
            if(o instanceof Person1){
                Person1 data = (Person1) o;
                System.out.println(data.getName()+","+data.getAge());
            } else
                System.out.println("read failed");
        } catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }


    }
}
