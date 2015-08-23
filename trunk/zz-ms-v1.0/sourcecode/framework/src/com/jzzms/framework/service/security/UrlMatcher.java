package com.jzzms.framework.service.security;

/**
 * 这个接口是以前spring版本中的，现在的spring版本中不存在，由于项目需要且使用方便，故加入到项目当中
 * @author jason
 *
 */
public abstract interface UrlMatcher {
	public abstract Object compile(String paramString);

	public abstract boolean pathMatchesUrl(Object paramObject, String paramString);

	public abstract String getUniversalMatchPattern();

	public abstract boolean requiresLowerCaseUrl();
}
