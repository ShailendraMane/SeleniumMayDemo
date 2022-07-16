package stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class ReadPropertiesData {


   public static Logger log= LogManager.getLogger();

    public static String getPropertyValue(String env,String key) throws IOException
    {
        File file=null;
        String value=null;
        if(env.equalsIgnoreCase("Preprod")) {
             file = new File("/Users/priyanka.a/SeleniumMayPOM/src/test/resources/preprod.properties");
             log.info("The file name is",env);
        }else if(env.equalsIgnoreCase("Prod"))
        {
             file = new File("/Users/priyanka.a/SeleniumMayPOM/src/test/resources/Prod.properties");
            log.info("The file name is"+env);
        }else
        {
            log.error("file not found");
        }
        FileInputStream fis=new FileInputStream(file);
        Properties prop=new Properties();
        prop.load(fis);
        value= prop.getProperty(key);
        log.info("The value for key"+value);
        return value;
    }

}
