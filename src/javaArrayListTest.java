public class javaArrayListTest {
    public static void main(String[] args) {
        String str="123";
        int num1=Integer.parseInt(str);
        String str2=String.valueOf(num1);
        System.out.println(str==str2);   //false   这里要注意，equals比较的是值是否相同，而==比较的是地址是否相同
        System.out.println(str.equals(str2)); // true
    }
}
