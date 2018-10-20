package adt;

import juego.Dragon;

import java.util.Arrays;

public class SortArray {
    private Dragon[] arr;

    public SortArray(Dragon[] arr) {
        this.arr = arr;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    //https://www.geeksforgeeks.org/selection-sort/
    public void SelectionSort()
    {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j].getEdad() < arr[min_idx].getEdad())
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            Dragon temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    //https://www.geeksforgeeks.org/insertion-sort/
    public void InsertionSort()
    {
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            Dragon key = arr[i];
            int j = i-1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arr[j].getRecarga() > key.getRecarga())
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }


    public void quickSort() {
        quickSort(0,arr.length-1 );
    }

    //http://www.java2novice.com/java-sorting-algorithms/quick-sort/
    private void quickSort(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        Dragon pivot = arr[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /*
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (arr[i].getEdad() < pivot.getEdad()) {
                i++;
            }
            while (arr[j].getEdad() > pivot.getEdad()) {
                j--;
            }
            if (i <= j) {
                Swap(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }

    private void Swap(int i, int j) {
        Dragon temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public Dragon[] getArr() {
        return arr;
    }
}
