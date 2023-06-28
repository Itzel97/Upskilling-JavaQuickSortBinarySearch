package upskilling.busqueda;

public class Search {

    public static int linearSearch(int[] arr, int target){
        for (int i = 0; i < arr.length; i++)
            if(arr[i] == target)
                return i;
        return -1;
    }

    public static int binarySearch(int[] arr, int target){
        return binarySearchAux(arr, 0, arr.length-1, target);
    }

    private static int binarySearchAux(int[] arr, int izquierda, int derecha, int target){
        /* TODO */
        while (izquierda <= derecha) {
            int m = izquierda + (derecha - izquierda) / 2;

            // Check if target is present at mid
            if (arr[m] == target)
                return m;

            // If target greater, ignore left half
            if (arr[m] < target)
                izquierda = m + 1;

                // If target is smaller, ignore right half
            else
                derecha= m - 1;
        }

        // If we reach here, then element was not present
        return -1;
    }

}
