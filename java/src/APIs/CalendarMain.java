package APIs;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarMain {
    public static void main(String[] args) {
        /* Date 클래스는 deprecated 된 것들이 많아서 쓰지 않는 것이 좋다.
        Calendar 클래스는 추상클래스고 protected 생성자를 쓰기 때문에 상속받고 추상 메서드를 모두 오버라이딩 해야함.
        그래서 Calendar rightNow = Calendar.getInstance(); 와 같이 클래스 객체를 받아와서 쓴다.
        윤달에 대한 계산이 없다. 이것을 보완한 것이 GregorianCalendar 클래스이다.
        */
        Calendar calendar = Calendar.getInstance();
        int d1 = calendar.get(Calendar.DATE);
        int d2 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.printf("%d, %d\n",d1,d2);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println(calendar.get(Calendar.MONTH)+1); //0부터 계산하기 때문에 +1씩 해줘야 함
        System.out.println(calendar.getTime());
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        System.out.println(gregorianCalendar.get(Calendar.YEAR));

        //SimpleDateFormat 클래스 : 날짜 출력 포맷
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d D hh:m:s");
        String df = sdf.format(new Date());
        System.out.println(df);

        //LocalDate 클래스 : 날짜와 시간 조작이 가능 (LocalDateTime 클래스는 날짜와 시간 비교 가능)
        LocalDate ld = LocalDate.now();
        System.out.println(ld);

    }
}
