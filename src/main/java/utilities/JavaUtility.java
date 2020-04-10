package utilities;

import org.apache.log4j.Logger;

public class JavaUtility {
    private static Logger logger = Logger.getLogger(JavaUtility.class);

    public static void sleep(int seconds){
        try{
            Thread.sleep(1000*seconds);
        }catch (InterruptedException e){
            logger.error(e.getMessage());
        }
    }

}
