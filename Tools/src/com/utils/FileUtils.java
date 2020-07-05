package com.utils;

import java.io.*;

public class FileUtils {
    public FileUtils() {
    }

    public static String loadFile(String fileName) {
        StringBuffer sb = new StringBuffer();
        File file = new File(fileName);
        BufferedReader reader = null;

        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;

            for(int var5 = 1; (tempString = reader.readLine()) != null; ++var5) {
                sb.append(tempString + "\n");
            }

            reader.close();
        } catch (IOException var14) {
            var14.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException var13) {
                    ;
                }
            }

        }

        return sb.toString();
    }

    public String loadFileByStream(String fileName) {
        StringBuffer sb = new StringBuffer();
        InputStream is = null;
        BufferedReader br = null;

        try {
            is = this.getClass().getResourceAsStream(fileName);
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String s = "";

            while((s = br.readLine()) != null) {
                sb.append(s + "\n");
            }
        } catch (Exception var14) {
            var14.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }

                if (br != null) {
                    br.close();
                }
            } catch (IOException var13) {
                ;
            }

        }

        return sb.toString();
    }

    public String loadFileAsString(String fileName, boolean appendBr) {
        StringBuffer sb = new StringBuffer();
        InputStream is = null;
        BufferedReader br = null;

        try {
            is = this.getClass().getResourceAsStream(fileName);
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String s = "";

            while((s = br.readLine()) != null) {
                sb.append(s + (appendBr ? "\n" : ""));
            }
        } catch (Exception var15) {
            var15.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }

                if (br != null) {
                    br.close();
                }
            } catch (IOException var14) {
                ;
            }

        }

        return sb.toString();
    }
}