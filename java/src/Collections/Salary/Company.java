package Collections.Salary;

import java.util.HashMap;
import java.util.Iterator;

public class Company {
    public static void main(String[] args) {
        HashMap<Integer,Employee> map = new HashMap<>();
        map.put(1111,new Secretary("hong",1,"secretary",800));
        map.put(2222,new Sales("kim",2,"sales",1200));

        System.out.println("name  department  salary");
        for(int i:map.keySet()){
            Employee e = map.get(i);
            System.out.printf("%s  %s  %d\n",e.getName(),e.getDepartment(),e.getSalary());
        }

        System.out.println("인센티브 100 지급");
        Iterator<Integer> ita = map.keySet().iterator();
        while(ita.hasNext()){
            Employee e = map.get(ita.next());
            //여기서는 형변환을 해야 하는데, Employee에는 incentive 메서드가 없기 때문.
            if("secretary".equals(e.getDepartment())){ //e instanceof Secretary
                Secretary s = (Secretary) e;
                s.incentive(100);
                //((Secretary) e).incentive(100);
            } else if("sales".equals(e.getDepartment())){ //e instanceof Sales
                Sales s = (Sales) e;
                s.incentive(100);
                //((Sales) e).incentive(100);
            }
        }

        System.out.println("------------------------------------------");
        System.out.println("name  department  salary  tax");
        for(int i:map.keySet()){
            Employee e = map.get(i);
            System.out.printf("%s  %s  %d  %.1f\n",e.getName(),e.getDepartment(),e.getSalary(),e.tax());
            //여기서는 형변환 할 필요가 없다. override 된 것으로 나오기 때문.
        }

    }
}
