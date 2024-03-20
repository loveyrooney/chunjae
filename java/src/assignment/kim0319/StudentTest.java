package assignment.kim0319;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Hashtable;

class StudentDTO{
    private String hak_no;
    private String name;
    private int age;

    public StudentDTO(String hak_no, String name, int age) {
        this.hak_no = hak_no;
        this.name = name;
        this.age = age;
    }

    public String getHak_no() {
        return hak_no;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "hak_no: " + hak_no + '\n' +
                "name: " + name + '\n' +
                "age: " + age;
    }
}

class UserTable{
    private HashMap<String,StudentDTO> hm = new HashMap<>();

    public HashMap<String, StudentDTO> getHm() {
        return hm;
    }
    public boolean isKey(String hak_no){
        boolean result = false;
        if(hm.containsKey(hak_no))
            result = true;
        return result;
    }
    public void addKey(String hak_no, String name, int age){
        StudentDTO dto = new StudentDTO(hak_no,name,age);
        hm.put(hak_no,dto);
        System.out.println("입력완료");
    }

    public void updateAge(String hak_no, int age){
        StudentDTO target = hm.get(hak_no);
        target.setAge(age);
        System.out.println("수정완료");
    }

    public void removeKey(String hak_no){
        hm.remove(hm.get(hak_no));
        System.out.println("삭제완료");
    }
}

//lecture
class UserTable2{
    private Hashtable<String,StudentDTO> ht = new Hashtable<>();

    public boolean isCheckHakNo(String hak_no){
        return ht.containsKey(hak_no);
    }

    public boolean insertStudent(String hak_no, String name, int age){
        //put은 key값에 대응하는 이전에 있던 밸류를 리턴한다.
        StudentDTO dto = ht.put(hak_no,new StudentDTO(hak_no,name,age));
        boolean result = false;
        if(dto==null)
            result = true;
        return result;
    }

    public boolean modifyStudent(String hak_no,int age){
        StudentDTO dto = ht.get(hak_no);
        boolean result = false;
        if(dto != null){
            dto.setAge(age);
            result = true;
        }
        return result;
    }

    public boolean removeStudent(String hak_no){
        //remove는 삭제되는 해당 객체의 밸류를 리턴한다.
        StudentDTO dto = ht.remove(hak_no);
        boolean result = false;
        if(dto != null)
            result = true;
        return result;
    }

}
public class StudentTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserTable table = new UserTable();
        HashMap<String,StudentDTO> list = table.getHm();
        String hak_no;
        int age;
        while(true){
            System.out.println("1.입력 2.수정 3.삭제 4.조회 5.전체보기 6.종료");
            String input = sc.nextLine();
            if("6".equals(input)){
                System.out.println("6.종료");
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if("5".equals(input)){
                while(true) {
                    System.out.println("5.전체보기");
                    Iterator<String> keys = list.keySet().iterator();
                    while (keys.hasNext()) {
                        StudentDTO dto = list.get(keys.next());
                        System.out.printf("%s  %s  %d\n",dto.getHak_no(),dto.getName(),dto.getAge());
                    }
                    System.out.println("계속 보시겠습니까?");
                    if (!"y".equals(sc.nextLine()))
                        break;
                }
            } else if("1".equals(input)){
                while(true){
                    System.out.println("1.입력");
                    System.out.println("학번을 입력하세요");
                    hak_no = sc.nextLine();
                    if(!table.isKey(hak_no)){
                        System.out.println("이름을 입력하세요");
                        String name = sc.nextLine();
                        System.out.println("나이를 입력하세요");
                        age = Integer.parseInt(sc.nextLine());
                        table.addKey(hak_no,name,age);
                    } else
                        System.out.println("기존 학번이 있습니다.");
                    System.out.println("계속 입력하시겠습니까?");
                    if(!"y".equals(sc.nextLine()))
                        break;
                }
            } else if("4".equals(input)){
                while(true){
                    System.out.println("4.조회");
                    System.out.println("학번을 입력하세요");
                    hak_no = sc.nextLine();
                    if(table.isKey(hak_no)){
                        System.out.println(list.get(hak_no));
                    } else
                        System.out.println("학번이 없습니다");
                    System.out.println("계속 조회하시겠습니까?");
                    if(!"y".equals(sc.nextLine()))
                        break;
                }
            } else if("2".equals(input)){
                while(true){
                    System.out.println("2.수정");
                    System.out.println("학번을 입력하세요");
                    hak_no = sc.nextLine();
                    if(table.isKey(hak_no)){
                        System.out.println("수정할 나이");
                        age = Integer.parseInt(sc.nextLine());
                        table.updateAge(hak_no,age);
                    } else
                        System.out.println("학번이 없습니다");
                    System.out.println("계속 수정하시겠습니까?");
                    if(!"y".equals(sc.nextLine()))
                        break;
                }
            } else {
                while(true){
                    System.out.println("3.삭제");
                    System.out.println("학번을 입력하세요");
                    hak_no = sc.nextLine();
                    if(table.isKey(hak_no)){
                        table.removeKey(hak_no);
                    } else
                        System.out.println("학번이 없습니다");
                    System.out.println("계속 삭제하시겠습니까?");
                    if(!"y".equals(sc.nextLine()))
                        break;
                }
            }
        }


    }
}
