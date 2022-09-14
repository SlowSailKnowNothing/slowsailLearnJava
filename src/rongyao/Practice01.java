package rongyao;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Practice01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            int n=scanner.nextInt();

            Map<Integer,Integer> map=new TreeMap<Integer,Integer>();

            for(int i=0; i<n; i++){
                map.put(scanner.nextInt(),1);
            }
            for(Integer key : map.keySet()){
                System.out.println(key);
            }
        }


    }
}
