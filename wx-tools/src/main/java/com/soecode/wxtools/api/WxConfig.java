package com.soecode.wxtools.api;

import com.soecode.wxtools.bean.WxAccessToken;

public class WxConfig {

	private volatile String appId;
	private volatile String appSecret;
	private volatile String token;
	private volatile String aesKey;
	private volatile String mchId;
	private volatile String apiKey;

	private volatile String accessToken;
	private volatile long expiresTime;
	private volatile String jsapiTicket;
	private volatile long jsapiTicketExpiresTime;


	public WxConfig(String appId, String appSecret) {
        this(appId, appSecret, null);
    }

    public WxConfig(String appId, String appSecret, String token) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.token = token;
    }

    public WxConfig(String appId, String appSecret, String token, String aesKey, String mchId, String apiKey) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.token = token;
        this.aesKey = aesKey;
        this.mchId = mchId;
        this.apiKey = apiKey;
    }
	
	public String getAccessToken() {
		return accessToken;
	}
	
	public boolean isAccessTokenExpired() {
		return System.currentTimeMillis() > this.expiresTime;
	}

	public void expireAccessToken() {
		this.expiresTime = 0;
	}

	public synchronized void updateAccessToken(WxAccessToken accessToken) {
		updateAccessToken(accessToken.getAccess_token(), accessToken.getExpires_in());
	}

	public synchronized void updateAccessToken(String accessToken, int expiresInSeconds) {
		this.accessToken = accessToken;
		this.expiresTime = System.currentTimeMillis() + (expiresInSeconds - 200) * 1000l;
	}

	public String getJsapiTicket() {
		return jsapiTicket;
	}

	public void setJsapiTicket(String jsapiTicket) {
		this.jsapiTicket = jsapiTicket;
	}

	public long getJsapiTicketExpiresTime() {
		return jsapiTicketExpiresTime;
	}

	public void setJsapiTicketExpiresTime(long jsapiTicketExpiresTime) {
		this.jsapiTicketExpiresTime = jsapiTicketExpiresTime;
	}

	public boolean isJsapiTicketExpired() {
		return System.currentTimeMillis() > this.jsapiTicketExpiresTime;
	}

	public synchronized void updateJsapiTicket(String jsapiTicket, int expiresInSeconds) {
		this.jsapiTicket = jsapiTicket;
		this.jsapiTicketExpiresTime = System.currentTimeMillis() + (expiresInSeconds - 200) * 1000l;
	}
	
	public void expireJsapiTicket() {
		this.jsapiTicketExpiresTime = 0;
	}

	public String getAppId() {
		return appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public String getToken() {
		return token;
	}
	
	public String getAesKey() {
		return aesKey;
	}
	
	public String getMchId() {
		return mchId;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	@Override
	public String toString() {
		return "WxConfig [appId=" + appId + ", appSecret=" + appSecret + ", token=" + token + ", aesKey=" + aesKey
				+ ", mchId=" + mchId + ", apiKey=" + apiKey + ", accessToken=" + accessToken + ", expiresTime="
				+ expiresTime + ", jsapiTicket=" + jsapiTicket + ", jsapiTicketExpiresTime=" + jsapiTicketExpiresTime
				+ "]";
	}

	
}
