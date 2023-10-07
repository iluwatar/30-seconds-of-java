package array;

public class ArrayModeSnippet {
    public static int modeArray(int arr[]) {
        int mode = 0, maxcount = 0;

        for (int i = 0; i < arr.length; i++) {
            int count = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    count++;
            }
            if (count > maxcount) {
                maxcount = count;
                mode = arr[i];
            }
        }
        return mode;
    }

}
