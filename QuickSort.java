import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int a, int b) {
        if (a == b) return;
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static int[] readNumbersFromFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList<Integer> numbers = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null) {
            // Reemplazar comas por espacios
            line = line.replace(",", " ");
            String[] parts = line.trim().split("\\s+");
            for (String p : parts) {
                if (!p.isEmpty()) {
                    numbers.add(Integer.parseInt(p));
                }
            }
        }

        br.close();

        int[] arr = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            arr[i] = numbers.get(i);
        }

        return arr;
    }

    private static void saveNumbersToFile(int[] arr, String path) throws IOException {
        FileWriter writer = new FileWriter(path);

        for (int num : arr) {
            writer.write(num + " ");
        }

        writer.close();
    }

    private static void printArray(int[] arr) {
        for (int val : arr) System.out.print(val + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        // Cambia esta ruta por tu archivo real
        String rutaEntrada = "numeros.txt";
        String rutaSalida = "numerosQS.txt";

        try {
            // Leer datos desde archivo
            int[] data = readNumbersFromFile(rutaEntrada);

            System.out.println("Datos originales:");
            printArray(data);

            // Ordenar
            quickSort(data);

            System.out.println("\nDatos ordenados:");
            printArray(data);

            // Guardar datos ordenados en archivo
            saveNumbersToFile(data, rutaSalida);

            System.out.println("\nArchivo generado en:");
            System.out.println(rutaSalida);

        } catch (IOException e) {
            System.out.println("Error en la lectura o escritura: " + e.getMessage());
        }
    }
}
