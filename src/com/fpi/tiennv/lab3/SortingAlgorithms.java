/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpi.tiennv.lab3;

/**
 *
 * @author ROG
 */
import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithms {

    static class SortingMetrics {
        long comparisons = 0;
        long swaps = 0;
    }

    public static void main(String[] args) {
        int[] averageCase = { 34, 17, 89, 21, 56, 72 };
        int[] worstCase = { 99, 87, 65, 32, 15, 3 };
        
        compareSortingAlgorithms(averageCase, "Average Case");
        compareSortingAlgorithms(worstCase, "Worst Case");
    }

    public static void compareSortingAlgorithms(int[] array, String caseType) {
        System.out.println("Sorting for " + caseType);
        final int[] arrayCopy = Arrays.copyOf(array, array.length);
        final SortingMetrics sortingMetrics = new SortingMetrics();

        measureSortingTime(Arrays.copyOf(array, array.length), "Bubble Sort", new SortingMetrics(), () -> bubbleSort(arrayCopy));

        measureSortingTime(Arrays.copyOf(array, array.length), "Insertion Sort", new SortingMetrics(), () -> insertionSort(arrayCopy));

        measureSortingTime(Arrays.copyOf(array, array.length), "Selection Sort", new SortingMetrics(), () -> selectionSort(arrayCopy));

        measureSortingTime(Arrays.copyOf(array, array.length), "Merge Sort", new SortingMetrics(), () -> mergeSort(arrayCopy));

        measureSortingTime(Arrays.copyOf(array, array.length), "Quick Sort", new SortingMetrics(), () -> quickSort(arrayCopy));
    }

    public static void measureSortingTime(int[] array, String algorithmName, SortingMetrics metrics, Runnable sortingMethod) {
        long startTime = System.nanoTime();
        sortingMethod.run();
        long endTime = System.nanoTime();
        System.out.println(algorithmName + " execution time: " + (endTime - startTime) / 1_000_000.0 + " ms, Comparisons: " + metrics.comparisons + ", Swaps: " + metrics.swaps);
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        SortingMetrics metrics = new SortingMetrics();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                metrics.comparisons++;
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1, metrics);
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        SortingMetrics metrics = new SortingMetrics();
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                metrics.comparisons++;
                arr[j + 1] = arr[j];
                j--;
                metrics.swaps++;
            }
            arr[j + 1] = key;
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        SortingMetrics metrics = new SortingMetrics();
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                metrics.comparisons++;
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx, metrics);
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            arr[k++] = (left[i] < right[j]) ? left[i++] : right[j++];
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        SortingMetrics metrics = new SortingMetrics();
        for (int j = low; j < high; j++) {
            metrics.comparisons++;
            if (arr[j] < pivot) {
                swap(arr, ++i, j, metrics);
            }
        }
        swap(arr, i + 1, high, metrics);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j, SortingMetrics metrics) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        metrics.swaps++;
    }
}
