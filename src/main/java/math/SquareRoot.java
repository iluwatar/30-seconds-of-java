package math;

public class SquareRoot {
    static double sqrt(int num, int p)  //p-precision(till how many decimal numbers we want)
    {
        int start = 0, end = num;
        double root = 0.0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if ((mid * mid) > num)
                end = mid - 1;
            else if ((mid * mid) < num)
                start = mid + 1;
            else
                return mid;
        }
        //root=end;
        double incr = 0.1;

        for (int i = 0; i < p; i++) {
            while (root * root < num)
                root = root + incr;

            root = root - incr;
            incr = incr / 10;
        }

        return root;
    }
}
