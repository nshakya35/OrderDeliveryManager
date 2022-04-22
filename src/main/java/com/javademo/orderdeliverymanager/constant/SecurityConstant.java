package com.javademo.orderdeliverymanager.constant;

public class SecurityConstant {

	public static final String SECRET = "!1Qwerty1";
	public static final long EXPIRATION_TIME = 432_000_000;// 5 days in ms
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String[] PUBLIC_URLS = { "/login" };
	public static final String ROLES = "roles";

	public static final String ACCESS_TOKEN = "access_token";
	public static final String REFRESH_TOKEN = "refresh_token";
}
