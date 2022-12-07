package intervals;

class Pair {
    private final int start;
    private final int finish;

    public Pair(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    public int getFinish() {
        return finish;
    }

    public int getStart() {
        return start;
    }

    @Override
    public String toString() {
        int start = getStart();
        int end = getFinish();
        if (start <= 0) {
            return "( <= " + end + ")";
        }
        if (end <= 0) {
            return "(" + start + " >= )";
        }
        return "(" + start + ", " + end + ")";
    }
}
