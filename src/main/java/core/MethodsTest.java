package core;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by Pavitra on 12/13/2015.
 */
public class MethodsTest {
    public static void main(String[] args) {
        HashMap<String, String> activtyMap = RequestHandler.getActivityMethodsMap();
        System.out.println(activtyMap.get("add_method"));

        System.out.println(ActivityApiService.GET_ID);

    }
}


class RequestHandler {
    public static final Method[] activityMethods = ActivityApiService.class.getDeclaredMethods();
    public static final Method[] apiMethods = ApiService.class.getDeclaredMethods();

    public static HashMap<String, String> getActivityMethodsMap() {
        HashMap<String, String> activityMap = new HashMap<>();
        String[] methods = getMethodNames(ActivityApiService.class.getDeclaredMethods());
        for (String methodName : methods) {
            activityMap.put(methodName + "_method", methodName);
        }
        return activityMap;
    }


    /**
     * Helper method to get general names of Methods from Array of Methods.
     *
     * @param methods
     * @return
     */
    public static String[] getMethodNames(Method[] methods) {
        if (methods.length < 0)
            return null;
        else {
            String[] methodNames = new String[methods.length];
            for (int i = 0; i < methods.length; i++) {
                methodNames[i] = methods[i].getName();
            }
            return methodNames;
        }
    }
}