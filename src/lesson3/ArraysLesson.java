package lesson3;

import java.util.Arrays;

public class ArraysLesson {
    public static void main(String[] args) {

        int[] arr; // объявление переменной массива
        int arr1[];

        // массив со значениями по умолчанию из 5 элементов
        arr = new int[5];

        System.out.println(Arrays.toString(arr));

        // размер массива изменить нельзя

        System.out.println("Размер массива = " + arr.length);

        // наполнения массива значениями при инициализации
        int[] arr3 = {2, 12, 45, 78, 34};
        System.out.println(Arrays.toString(arr3));
        System.out.println(arr3.length);

        // доступ к элементам массива
        System.out.println(arr3[2]);
        System.out.println(arr3[2+2]);
//        System.out.println(arr3[7]); ArrayIndexOutOfBoundsException: 7

        arr3[1] = 123;
        System.out.println(Arrays.toString(arr3));

//        заполнить массив в цикле
        for (int i = 0; i < arr.length; i++) {
            arr[i] += 3;
        }
        System.out.println(Arrays.toString(arr));

        // копирование массива
        int[] arr4 = {2, 6, 8, 3, 8, 3};
        int[] arr5 = arr4; // копия создана не будет, будет создана ссылка на один объект
//
        int[] cloneArr4 = arr4.clone();

        int[] arr6 = new int[10];
        System.arraycopy(arr4, 1, arr6, 2, 1);
        System.out.println(Arrays.toString(arr6));

        int[] copyArr4 = Arrays.copyOf(arr4, 14);
        System.out.println(Arrays.toString(copyArr4));

        arr4 = new int[]{2, 6, 8, 3, 8, 3, 98};
        // перебор значений массива в цикле
        // элементы массива можно изменить
        for (int i = 0; i < arr4.length; i++){
            arr4[i] += 4;
        }
        System.out.println(Arrays.toString(arr4));

        // элементы массива нельзя изменить
        for (int num: arr4){
            System.out.println("num = " + num);
            num += 4;
        }
        System.out.println(Arrays.toString(arr4));

// сравнение массивов
        arr4 = new int[]{2, 6, 8, 3, 8, 3, 98};
        arr5 = new int[]{2, 6, 8, 3, 8, 3, 98};

        System.out.println(arr4 == arr5); // false
        System.out.println(arr4.equals(arr5)); // false

        System.out.println(Arrays.equals(arr4, arr5)); // true

        int[] arr7 = new int[14];
        Arrays.fill(arr7, 233);
        System.out.println(Arrays.toString(arr7));

        arr7 = new int[]{34, 1, -90, 45, 72};
        Arrays.sort(arr7, 1, 4);
        System.out.println(Arrays.toString(arr7));
        Arrays.sort(arr7);
        System.out.println(Arrays.toString(arr7));

        arr7 = new int[]{2, 3, 4, 5, 6};
        arr7 = new int[]{34, 1, -90, 45, 72};
        System.out.println(Arrays.binarySearch(arr7, 200));

    }
}
