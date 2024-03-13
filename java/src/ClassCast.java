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

public class ClassCast {
    public static void main(String[] args) {
        //up-casting
        Develop branch = new Feature();
        branch.prt();
        branch.test();
        //branch는 Feature 인스턴스를 가리키고 있어서 Feature 메서드를 가리키는데, Develop타입으로 만들어졌기 때문에 view는 없다.

        //down-casting
        //Feature ins2 = new Develop();
        //원칙적으로 down-casting은 불가능하다. Feature 타입이 가리킬수 있어야 하는 항목이 실제 만들어진 Develop 인스턴스에는 없기 때문이다.
        //Feature ins = (Feature)new Develop();
        //ins.prt(); //강제로 down-casting을 할 수는 있지만, 실행하면 ClassCastException 발생
        Feature branch2 = (Feature)branch;
        branch2.prt();
        branch2.test();



    }
}
