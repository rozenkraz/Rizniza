package org.example.DAO;

import java.io.File;

public class GetPath {

    public static String path1 = new File("").getAbsolutePath();
    public static final String path = path1.replace('\\', '/');
}