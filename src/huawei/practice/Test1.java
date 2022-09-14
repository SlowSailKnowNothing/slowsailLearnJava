package huawei.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String sentenceIn=sc.nextLine();
            String wordsIn=sc.nextLine();
            //句子中有标点符号，注意双引号是有空格的，所以可以用空格分割 然后就可以利用双引号跳过
            //words先记录单词和index的对应表
            String sentence = sentenceIn.toLowerCase();
            String words = wordsIn.toLowerCase();
            String[] wordsList=words.split(" ");
            Map<String,Integer> map=new HashMap<String,Integer>();
            for(int i=0;i<wordsList.length;i++){
                map.put(wordsList[i],i);
            }
            String[] sentencList=sentence.split(" ");
            String[] originList=sentenceIn.split(" ");
            boolean isIn=false;
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<sentencList.length;i++){
                String str=sentencList[i];
                if(isIn){
                    if(str.equals("\""))isIn=false;
                    sb.append(originList[i]);
                    sb.append(" ");
                }else{
                    if(str.equals("\"")){
                        isIn=true;
                        sb.append(str);
                        sb.append(" ");
                    }
                    else{
                        int index=map.getOrDefault(str,-1);
                        sb.append(index==-1?originList[i]:index+"");
                        sb.append(" ");
                    }
                }
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }
    }
}


// Hello World
// Hello World