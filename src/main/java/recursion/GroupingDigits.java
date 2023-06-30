package recursion;

import java.util.ArrayList;
import java.util.List;

public class GroupingDigits {
    static List<Integer> hackerCards(List<Integer> collection, int d) {
        List<Integer> result = new ArrayList<>();
        int start, end;

        for (int i = 0; i <= collection.size(); i++) {
            if (i == 0) {
                start = 1;
            }
            else {
                start = collection.get(i - 1) + 1;
            }
            if (i != collection.size()) {
                end = collection.get(i);
            }
            else {
                end = Integer.MAX_VALUE;
            }

            if (d < start) break;
            for (int k = start; k < end; k++) {
                if (k <= d) {
                    result.add(k);
                    d -= k;
                }
                else {
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> collection = new ArrayList<>();
        collection.add(2);
        collection.add(4);
        collection.add(5);
        int d = 7;

        List<Integer> hacks = hackerCards(collection, d);
        System.out.println(hacks);
    }
}
