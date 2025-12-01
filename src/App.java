public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        int[] arr = {1,2,3,1};
        // int[] arr = {1,0,1,3,5,6,4};

        int res = getPeakIndex(arr);

        System.out.println("Peak Index: " + String.valueOf(res));

    }

    public static int getPeakIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int before;
            int after;

            try {
                before = arr[i-1];
            } catch (ArrayIndexOutOfBoundsException e) {
                before = arr[i] + 1;
            }
            try {
                after = arr[i+1];
            } catch (ArrayIndexOutOfBoundsException e) {
                after = arr[i] + 1;
            }

            if (arr[i] > before && arr[i] > after) {
                return i;
            }
        }
        return -1;
    }
}
