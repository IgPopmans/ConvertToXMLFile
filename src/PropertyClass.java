import java.io.*;
import java.util.Map;
import java.util.Properties;


public class PropertyClass {
    public static void main(String[] args) throws IOException {

        String path;
        try (BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Insert path to Property File ");
            path = bufferedInputStream.readLine();
        }

        Properties properties;
        try (BufferedReader bufferedReaderPropertiesReader = new BufferedReader(new FileReader(path))) {
            properties = new Properties();
            properties.load(bufferedReaderPropertiesReader);
        }
        for (Map.Entry<Object, Object> objectObjectEntry : properties.entrySet()) {
            System.out.println(objectObjectEntry.getKey() + ":" + objectObjectEntry.getValue());
        }

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Insert path to write file in XML format");
            String pathToXml = bufferedReader.readLine();
            FileOutputStream fileOutputStream = new FileOutputStream(pathToXml);
            properties.storeToXML(fileOutputStream, "Converting file in XML format");
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
