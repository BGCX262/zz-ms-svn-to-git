/**
 * Copyright : http://www.orientpay.com , 2007-2012
 * Project : oecs-g2-common-framework-trunk
 * $Id$
 * $Revision$
 * Last Changed by ZhouXushun at 2011-8-4 下午02:05:36
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * ZhouXushun     2011-8-4        Initailized
 */

package com.jzzms.framework.exception;

import com.jzzms.framework.core.Constants;


/**
 * 系统异常基类
 *
 */
public class BaseAppException extends Exception {
    private static final long serialVersionUID = 2465305628320590970L;
    
    private String errMsg;
    private String errCode;

    public BaseAppException() {
        super();
        
        this.errMsg = Constants.DEFAULT_ERR_MSG;
        this.errCode = Constants.DEFAULT_ERR_CODE;
    }

    public BaseAppException(String errMsg, String errCode, Throwable cause) {
        super(errMsg + errCode, cause);
        
        this.errMsg = errMsg;
        this.errCode = errCode;
    }
    
    public BaseAppException(String errCode, Throwable cause) {
        super(errCode, cause);
        
        this.errMsg = cause.getMessage();
        this.errCode = errCode;
    }

    public BaseAppException(String errMsg, String errCode) {
        super(errMsg + errCode);
        
        this.errMsg = errMsg;
        this.errCode = errCode;
    }

    public BaseAppException(String errMsg) {
        super(errMsg);
        
        this.errMsg = errMsg;
        this.errCode = Constants.DEFAULT_ERR_CODE;
    }
    
    public BaseAppException(Throwable cause) {
        super(cause);
        
        if(cause instanceof BaseAppException){
            BaseRuntimeException e = (BaseRuntimeException)cause;
            this.errCode = e.getErrCode();
            this.errMsg = e.getErrMsg();
        }
        else if(cause instanceof BaseRuntimeException){
            BaseAppException e = (BaseAppException)cause;
            this.errCode = e.getErrCode();
            this.errMsg = e.getErrMsg();
        }
        else{
            this.errMsg = cause.getMessage();
            this.errCode = Constants.DEFAULT_ERR_CODE;
        }
    }
    
    /**
     * Property accessor of errCode
     * @return the errCode
     */
    public String getErrCode() {
        return errCode;
    }
    
    public String getErrMsg(){
        return errMsg;
    }
}
