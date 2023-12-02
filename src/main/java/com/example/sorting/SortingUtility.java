package com.example.sorting;
import java.util.ArrayList;
import java.util.List;

public class SortingUtility {

    // TODO implement Gnome Sort here
    public static <T extends Comparable<T>> void gnomeSort(T[] a) {
        int pos = 0;
        while (pos < a.length) {
            if (pos == 0 || a[pos].compareTo(a[pos - 1]) >= 0) {
                pos++;
            } else {
                swap(a, pos, pos - 1);
                pos--;
            }
        }
    }

    // TODO implement Cocktail Shaker Sort here
    public static <T extends Comparable<T>> void cocktailShakerSort(T[] A) {
        boolean swapped;
        do {
            swapped = false;
            //Forward pass
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i].compareTo(A[i + 1]) > 0) {
                    swap(A, i, i + 1);
                    swapped = true;
                }
            }

            //Exit the loop if no swaps occurred
            if (!swapped) {
                break;
            }

            swapped = false;
            // Backward pass
            for (int i = A.length - 1; i > 0; i--) {
                if (A[i - 1].compareTo(A[i]) > 0) {
                    swap(A, i, i - 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }


    public static <T extends Comparable<T>> void shellSort(T[] data) {
        List<Integer> gaps = new ArrayList<>();
        gaps.add(701);
        gaps.add(301);
        gaps.add(132);
        gaps.add(57);
        gaps.add(23);
        gaps.add(10);
        gaps.add(4);
        gaps.add(1);

        int n = data.length;
        for (int gap : gaps) {
            for(int i = gap; i < n; i++) {
                T temp = data[i];
                int j;
                for(j = i; j >= gap && data[j - gap].compareTo(temp) >0; j -= gap) {
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





