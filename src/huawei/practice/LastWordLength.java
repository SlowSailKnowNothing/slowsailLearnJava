package huawei.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LastWordLength {
    public static void main(String[] args) {
        sortRandomNum();
        }

    public static void sortRandomNum(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            Map<Integer,Integer> map=new TreeMap<Integer,Integer>((a,b)->{
              return a-b;
            });
            for(int i=0;i<n;i++){
                int m=scanner.nextInt();
                map.put(m,1);
            }
            for(Integer key:map.keySet()){
                System.out.println(key);
            }
        }

    }
    }



