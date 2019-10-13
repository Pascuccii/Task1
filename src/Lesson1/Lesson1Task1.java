package Lesson1;

public class Lesson1Task1 {
    public static void main(String[] args) {
        byte[] bytes = {1,2,3,4,5};
        byte sum = 0;

        for (byte b : bytes)
            sum+=b;

        System.out.println(sum);
    }
}
