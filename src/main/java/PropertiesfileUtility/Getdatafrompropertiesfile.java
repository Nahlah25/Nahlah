package PropertiesfileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Getdatafrompropertiesfile {
    public String Getdatafrompropertiesfile(String key) throws IOException {
        FileInputStream fis = new FileInputStream("./configdata/commondata.properties.txt");
        Properties prop = new Properties();
        prop.load(fis);
        String value = prop.getProperty(key);
        fis.close();
        return value;
    }
}
