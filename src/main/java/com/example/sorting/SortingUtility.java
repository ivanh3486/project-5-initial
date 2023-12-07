package com.example.sorting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingUtility {

    // TODO implement Gnome Sort here
    public static <T extends Comparable<T>> void gnomeSort(T[] data) {
        int pos = 0;
        while (pos < data.length) {
            if (pos == 0 || data[pos].compareTo(data[pos - 1]) >= 0) {
                pos+= 1;
            } else {
                swap(data, pos, pos - 1);
                pos-= 1;
            }
        }
    }

    // TODO implement Cocktail Shaker Sort here
    public static <T extends Comparable<T>> void cocktailShakerSort(T[] data) {
        boolean swapped;
        do {
            swapped = false;
            //Forward pass
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i].compareTo(data[i + 1]) > 0) {
                    swap(data, i, i + 1);
                    swapped = true;
                }
            }

            //Exit the loop if no swaps occurred
            if (!swapped) {
                break;
            }

            swapped = false;
            // Backward pass
            for (int i = data.length - 2; i >= 0; i--) {
                if (data[i].compareTo(data[i + 1]) > 0) {
                    //Swap element if they are in the wrong order
                    swap(data, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    private static <T> void swap(T[]array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T extends Comparable<T>> void shellSort(T[] data) {
        List<Integer> gaps = Arrays.asList(701, 301, 132, 57, 23, 10, 4, 1);

        for (int gap : gaps) {
            for(int i = gap; i < data.length; i++) {
                T temp = data[i];

                int j;
                for(j = i; (j >= gap) && (data[j - gap].compareTo(temp) >0); j -= gap) {
                    data[j] = data[j - gap];
                }
                data[j] = temp;
            }
        }
    }
    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;

    }
}





