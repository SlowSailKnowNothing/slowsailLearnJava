package learnGeneric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class genericTest01 {
    public static void main(String[] args) {
        int ans=testGeneric1(3);
        List<Integer> list=Arrays.asList(1,2,3,4,5);
        List<String>  strList=Arrays.asList("1","2","3","4");
        testGeneric5(list, strList);

    }

    public static <E> E testGeneric1(E num){
        System.out.println(num);
        return num;
    }

 /*   public static void testGeneric2(? num){ 运行无法通过，显示出区别了
        System.out.println(num);
    }*/

    public static void testGeneric2(List<?> list){
        System.out.println(list.get(list.size()-1));
    }

    public static <E,V> void testGeneric3(List<E> list1,List<V> list2){
        for(E item:list1){
            System.out.println(item);
        }

        for(V item:list2){
            System.out.println(item);
        }
    }

    public static void testGeneric4(List<?> list1,List<?> list2){
        System.out.println(list1.get(list1.size()-1));
        System.out.println(list2.get(list2.size()-1));
    }

    public static <E extends Integer,V> void testGeneric5(List<E> list1,List<V> list2){
        for(E item:list1){
            System.out.println(item);
        }

        for(V item:list2){
            System.out.println(item);
        }
    }
}

