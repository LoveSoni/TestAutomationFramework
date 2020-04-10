package utilities;

import org.apache.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private FileInputStream fileInputStream;
    private Properties properties;
    private Logger logger = Logger.getLogger(PropertyReader.class);

    public Properties readProperty(String filePath){
        try {
            fileInputStream = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fileInputStream);
        }catch (IOException f){
            logger.error(f.getMessage());
        }
        return properties;
    }
}
