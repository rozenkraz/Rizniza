package org.example.DAO.Base;

import java.io.File;

public class GetPath {

    public static String path1 = new File("").getAbsolutePath();
    public static final String path = path1.replace('\\', '/');
}