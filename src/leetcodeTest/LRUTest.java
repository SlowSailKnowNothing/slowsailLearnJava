package leetcodeTest;

import java.util.HashMap;
import java.util.Map;

public class LRUTest {
    public static void main(String[] args) {

    }
}

 class LRUCache{
    int capacity;
    Node head;
    Node tail;
    Map<Integer,Node> map;

    class Node{
        int val;
        int key;
        Node next;
        Node pre;

        Node(int val){
            this.val=val;
        }
    }

    LRUCache(int capacity){
        this.capacity=capacity;
        head=new Node(-1);
        tail=new Node(-1);
        head.next=tail;
        tail.pre=head;
        map=new HashMap<Integer,Node>();
    }


//    public int get(int key){
//        if(!map.isEmpty()){
//            Node node=map.get(key);
//            delete(node);
//            insert(node);
//            return node.val;
//        }else return -1;
//    }
//
//    public void put(int key,int val){
//        if(!map.isEmpty()&&map.containsKey(key)){
//            Node node=map.get(key);
//            node.val=val;
//            delete(node);
//            insert(node);
//        }else if(!map.isEmpty()&&map.size()>=capacity){
//            Node last=tail.pre;
//            delete(last);//在这里清除map
//        }
//    }
}
