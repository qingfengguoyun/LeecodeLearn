package com.myProject9_21.utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileTypeUtils {
    public static String getFileType(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream=new BufferedInputStream(inputStream);
        byte[] bytes = new byte[28];
        bufferedInputStream.read(bytes, 0, 28);
//        bufferedInputStream.reset();

        if (isType(bytes, "FFD8FF")) {
            return "JPEG";
        } else if (isType(bytes, "89504E47")) {
            return "PNG";
        } else if (isType(bytes, "47494638")) {
            return "GIF";
        } else if (isType(bytes, "49492A00")) {
            return "TIFF";
        } else if (isType(bytes, "424D")) {
            return "BMP";
        } else if (isType(bytes, "D0CF11E0A1B11AE1")) {
            return "DOC/XLS";
        } else if (isType(bytes, "504B0304")) {
            return "DOCX/XLSX";
        } else if (isType(bytes, "3C3F786D6C")) {
            return "XML";
        } else if (isType(bytes, "EFBBBF")) {
            return "TXT";
        }

        return "Unknown";
    }

    private static boolean isType(byte[] bytes, String type) {
        StringBuilder hexBuilder = new StringBuilder();
        for (byte b : bytes) {
            hexBuilder.append(String.format("%02X", b));
        }
        String hexString = hexBuilder.toString();
        return hexString.startsWith(type);
    }
}