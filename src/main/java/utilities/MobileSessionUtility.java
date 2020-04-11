package utilities;

/**
 * Love
 */

import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MobileSessionUtility {
        public  static DesiredCapabilities setCapability(Map<String,String> keysAndValues){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        Set propertySet = keysAndValues.entrySet();
        Iterator iterator = propertySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> entry = (Map.Entry) iterator.next();
            desiredCapabilities.setCapability(entry.getKey(),entry.getValue());
        }
        return desiredCapabilities;
    }

}
