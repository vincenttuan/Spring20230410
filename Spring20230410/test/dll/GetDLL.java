package dll;

public class GetDLL {
    public static void main(String[] args) {
        int result1 = MyLibrary.INSTANCE.getFive();
        System.out.println("Result1: " + result1);
        int result2 = MyLibrary.INSTANCE.add_int(10, 20);
        System.out.println("Result2: " + result2);
        double result3 = MyLibrary.INSTANCE.add_double(5.12, 4.34);
        System.out.println("Result3: " + result3);
    }
}
