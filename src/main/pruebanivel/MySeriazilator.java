package pruebanivel;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;

public class MySeriazilator {
    private static ObjectMapper mapper = new ObjectMapper();
    public static <T> void serialize(List<T> obj, String filePath) throws IOException {
        File file = new File(filePath);
        mapper.writeValue(file, obj);
    }
    public static List<Object> deserialize(String fileName) throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Object> obj = Collections.singletonList(ois.readObject());
        ois.close();
        return obj;
    }

}

