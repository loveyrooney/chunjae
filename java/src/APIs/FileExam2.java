package APIs;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StudentDTO implements Comparable{
    private String name;
    private int kor;
    private int eng;
    private int math;
    private int sum;
    private float avg;

    public String getName() {
        return name;
    }

    public int getKor() {
        return kor;
    }

    public int getEng() {
        return eng;
    }

    public int getMath() {
        return math;
    }

    public int getSum() {
        return sum;
    }

    public float getAvg() {
        return avg;
    }

    public StudentDTO(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        addSum(kor, eng, math);
        addAvg(sum);
    }

    private void addSum(int kor, int eng, int math){
        sum = kor+eng+math;
    }
    private void addAvg(int sum){
        avg = sum/3f;
    }

    @Override
    public int compareTo(Object o) {
        int result;
        if(o instanceof StudentDTO){
            StudentDTO s = (StudentDTO) o;
            result = -(sum-s.sum); //받아온 s 객체 클래스가 해당 클래스가 됐으므로 getter 안써도 된다.
        } else
            throw new ClassCastException();
        return result;
    }
}

class Students {
    private final ArrayList<StudentDTO> list = new ArrayList<>();

    public ArrayList<StudentDTO> getList() {
        return list;
    }
}
public class FileExam2 {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String name;
        int kor, eng, math;
        Students students = new Students();
        List<StudentDTO> list = students.getList();

        //파일 작성
        try(BufferedWriter fw = new BufferedWriter(new FileWriter("./src/APIs/scores.txt"))){
            while(true){
                System.out.println("이름");
                name = input.readLine();
                System.out.println("국어");
                kor = Integer.parseInt(input.readLine()); //공백제거 : .strip()
                System.out.println("영어");
                eng = Integer.parseInt(input.readLine());
                System.out.println("수학");
                math = Integer.parseInt(input.readLine());
                fw.write(name+","+","+kor+","+eng+","+math+"\n");
                list.add(new StudentDTO(name,kor,eng,math));
                System.out.println("계속 입력?");
                if(!"y".equals(input.readLine()))
                    break;
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        //정렬 및 출력
        Collections.sort(list);
        System.out.println("이름\t 국어\t 영어\t 수학\t 총점\t 평균");
        for(StudentDTO i:list)
            System.out.printf("%s\t %d\t %d\t %d\t %d\t %.1f\n"
            ,i.getName(),i.getKor(),i.getEng(),i.getMath(),i.getSum(),i.getAvg());





    }
}
