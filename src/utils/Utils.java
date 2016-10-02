package utils;

import java.io.File;

public class Utils {
    public final static String bpel	= "bpel";
    public final static String txt	= "txt";
    /*
     * Get the extension of a file.
     */  
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
    //Add extension to file name if relevant
    public static String formatFileName(String fileName,String extension){
    	if(!fileName.endsWith(extension))
    		fileName=fileName+"."+extension;
    	return fileName;
    }
}
