package rongyao;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()) {
            String line1=sc.nextLine();
            String line2=sc.nextLine();
            int count=0;
            String[] words1=line1.split(" ");
            String[] words2=line2.split(" ");
            if(words1.length==words2.length){
                for(int i=0;i<words1.length;i++){
                    if(words1[i].equals(words2[i]))count++;
                }
                System.out.println(count);
            }else{
                System.out.println(0);
            }
        }
    }
}
