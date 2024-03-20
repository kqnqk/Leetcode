public class Test {
    public static void main(String[] args) {
        int [] arr = continousSubarays(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 3);
        for(int i: arr) System.out.print(i + " ");
    }

    public static int [] continousSubarays(int [] arr, int k) {
        int [] result = new int[arr.length - k + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i + k > arr.length) {
                break;
            }
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            result[index] = sum;
            index++;
        }
        return result;
    }
}