package bilibili;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()) {
            int n=sc.nextInt();
            sc.nextLine();
            for(int k=0;k<n;k++){
                String line=sc.nextLine();
                StringBuilder sb=new StringBuilder();
                boolean isBegin=false;
                boolean isContinue=false;
                for(int i=0;i<line.length();i++){
                    if(isContinue)break;
                    char input=line.charAt(i);
                    if(isBegin){
                        if(input>='0'&&input<='9'){
                            sb.append(input);
                        }else{
                            if(isContinue(sb))isContinue=true;
                            isBegin=false;
                            sb.setLength(0);
                        }
                    }else{
                        if(input>='0'&&input<='9'){
                            sb.append(input);
                            isBegin=true;
                        }
                    }
                }
                if(sb.length()>0&&isContinue(sb))isContinue=true;
                System.out.println(isContinue==true?"yes":"no");
            }
        }
    }

    public static boolean isContinue(StringBuilder sb){
        if(sb.length()<3)return false;
        boolean isUp=false;
        boolean isDown=false;
        if(sb.charAt(0)+1==sb.charAt(1))isUp=true;
        else if(sb.charAt(0)==sb.charAt(1)+1)isDown=true;
        else return false;

        for(int i=1;i<sb.length();i++){
            if(isUp&&sb.charAt(i-1)+1!=sb.charAt(i))return false;
            if(isDown&&sb.charAt(i-1)!=sb.charAt(i)+1)return false;
        }
        return true;

    }
}
