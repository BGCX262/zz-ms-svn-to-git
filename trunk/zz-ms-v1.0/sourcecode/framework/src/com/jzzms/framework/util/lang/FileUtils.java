/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-common-utility-trunk
 * $Id$
 * $Revision$
 * Last Changed by ZhouXushun at 2011-8-3 下午05:42:54
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * ZhouXushun     2011-8-3        Initailized
 */

package com.jzzms.framework.util.lang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 文件操作帮助类
 *
 */
public class FileUtils {
    
private static Log log = LogFactory.getLog(FileUtils.class);
    
    private FileUtils(){
        
    }
    
    public static boolean isFileExsit(String filePathAndName){
        log.debug("filePathAndName... filePathAndName--> " + filePathAndName);
        
        try{            
            File file = new File(filePathAndName);
            if(file.exists()){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            log.error(null, e);
            return false;
        }
    }
    
    public static boolean makeDir(String filePath){
        log.debug("makeDir... filePath--> " + filePath);
        
        try{            
            File file = new File(filePath);
            if(file.exists()){
                return true;
            }
            else{
                if(file.mkdirs()){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        catch(Exception e){
            log.error(null, e);
            return false;
        }
    }
    
    /**
     * 删除文件
     * @param fileName
     * @return
     */
    public static boolean deleteFile(String fileName) {
        return new File(fileName).delete();
    }

    /**
     * 读取文件内容，并把每行作为string存放到list中
     * @param file
     * @return
     * @throws IOException
     */
    public static List<String> readFile(File file) throws IOException {
        List<String> content = new ArrayList<String>();
        FileReader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);
        String lineInfo = br.readLine();
        while (lineInfo != null) {
            content.add(lineInfo);
            lineInfo = br.readLine();
        }
        br.close();
        reader.close();
        return content;
    }

    public static void writeFile(String filePath, String fileName, List<String> fileContent) throws IOException {
        File file = new File(filePath + fileName);
        file.createNewFile();
        FileWriter write = new FileWriter(file);

        for (int i = 0; i < fileContent.size(); i++) {
            write.write(fileContent.get(i));
        }

        write.flush();
        write.close();
    }

    public static String getLastLine(File file) throws IOException {
        String lastLine = "";
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        long count = file.length();
        String beginLine = rf.readLine();
        if (beginLine != null) {
            long seek=0;
            String secondLine=rf.readLine();
            if(secondLine!=null){
                seek=count - secondLine.length() * 2;
            }else{
                seek=count - beginLine.length() * 2;
            }
            if(seek<0){
                seek=0;
            }
            rf.seek(seek);
        }
        String ss = beginLine;
        while (ss != null) {
            lastLine = ss;
            ss = rf.readLine();
        }
        rf.close();
        return lastLine;
    }
    
    public static String readFileToString(File file) throws IOException {
        StringBuffer sb = null;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
            sb = new StringBuffer();
            for (String line; (line = in.readLine()) != null;) {
                sb.append(line + "\r\n");
            }
        } finally {
            if (in != null)
                in.close();
        }

        return sb.toString();
    }
    
    public static String readFileToStringByEncoding(File file, String encoding) throws IOException {
        StringBuffer sb = null;
        BufferedReader in = null;
        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
            in = new BufferedReader(read);
            sb = new StringBuffer();
            for (String line; (line = in.readLine()) != null;) {
                sb.append(line + "\r\n");
            }
        } finally {
            if (in != null)
                in.close();
        }
           
        return sb.toString();
    }

    public static void writeFileByEncoding(String filePath, String fileName, String fileContent, String encoding) throws IOException {
        BufferedWriter out = null;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(filePath + fileName);
            file.createNewFile();
            OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(file), encoding);
            out = new BufferedWriter(write);   
            out.write(fileContent);
        } finally {
            out.flush();
            out.close();
        }
    }
    
    public static void writeFileByEncoding(String fileFullPath,String fileContent,String encoding) throws IOException{
        int lastCommIndex = fileFullPath.lastIndexOf("/");
        String filePath = fileFullPath.substring(0,lastCommIndex + 1);
        String fileName = fileFullPath.substring(lastCommIndex + 1);
        writeFileByEncoding(filePath,fileName,fileContent,encoding);
    }   
    
}
