package leetcodeTest;

import java.util.HashMap;
import java.util.Map;

public class leetcodeLFU {
    static class LFUCache {
        class Node{
            int val;
            int key;
            int cnt;
            Node pre;
            Node next;
            public Node(int key,int val){
                this.val=val;
                this.cnt=1;
                this.key=key;
            }
        }

        class Dlist{
            Node head;
            Node tail;
            int len;
            public Dlist(){
                head=new Node(-1,0);
                tail=new Node(-1,0);
                head.next=tail;
                tail.pre=head;
                len=0;
            }

            public void remove(Node node){
                len=len-1;
                //nMap.remove(node.key);
                Node pre=node.pre;
                Node next=node.next;
                pre.next=next;
                next.pre=pre;
            }

            public void add(Node node){
                node.next=head.next;
                head.next.pre=node;
                node.pre=head;
                head.next=node;
                len=len+1;
            }
        }

        int capacity;
        int size;

        Map<Integer,Node> nMap;
        Map<Integer,Dlist> fMap;


        public LFUCache(int capacity) {
            this.capacity=capacity;
            size=0;
            nMap=new HashMap<>();
            fMap=new HashMap<>();
            fMap.put(1,new Dlist());
        }

        public int get(int key) {
            if(!nMap.containsKey(key))return -1;
            else{
                Node node=nMap.get(key);
                int preF=node.cnt;
                node.cnt++;//2
                Dlist preList=fMap.get(preF);
               // preList.remove(node);//注意长度


                Dlist curList=fMap.getOrDefault(node.cnt,new Dlist());
                curList.add(node);//注意长度

                fMap.put(node.cnt,curList);

                return node.val;
            }
        }

        public void put(int key, int value) {
            if(nMap.containsKey(key)){
                Node node=nMap.get(key);
                node.val=value;
                //node.cnt++;
                get(node.key);
            }else{
                size++;
                Dlist list1=fMap.get(1);
                Node node=new Node(key,value);
                list1.add(node);
                nMap.put(key,node);
                if(size>capacity){
                    if(list1.len>1){
                        list1.remove(list1.tail.pre);//注意也要从nMap中删除，长度要记得变化
                        nMap.remove(node.key);
                        size--;
                        return;
                    }
                    for(int i=2;i<=fMap.size();i++){
                        Dlist list=fMap.get(i);
                        if(list.len>=1){
                            list.remove(list.tail.pre);
                            nMap.remove(node.key);
                            break;
                        }
                    }
                    size--;
                }

            }
        }
    }

    /**
     * Your LFUCache object will be instantiated and called as such:
     * LFUCache obj = new LFUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    public static void main(String[] args) {
        LFUCache testCache = new LFUCache(2);
        testCache.put(1,1);
        testCache.put(2,2);
       // testCache.get(1);
        // get1=testCache.get(1);
       testCache.put(2,1);
       testCache.put(4,4);
       //testCache.get(2);

    }
}
