package com.jzzms.framework.test;

import java.util.Date;

import org.springframework.security.web.util.UrlUtils;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean ret =UrlUtils.isValidRedirectUrl("/index.jsp?error=true");
		System.out.println(ret);
		
		System.out.println(String.valueOf(new Date().getTime()));
	}

}
