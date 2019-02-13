import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        try (FileInputStream fileIn = new FileInputStream("config/config.properties")){
            Properties prop = new Properties();
            prop.load(fileIn);
            Logic.getLogic(prop);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
