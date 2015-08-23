/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-framework-trunk
 * $Id$
 * $Revision$
 * Last Changed by jason at 2012-4-18 下午1:48:12
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * jason     2012-4-18        Initailized
 */

package com.jzzms.framework.util.common;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 异步通知工具类
 *
 */
public class AsynchNoticeUtils {
    protected static final Log log = LogFactory.getLog(AsynchNoticeUtils.class);
    
    public static void httpPostNotice(final String url, final String param){
        new Thread(new Runnable() {
            public void run() {
                log.debug("start asyn notice ...");
                
                HttpURLConnection connection = null;
                StringBuilder sb = new StringBuilder(url);
                try {
                    if (url.indexOf("?") > 0) {
                        sb.append("&").append(param);
                    }
                    else {
                        sb.append("?" + param);
                    }
                    log.debug("req url : " + sb.toString());
                    
                    connection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                    connection.setDoOutput(true);
                    connection.setDoInput(true);
                    connection.setRequestMethod("POST");
                    connection.setUseCaches(false);
                    connection.connect();
                    
                    DataOutputStream out = new DataOutputStream(connection.getOutputStream());
                    out.writeBytes(sb.toString());
                    out.flush();
                    out.close();
                    connection.getInputStream();
                }
                catch (Exception e) {
                    log.warn(e.getMessage(), e);
                }
                finally {
                    if (connection != null) {
                        try {
                            connection.disconnect();
                        }
                        catch (Exception e) {
                            log.warn(e.getMessage(), e);
                        }
                        log.debug("end asyn openNotice !!!");
                    }
                }
                
            }
        }).start();
        log.debug("end ...");
    }
}
