package core;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsoleLogger {

    private static boolean isLoggable = false;

    public static void setLoggable(boolean value) {
        isLoggable = value;
    }

    public static void logInfo(String message) {
        String className = "";
        String methodName = "";
        try {
            className = String.valueOf(Class.forName(Thread.currentThread().getStackTrace()[2].getClassName()));
        } catch (Exception e){

        }

        try {
            methodName = String.valueOf(Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (Exception e){
        }

        if(isLoggable) System.out.println(className + "#" + methodName + " " + message);

    }
}
