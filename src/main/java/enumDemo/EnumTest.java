package enumDemo;

/**
 * Created by Pavitra on 11/10/2015.
 */
public class EnumTest {
    public enum ActivityState {
        STARTED, RUNNING, STOPPED
    }

    public static enum API_METHOD {
        GET("get"), GET_ALL("getAll"), ADD("add"), UPDATE("update"), DELETE("delete");

        private final String method;

        API_METHOD(String method) {
            this.method = method;
        }

        public String getMethod() {
            return method;
        }


    }

    public static void main(String[] args) {
        System.out.println(ActivityState.RUNNING);
        String method = API_METHOD.GET_ALL.getMethod();
        API_METHOD methodName = API_METHOD.valueOf("GET");
        System.out.println(methodName.getMethod());
    }
}
