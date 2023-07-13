package intervals;

import java.util.*;

public class AndroidVersions {

    private static List<Pair> getBucketsSelfBalancingTree(List<ApkVersion> versions) {
        // TreeSet is self-balancing binary tree and so it sorts the elements and doesn't allow duplicate
        TreeSet<Integer> sortedSet = new TreeSet<>(Comparator.comparingInt(a -> a));

        List<Pair> result = new ArrayList<>();

        for (ApkVersion version : versions) {
            sortedSet.add(version.minSdkVersion);
            sortedSet.add(version.maxSdkVersion);
        }

        int start, end;
        for (Integer element : sortedSet) {
            start = element;
            end = sortedSet.first() != null ? sortedSet.first() - 1 : -1;
            result.add(new Pair(start, end));
        }

        return result;
    }

    private static List<Pair> getBuckets(List<ApkVersion> versions) {
        // Queue allows duplicates
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));

        List<Pair> result = new ArrayList<>();

        for (ApkVersion version : versions) {
            if (!queue.contains(version.minSdkVersion)) {
                queue.add(version.minSdkVersion);
            }

            if (!queue.contains(version.maxSdkVersion)) {
                queue.add(version.maxSdkVersion);
            }
        }

        int start, end;
        while (!queue.isEmpty()) {
            start = queue.poll();
            end = queue.peek() != null ? queue.peek() - 1 : -1;
            result.add(new Pair(start, end));
        }

        return result;
    }

    public static void main(String[] args) {
        ApkVersion apkVersion1 = new ApkVersion("A", 4, 0);
        ApkVersion apkVersion2 = new ApkVersion("B", 0, 16);
        ApkVersion apkVersion3 = new ApkVersion("C", 7, 10);

        List<ApkVersion> versions = new ArrayList<>() {{
            add(apkVersion1);
            add(apkVersion2);
            add(apkVersion3);
        }};

        System.out.println(getBuckets(versions));
        System.out.println(getBucketsSelfBalancingTree(versions));
    }
}

class ApkVersion {
    String apk;
    Integer minSdkVersion;
    Integer maxSdkVersion;

    public ApkVersion(String apk, Integer minSdkVersion, Integer maxSdkVersion) {
        this.apk = apk;
        this.minSdkVersion = minSdkVersion;
        this.maxSdkVersion = maxSdkVersion;
    }

    public String getApk() {
        return apk;
    }
}
