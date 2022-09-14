package designPattern;

public class ReviewSigleton {
    public static void main(String[] args) {

    }


    public static class Sigleton{
        private Sigleton(){

        }
        private static volatile Sigleton sigleton=null;
        public static Sigleton getSigleton(){
            if(sigleton==null){
                synchronized(Sigleton.class){
                    if(sigleton==null){
                        sigleton=new Sigleton();
                        return sigleton;
                    }
                }
            }
            return sigleton;
        }
    }
}
