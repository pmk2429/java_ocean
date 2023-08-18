package intervals;

// Object based representation of 2D interval array [start, end]
public class Interval {
    public int start;
    public int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public String toString() {
        if (start <= 0) {
            return "( <= " + end + ")";
        }
        if (end <= 0) {
            return "(" + start + " >= )";
        }
        return "(" + start + ", " + end + ")";
    }
}
