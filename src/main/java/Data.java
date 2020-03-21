import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class Data {
    HashMap<Integer,String> map;
    public Data(){
        InputStream inputStream = this.getInputStream();

        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<Integer,String> map = this.getVirusMap(inputStream,properties);
        map.forEach((key,value)-> System.out.println(value));
        this.map = map;
    }

    public static void temp() throws IOException {
        Data data = new Data();
        InputStream inputStream = data.getInputStream();

        Properties properties = new Properties();
        properties.load(inputStream);
        HashMap<Integer,String> map = data.getVirusMap(inputStream,properties);
        map.forEach((key,value)-> System.out.println(value));
    }


    private HashMap<Integer,String> getVirusMap(InputStream inputStream, Properties properties){
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        final HashMap<Integer,String> map = new HashMap<>();

        properties.forEach((key,value)-> map.put(Integer.parseInt((String) key), (String) value));

        return map;
    }


    private InputStream getInputStream(){
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("src/main/java/resources/viruse.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inputStream;
    }

}


