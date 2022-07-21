package arrays;

import java.util.Arrays;

public class EnumToArray {
    private enum CUD_ENTITY {
        USER("USER"),
        PARTICIPANT("PARTICIPANT"),
        FILE("FILE"),
        TASK("TASK"),
        TOPIC("TOPIC"),
        WORKSPACE("WORKSPACE"),
        URL("URL");

        final String mName;

        CUD_ENTITY(String n) {
            mName = n;
        }
    }

    /**
     * Returns immutable array of Entities that generate CUD Activities.
     */
    private static String[] getCudEntities() {
        return Arrays.toString(CUD_ENTITY.values()).replaceAll("^.|.$", "").split(", ");
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getCudEntities()));
    }
}
