package Lesson1;

public class Lesson1Task2 {
    public static void main(String[] args) {
        int[] mass = {1, 2, 23, 16, 5, 0, 7, -13, 9, 10};
        int min = mass[0];
        int max = mass[0];

        for (int el : mass) {
            if (el < min)
                min = el;
            if (el > max)
                max = el;
        }

        System.out.println("max = " + max + "\nmin = " + min);
    }
}
