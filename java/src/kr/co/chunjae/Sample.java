package kr.co.chunjae;

public class Sample {
    public int[] calDouble(int[] arr){
        for(int i=0; i<arr.length; i++){
            arr[i] = arr[i]*2;
        }
        return arr;
    }

    public void prt(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.printf("%d\t",arr[i]);
        }
//        향상된 for문
//        for(int i:arr){
//            System.out.printf("%d\t",i);
//        }
    }
}
