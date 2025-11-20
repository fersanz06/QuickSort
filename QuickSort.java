public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        int j = high;
        while (i < j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            if (i < j) {
                swap(arr, i, j);
            }
        }
        return j;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] data = {5, 2, 9, 1, 5, 6};
        quickSort(data, 0, data.length - 1);
        for (int v : data) System.out.print(v + " ");
    }
}