/**
 * 
 */
package com.pujjr.pcci.common.qhcs.utils;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * 我们信任任何SERVER 证书
 * 
 * @author 唐应泉(0755-22625539)
 * 
 */
public class TrustAnyTrustManager implements X509TrustManager {

	public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
	}

	public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

	}

	public X509Certificate[] getAcceptedIssuers() {
		return new X509Certificate[] {};
	}

}
