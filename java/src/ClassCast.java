class Develop{
    public void prt(){
        System.out.println("Develop prt");
    }

    public void test(){
        System.out.println("Develop test");
    }
}

class Feature extends Develop{
    public void view(){
        System.out.println("Feature view");
    }

    @Override
    public void test(){
        System.out.println("Feature test override");
    }
}

class Feature2 extends Feature{

}

public class ClassCast {
    public static void main(String[] args) {
        //up-casting : 직계 존속으로의 형변환
        Develop branch = new Feature();
        branch.prt();
        branch.test();
        //branch는 Feature 인스턴스를 가리키고 있어서 Feature 메서드를 가리키는데, Develop타입으로 만들어졌기 때문에 view는 볼 수 없다.

        //down-casting : 직계 비속으로의 형변환
        //Feature ins2 = new Develop();
        //원칙적으로 down-casting은 불가능하다. Feature 타입이 가리킬수 있어야 하는 항목이 실제 만들어진 Develop 인스턴스에는 없기 때문이다.
        //Feature ins = (Feature)new Develop();
        //ins.prt(); //강제로 down-casting을 할 수는 있지만, 실행하면 ClassCastException 발생
        Feature branch2 = (Feature)branch;
        branch2.prt();
        branch2.test();

        //형변환을 할 수 있는 방법
        Develop d3 = new Feature();
        Feature f3 = (Feature)d3;
        f3.test();

        Feature f4 = new Feature();
        Develop d4 = (Develop)f4;
        d4.test();


        /* instanceof : 형변환이 가능한 지 여부를 묻는 명령어
        a instance of B 는 a(가 가리키는 인스턴스)가 B 타입으로 형변환이 가능한지 여부를 boolean 으로 답한다.
        a의 타입이 아니라 a가 현재 가리키는 실제 만들어진 인스턴스의 타입에 따라 형변환 가능의 여부가 결정.
        */
        System.out.println(branch instanceof Feature);
        Develop d = new Develop();
        Feature f = new Feature();
        System.out.println(d instanceof Feature);

        Develop d1 = new Feature();
        Feature f2 = null;
        System.out.println(d1 instanceof Feature);
        if(d1 instanceof Feature) {
            f2 = (Feature) d1;
            System.out.println(f2);
        } else
            System.out.println("don't work");

        Feature2 ins = new Feature2();
        System.out.println(ins instanceof Develop);


    }
}
