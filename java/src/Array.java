public class Array {
    public static void main(String[] args) {
        /*
         자바에서 배열이란 : 같은 타입의 변수를 여러개 묶은 것
         int[] score_array = new int[N];  int 타입의 변수 N개를 묶은 배열
                 stack        heap
         new 로 시작되는 것들은 jvm heap 메모리에 만들어진다.
         (stack은 지역을 벗어나면 없어지지만 heap은 없어지지 않음)
         score_array는 이 heap 메모리에 저장된 배열의 메모리 주소를 가리키는 reference 변수이다.
        */

        //배열의 선언 (초기값이 0을 나타내는 디폴트 값으로 정해진다)
        String[] arr = new String[5]; //초기 할당값 null
        int[] age = new int[5]; //초기 할당값 0
        float[] avg = new float[3]; //초기 할당값 0.0
        int[] score; score = new int[4];
        boolean[] check = new boolean[3]; //초기 할당값 false
        score[0] = 100;
        score[1] = 200;
        score[2] = 300;
        //score[4] = 400; ArrayIndexOutOfBoundsException, 배열의 길이를 벗어나는 인덱스에 추가 불가
        for(int i=0; i<score.length; i++){
            System.out.print(score[i]+" ");
        }

        //배열의 선언 및 초기값 할당을 한번에 하기
        System.out.println();
        int[] arr2 = {2,34,5,17};
        //int[] arr3; arr3 = new int[]{200,300,400}; 변수만 선언하고 나중에 초기값 할당할 경우
        for(int i =0; i<arr2.length; i++){
            System.out.print(arr2[i]+" ");
        }

        //오름차순 정렬
        System.out.println();
        int temp = 0;
        for(int i=0; i<arr2.length-1; i++){
            for(int j=i+1; j<arr2.length; j++){
                if(arr2[j]<arr2[i]) {
                    temp = arr2[i];
                    arr2[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
        }
        for(int i=0; i<arr2.length; i++){
            System.out.print(arr2[i]+" ");
        }

        int[] arr3 = {100,200,300};
        //일반 for문
        for(int i=0; i<arr.length; i++){
            System.out.printf("arr[%d]=%d\n",i,arr3[i]);
        }
        //향상된 for문  for(타입 매개변수:array)
        for(int a:arr3)
            System.out.println(a);



     }
}
