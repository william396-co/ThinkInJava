package com.Utils2;

import java.io.File;

public class FileUtil 
{
    public static boolean deleteDir(File dir,boolean isDelDir)
    {
        if (dir.isDirectory()) 
        {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) 
            {
                boolean success = deleteDir(new File(dir, children[i]),true);
                if (!success) 
                {
                    return false;
                }
            }
        }
        if(isDelDir)
        	return dir.delete();
        return true;
    }
    
    public static File[] listFile(String directory) 
    {
        File root = new File( directory );
        File[] files = root.listFiles();

        return files;
    }
}
