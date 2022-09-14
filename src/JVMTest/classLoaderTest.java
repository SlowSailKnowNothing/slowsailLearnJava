package JVMTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Person{
    int age;
    int height;

    public void talk(){
        System.out.println("Hello World!");
    }
}
public class classLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ClassLoader loader=ClassLoader.getSystemClassLoader();
        String claaName=Person.class.getName();

        Class clazz=loader.loadClass(claaName);
        Method talk = clazz.getMethod("talk");
        talk.invoke(null);


    }
}
