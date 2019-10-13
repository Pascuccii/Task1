package Lesson1;

import java.util.Random;

public class Lesson1Task3 {
    public static void main(String[] args) {
        int[] array = randomArray(20, 0, 20);
        int[] array1 = randomArray(20, 0, 20);
        int maxDiffId = indexOfMaxDifference(array);
        show(array);
        System.out.println("Сумма чётных элементов в массиве: " + oddEvenSum(array, true));
        System.out.println("Сумма нечётных элементов в массиве: " + oddEvenSum(array, false));
        System.out.println("Число 1 встречалось максимум " + maxSequence(array, 1) + " раз подряд.");
        System.out.println("Максимальная разница между " + maxDiffId + "-м и " + (maxDiffId + 1) + "-м элементом.");
        replace(array, 0, 1);
        show(array);
        sort(array, true);
        show(array);
        show(cutAndMerge(array, array1, true));
    }

    public static int[] cutAndMerge(int[] array1, int[] array2, boolean max) {
        int[] result = new int[Math.min(array1.length, array2.length)];

        for (int i = 0; i < result.length; i++)
            result[i] = (max) ? Math.max(array1[i], array2[i]) : Math.min(array1[i], array2[i]);

        return result;
    }

    public static void sort(int[] array, boolean minToMax) {
        doSort(array, 0, array.length - 1, minToMax);
    }

    private static void doSort(int[] source, int leftBorder, int rightBorder, boolean minToMax) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            if (minToMax) {
                while (source[leftMarker] < pivot) {
                    leftMarker++;
                }
                // Двигаем правый маркер, пока элемент больше, чем pivot
                while (source[rightMarker] > pivot) {
                    rightMarker--;
                }
            } else {
                while (source[leftMarker] > pivot) {
                    leftMarker++;
                }
                // Двигаем правый маркер, пока элемент больше, чем pivot
                while (source[rightMarker] < pivot) {
                    rightMarker--;
                }
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            doSort(source, leftMarker, rightBorder, minToMax);
        }
        if (leftBorder < rightMarker) {
            doSort(source, leftBorder, rightMarker, minToMax);
        }
    }

    public static void replace(int[] array, int toReplace, int replaceTo) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == toReplace)
                array[i] = replaceTo;
    }

    public static int indexOfMaxDifference(int[] array) {
        int maxDiffId = 0;
        int maxDiff = 0;
        int diff = 0;
        for (int i = 1; i < array.length; i++) {
            diff = Math.abs(array[i] - array[i - 1]);
            if (diff > maxDiff) {
                maxDiff = diff;
                maxDiffId = i - 1;
            }
        }
        return maxDiffId;
    }

    public static int oddEvenSum(int[] array, boolean odds) {
        int sum = 0;
        if (odds) {
            for (int el : array)
                if (el % 2 == 0)
                    sum += el;
        } else {
            for (int el : array)
                if (el % 2 == 1)
                    sum += el;
        }
        return sum;
    }

    public static void show(int[] array) {
        for (int el : array)
            System.out.print(el + " ");
        System.out.println();
    }

    public static int random(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public static int[] randomArray(int length, int min, int max) {
        int[] array = new int[length];

        for (int i = 0; i < length; i++)
            array[i] = random(min, max);

        return array;
    }

    public static int maxSequence(int[] array, int number) {
        int counter = 0;
        int max = 0;
        for (int el : array)
            if (el == number) {
                if (++counter > max)
                    max = counter;
            } else counter = 0;
        return max;
    }
}
