package com.yy.www.template.http;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Authenticator;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by yangyu on 2017/3/24.
 */

public class appEngine {

    private AppService service;

    private String mToken;

    private static volatile appEngine instance;

    private appEngine() {
    }

    public static appEngine getInstance() {
        if (instance == null) {
            synchronized (appEngine.class) {
                if (instance == null) {
                    instance = new appEngine();
                    return instance;
                }
            }
        }
        return instance;
    }

    public void initOkHttp() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(getHttpLoggingInterceptor())
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .addNetworkInterceptor(mTokenInterceptor)
                .authenticator(mAuthenticator)
                .build();

    }

    /**
     * 设置请求log
     *
     * @return
     */
    private HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }

    Interceptor mTokenInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            if (mToken == null || alreadyHasAuthorizationHeader(originalRequest)) {
                return chain.proceed(originalRequest);
            }
            Request authorised = originalRequest.newBuilder()
                    .header("Authorization", mToken)
                    .build();
            return chain.proceed(authorised);
        }

        private boolean alreadyHasAuthorizationHeader(Request originalRequest) {
            Headers headers = originalRequest.headers();
            headers.get("");
            return true;
        }
    };


    Authenticator mAuthenticator = new Authenticator() {
        @Override
        public Request authenticate(Route route, Response response)
                throws IOException {
            mToken = service.refreshToken();
            return response.request().newBuilder()
                    .addHeader("Authorization", mToken)
                    .build();
        }
    };


}
