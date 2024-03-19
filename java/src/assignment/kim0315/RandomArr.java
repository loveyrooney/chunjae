package assignment.kim0315;
class RandomUtil{
    private int[] arr = new int[5];

    public int[] getArr() {
        return arr;
    }

    public static int randomNum(){
        return (int)(Math.random()*10);
    }
    public boolean inspectionArr(int i, int input){
        for(int j=0; j<i; j++){
            if(arr[j]==input)
                return false;
        }
        return true;
    }
    public void prtArr(){
        for(int j=0; j< arr.length; j++){
            System.out.print(arr[j]+"\t");
        }
        System.out.println();
    }
}
public class RandomArr {
    public static void main(String[] args) {
        RandomUtil util = new RandomUtil();
        int[] arr = util.getArr();
        int input;
        for(int i=0; i< arr.length; i++){
            while(true){
                input = RandomUtil.randomNum();
                boolean result = util.inspectionArr(i,input);
                if(result) {
                    arr[i] = input;
                    break;
                }
            }
        }
        util.prtArr();

        //lecture
        int[] data = new int[5];
        data[0] = (int)(Math.random()*10);
        for(int i=1; i<data.length; i++){
            data[i] = (int)(Math.random()*10);
            for(int j=0; j<i; j++){
                if(data[j]==data[i]){
                    i--;
                    break;
                }
            }
        }
        for(int i:data){
            System.out.print(i+"\t");
        }
    }
}
