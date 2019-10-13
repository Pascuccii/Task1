package Lesson1;

public class Lesson1Task4 {
    public static void main(String[] args) {
        char[] array1 = randomCharArray(10, 20);
        show(array1);
        changeCharRegister(array1);
        show(array1);
    }

    private static char randomChar() {
        String latinLetters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return latinLetters.charAt(Lesson1Task3.random(0, latinLetters.length() - 1));
    }

    private static void show(char[] array) {
        for (char el : array)
            System.out.print(el);
        System.out.println();
    }

    public static char[] randomCharArray(int min, int max) {
        char[] result = new char[Lesson1Task3.random(min, max)];

        for (int i = 0; i < result.length; i++)
            result[i] = randomChar();

        return result;
    }

    public static void changeCharRegister(char[] array) {
        for (int i = 0; i < array.length; i++)
            if(array[i] == Character.toLowerCase(array[i]))
                array[i] = Character.toUpperCase(array[i]);
            else
                array[i] = Character.toLowerCase(array[i]);

    }
}
