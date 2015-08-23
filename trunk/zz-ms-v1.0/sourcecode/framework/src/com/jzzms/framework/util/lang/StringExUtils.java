/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-utility-trunk
 * $Id$
 * $Revision$
 * Last Changed by jason at 2011-10-22 上午11:17:22
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * jason     2011-10-22        Initailized
 */

package com.jzzms.framework.util.lang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;


/**
 * 字符串扩展功能工具类
 *
 */
public class StringExUtils {
    public static final String COMMA_SIGN_SPLIT_NAME =              ",";
    
    private StringExUtils(){
        
    }
    
    /**
     * 占位符处理
     * param 为用逗号隔开
     * @return
     */
    public static String stringHolderParse(String originStr, String param, String split){
        if(StringUtils.isBlank(originStr)){
            return StringUtils.EMPTY;
        }
        
        Pattern pattern = Pattern.compile("\\{\\d\\}");
        Matcher matcher = pattern.matcher(originStr);
        int count = 0;
        while(matcher.find()){
            count++;
        }
        
        if(count > 0){
            if(StringUtils.isBlank(split)){
                split = COMMA_SIGN_SPLIT_NAME;
            }
            if(StringUtils.isBlank(param)){
                param = StringUtils.EMPTY;
            }
            String [] params = param.split(split);
            for(int i = 0; i< count; i++){
                String value = (params.length < (i + 1)) ? "" : params[i];
                originStr = originStr.replaceAll("\\{" + i + "\\}", value);
            }
        }
        return originStr;
    }
    
    public static String stringToCertCharset(String str, String charset){
        try{
            return new String(str.getBytes(), charset);
        }
        catch(Exception e){
            return str;
        }
    }
    
    public static String byteToCertCharset(byte [] bytes, String charset){
        try{
            return new String(bytes, charset);
        }
        catch(Exception e){
            return new String();
        }
    }
    
    public static void main(String [] args){
        Pattern pattern = Pattern.compile("\\{\\d\\}");
        Matcher matcher = pattern.matcher("hello0 {0}, hello1 {1}, hello2{2}打法");
        int count = 0;
        while(matcher.find()){
            count++;
        }
        System.out.println(count);
        
        count = 0;
        matcher = pattern.matcher("hello0 {0}, hello1 {1}打法的");
        while(matcher.find()){
            count++;
        }
        System.out.println(count);
        
        count = 0;
        matcher = pattern.matcher("hello0 {0}");
        while(matcher.find()){
            count++;
        }
        System.out.println(count);
        
        count = 0;
        matcher = pattern.matcher("hello0");
        while(matcher.find()){
            count++;
        }
        System.out.println(count);
        
        System.out.println(stringHolderParse("hello0 {0}, hello1 {1}打法的","1,2,3", null));
        System.out.println(stringHolderParse("hello0 {0}, hello1 {1}打法的","1", null));
        System.out.println(stringHolderParse("hello0 {0}, hello1 {1}打法的","", null));
    }
}
