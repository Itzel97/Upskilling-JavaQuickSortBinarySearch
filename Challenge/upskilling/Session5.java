package upskilling;

import upskilling.busqueda.Search;
import upskilling.ordenamiento.Sort;

import java.util.ArrayList;
import java.util.Random;

public class Session5 {

    public static void main(String [] args) {
        int arr[] = generateRandomArray(10);

        int[] arr1 = new int[arr.length];
        System.arraycopy(arr, 0, arr1, 0, arr.length);

        Sort.bubbleSort(arr1);
        System.out.println("Bubble Sort:\n" +
                "-Orinal Array:" + Sort.arrayToString(arr) + "\n" +
                "-Sorted array: " + Sort.arrayToString(arr1));

        int[] arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);

        Sort.mergeSort(arr2);
        System.out.println("Merge Sort:\n" +
                "-Orinal Array:" + Sort.arrayToString(arr) + "\n" +
                "-Sorted array: " + Sort.arrayToString(arr2));

        int[] arr3 = new int[arr.length];
        System.arraycopy(arr, 0, arr3, 0, arr.length);

        Sort.quickSort(arr3);
        System.out.print(" \n");
        System.out.println("Quick Sort:\n" +
                "-Orinal Array:" + Sort.arrayToString(arr) + "\n" +
                "-Sorted array: " + Sort.arrayToString(arr3));

        System.out.println("\n-------------------------------------------------\n");

        int target = arr3[getRandomNumber(0,arr3.length)];
        System.out.println("Searching for "+ target);

        int indexOfTarget = Search.linearSearch(arr2, target);

        if(indexOfTarget>-1) System.out.println("Target found at index "+ indexOfTarget +
                "; arr["+indexOfTarget+"] = "+arr2[indexOfTarget]);
        else System.out.println("Target not Found");

        indexOfTarget = Search.binarySearch(arr3, target);
        System.out.print(" \n");
        System.out.print("binarySearch: \n");
        if(indexOfTarget>-1) System.out.println("Target found at index "+ indexOfTarget +
                "; arr["+indexOfTarget+"] = "+arr3[indexOfTarget]);
        else System.out.println("Target not Found");
    }

    private static int[] generateRandomArray(int n){
        ArrayList<Integer> list = new ArrayList<Integer>(n);
        Random random = new Random();

        for (int i = 0; i < n; i++)
        {
            list.add(random.nextInt(1000));
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
