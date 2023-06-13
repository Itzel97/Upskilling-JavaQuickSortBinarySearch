package upskilling.ordenamiento;

public class Sort {

    // Bubble Sort:
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        boolean swapped;

        // Haremos tantas iteraciones como elementos en el arreglo:
        for( int i = 0; i < n-1; i++) {
            swapped = false;
            // Al final de la iteración i, el i-esimo número más grande, ya estará en el lugar que le corresponde
            for (int j = 0; j < n-i-1; j++) {
                if ( arr[j] > arr[j+1] ){
                    // Si un numero esta antes que otro numero mas grande, se intercambian
                    swap(arr, j, j+1);
                    swapped = true;
                }
            }

            // Si hay final de la iteración no hubo intercambio, el arreglo ya está ordenado
            if(!swapped) break;
        }
    }

    // Auxiliar, intercambia arr[i] con arr[j] y viceversa
    private static void swap(int[] arr, int i, int j){
        int aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }

    // Merge Sort
    public static void mergeSort(int[] arr){
        sort(arr,0, arr.length-1);
    }

    // Auxiliar para mergeSort
    private static void sort(int[] arr, int izquierda, int derecha){
        if( izquierda < derecha){
            // Encontrar punto medio
            int mitad = (izquierda + derecha) / 2;

            // Ordenar recursivamente la izquierda
            sort(arr, izquierda, mitad);
            // Ordenar recursivamente la derecha
            sort(arr, mitad+1, derecha);

            // Mezclar las dos mitades
            mezcla(arr, izquierda, mitad, derecha);
        }
    }

    // Auxiliar para mergeSort
    private static void mezcla(int[] arr, int izquierda, int mitad, int derecha) {
        // Calcular tamaño de los sub-arreglos
        int tamanoIzq = mitad - izquierda + 1;
        int tamanoDer = derecha - mitad;

        // Crear arreglos temporales
        int[] arrI = new int[tamanoIzq];
        int[] arrD = new int[tamanoDer];

        System.arraycopy(arr, izquierda, arrI, 0, tamanoIzq);
        System.arraycopy(arr, derecha-tamanoDer+1, arrD, 0, tamanoDer);

        // Mezclaremos ambos arreglos, recorriendo los dos a la vez y poniendo en el arreglo final el menor:
        int i = 0; // indice para sub-arreglo izquierdo
        int d = 0; // indice para sub-arreglo derecho
        int k = izquierda; // indice en el arreglo original

        while (i < tamanoIzq && d < tamanoDer){
            if(arrI[i] <= arrD[d]){
                arr[k] = arrI[i];
                i++;
            }else{
                arr[k] = arrD[d];
                d++;
            }
            k++;
        }

        // El ciclo anterior se termina cuando terminemos con alguno de los sub-arreglos
        // entonces solo queda copiar lo que sobró del otro sub-arreglo:

        // Copiar izquierda
        while (i < tamanoIzq){
            arr[k] = arrI[i];
            i++;
            k++;
        }

        // Copiar derecha
        while (d < tamanoDer){
            arr[k] = arrD[d];
            d++;
            k++;
        }

    }

    public static void quickSort(int[] arr){

        quickSortAux(arr, 0, arr.length-1);

        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i]+", ");
        }
    }

    private static void quickSortAux(int arr[], int izq, int der) {
        int pivote = arr[izq];
        int i = izq;
        int j = der;
        int auxiliar;

        while (i < j) {
            while (arr[i] <= pivote && i < j) i++;
            while (arr[j] > pivote) j--;
            if (i < j) {
                auxiliar = arr[i];
                arr[i] = arr[j];
                arr[j] = auxiliar;
            }
        }

        arr[izq] = arr[j];
        arr[j] = pivote;

        if (izq < j - 1) {
            quickSortAux(arr, izq, j - 1);
        }
        if (j + 1 < der) {
            quickSortAux(arr, j + 1, der);
        }

    }



        public static String arrayToString(int[] a) {
        if (a == null)
            return "null";

        int iMax = a.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }

}
