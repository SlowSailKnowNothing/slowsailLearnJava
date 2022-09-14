package onlineText;

import java.util.Arrays;
import java.util.stream.Collectors;

public class leetcodeTest {
    public static void main(String[] args) {

    }

//    public static long smallestNumber(long num) {
//        if(num==0)return 0;
//        boolean negative=false;
//        if(num<0){
//            negative=true;
//        }
//
//        String numStr=num+"";
//        StringBuilder sb=new StringBuilder();
//        if(negative){
//            numStr=numStr.substring(1,numStr.length());
//            char[] numArray=numStr.toCharArray();
//            Arrays.stream(numArray.split(""))
//                    .sorted((o1, o2) -> {
//                                Integer aPos = poses.get(o1);
//                                Integer bPos = poses.get(o2);
//                                if (aPos == null || bPos == null)
//                                    return 0;
//                                return Integer.compare(aPos, bPos);
//                            }
//                    )
//                    .collect(Collectors.joining());
//
//
//            sb.append('-');
//            for(char ch:numArray){
//                sb.append(ch);
//            }
//
//        }else{
//            char[] numArray=numStr.toCharArray();
//            Arrays.sort(numArray);
//
//            boolean swapFlag=false;
//            int index=0;
//
//            for(int i=0;i<numArray.length;i++){
//                char ch=numArray[i];
//                if(ch!='0'&&swapFlag==false){
//                    index=i;
//                }
//            }
//
//            if(numArray[0]=='0'){
//                numArray[0]=numArray[index];
//                numArray[index]='0';
//            }
//
//            for(char ch:numArray){
//                sb.append(ch);
//            }
//        }
//        return sb.toString();
//    }
}
