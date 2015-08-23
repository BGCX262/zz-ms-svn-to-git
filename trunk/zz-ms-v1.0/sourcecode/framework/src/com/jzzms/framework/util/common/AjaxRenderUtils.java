/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-framework-trunk
 * $Id$
 * $Revision$
 * Last Changed by jason at 2011-9-22 下午1:24:00
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * jason     2011-9-22        Initailized
 */

package com.jzzms.framework.util.common;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 实现获取Response绕过jsp/freemaker直接输出文本的简化函数.
 *
 */
public class AjaxRenderUtils {
    //header 常量定义
    private static final String ENCODING_PREFIX = "encoding";
    private static final String NOCACHE_PREFIX = "no-cache";
    private static final String ENCODING_DEFAULT = "UTF-8";
    private static final boolean NOCACHE_DEFAULT = true;
    private static Log log = LogFactory.getLog(AjaxRenderUtils.class);
    
    /**
     * 直接输出内容的简便函数.
     * eg.
     * render("text/plain", "hello", "encoding:GBK");
     * render("text/plain", "hello", "no-cache:false");
     * render("text/plain", "hello", "encoding:GBK", "no-cache:false");
     * 
     * @param headers 可变的header数组，目前接受的值为"encoding:"或"no-cache:",默认值分别为UTF-8和true.                 
     */
    public static void render(HttpServletResponse response, final String contentType, final String content, final String... headers) {
        try {
            //分析headers参数
            String encoding = ENCODING_DEFAULT;
            boolean noCache = NOCACHE_DEFAULT;
            for (String header : headers) {
                String headerName = StringUtils.substringBefore(header, ":");
                String headerValue = StringUtils.substringAfter(header, ":");
                if (StringUtils.equalsIgnoreCase(headerName, ENCODING_PREFIX)) {
                    encoding = headerValue;
                } 
                else if (StringUtils.equalsIgnoreCase(headerName, NOCACHE_PREFIX)) {
                    noCache = Boolean.parseBoolean(headerValue);
                } 
                else{
                    throw new IllegalArgumentException(headerName + "is not a legal argument");
                }
            }

            //设置headers参数
            String fullContentType = contentType + ";charset=" + encoding;
            response.setContentType(fullContentType);
            if (noCache) {
                response.setHeader("Pragma", "No-cache");
                response.setHeader("Cache-Control", "no-cache");
                response.setDateHeader("Expires", 0);
            }
            response.getWriter().write(content);
        } 
        catch (IOException e) {
            log.error("ERROR", e);
        }
    }

    /**
     * 直接输出文本.
     * @see #render(String, String, String...)
     */
    public static void renderText(HttpServletResponse response, final String text, final String... headers) {
        render(response, "text/plain", text, headers);
    }

    /**
     * 直接输出HTML.
     * @see #render(String, String, String...)
     */
    public static void renderHtml(HttpServletResponse response, final String html, final String... headers) {
        render(response, "text/html", html, headers);
    }

    /**
     * 直接输出XML.
     * @see #render(String, String, String...)
     */
    public static void renderXml(HttpServletResponse response, final String xml, final String... headers) {
        render(response, "text/xml", xml, headers);
    }

    /**
     * 直接输出JSON.
     * 
     * @param string json字符串.
     * @see #render(String, String, String...)
     */
    public static void renderJson(HttpServletResponse response, final String string, final String... headers) {
        render(response, "application/json", string, headers);
    }

    /**
     * 直接输出JSON.
     * 
     * @param object Java对象,将被转化为json字符串. Object 可以为map，也可以为普通对象
     * @see #render(String, String, String...)
     */
    public static void renderJson(HttpServletResponse response, final Object object, final String... headers) {
        throw new IllegalAccessError("not implement yet@");
        //String jsonString = "";
        
        /*if(object instanceof List){
            jsonString = JSONArray.fromObject(object).toString();
        }
        else{
            jsonString = JSONObject.fromObject(object).toString();
        }*/
        //renderJson(response, jsonString, headers);
    }
}
