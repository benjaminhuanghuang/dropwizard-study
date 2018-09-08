package cn.huang.test.utilities;

import com.google.common.io.Files;

import java.io.File;
import java.nio.charset.Charset;

public class RestTestUtilities {
    public static String readPayloadsFromResource(String fileName) throws Exception {
        File file = new File(RestTestUtilities.class.getClassLoader().getResource(fileName).getFile());
        return String.join("", Files.readLines(file, Charset.defaultCharset()));
    }
}
