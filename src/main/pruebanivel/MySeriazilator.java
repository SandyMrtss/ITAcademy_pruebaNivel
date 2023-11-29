package pruebanivel;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;

public class MySeriazilator {
    private static ObjectMapper mapper = new ObjectMapper();
    public static <T> void serialize(List<T> obj, String filePath) throws IOException {
        File file = new File(filePath);
        mapper.writerWithDefaultPrettyPrinter().writeValue(file, obj);
    }
}

