package numbers;

public class ExtremeElements {
    public static void main(String[] args) {
        int[] array = {100, 5, 2, 58, 15, 78, 45, 96, 22, 200, 45, -15, -50};
        int smallest = 0;
        int largest = 0;
        for (int i = 0; i < array.length; i++) {
            if (largest < array[i]) {
                largest = array[i];
            }
        }
        smallest = largest;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }

        System.out.println("Largest: " + largest);
        System.out.println("Smallest: " + smallest);
    }
}
