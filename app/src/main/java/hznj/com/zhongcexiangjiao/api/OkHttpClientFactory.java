package hznj.com.zhongcexiangjiao.api;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Des        :https配置
 */

public class OkHttpClientFactory {

    private static OkHttpClient defaultClient;

    public static OkHttpClient getDefaultOkClient() {
        SSLSocketFactory socketFactory = null;
        if (defaultClient == null) {
            synchronized (OkHttpClientFactory.class) {
                if (defaultClient == null) {
                    final TrustManager[] trustAllCerts = new TrustManager[]{
                            new X509TrustManager() {
                                @Override
                                public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                                }

                                @Override
                                public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                                }

                                @Override
                                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                                    return new java.security.cert.X509Certificate[]{};
                                }
                            }
                    };

                    try {
                        // Install the all-trusting trust manager
                        SSLContext sslContext = SSLContext.getInstance("SSL");
                        sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
                        socketFactory = sslContext.getSocketFactory();
                    } catch (KeyManagementException e) {
                        e.printStackTrace();
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }

                 /*   // log interceptor
                    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);*/

                    defaultClient = new OkHttpClient.Builder()
                            .connectTimeout(15, TimeUnit.SECONDS)    // 连接超时
                            .readTimeout(15, TimeUnit.SECONDS)       // 读取超时
                            .writeTimeout(15, TimeUnit.SECONDS)      // 写入超时
                            .retryOnConnectionFailure(true)         // 连接重试
                            // TODO: 2017/3/9 这个暂时不用 
                          /*  .addInterceptor(new UnifiedRequestHead())*/
                          //  .addInterceptor(httpLoggingInterceptor)
                            .sslSocketFactory(socketFactory)
                            .hostnameVerifier(new HostnameVerifier() {
                                @Override
                                public boolean verify(String hostname, SSLSession session) {
                                    return true;
                                }
                            })
                            .build();
                }
            }
        }
        return defaultClient;
    }
}
