public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        try {

                mainFile obj = new mainFile();
                obj.main();
            }

        catch (Exception e){
            System.out.println("came to error"+e);
        }
    }
}