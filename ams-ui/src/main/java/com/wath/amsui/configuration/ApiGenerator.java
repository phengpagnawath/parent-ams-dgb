package com.wath.amsui.configuration;

import com.wath.amsui.retrofit.interceptor.AuthenticationInterceptor;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import org.springframework.util.StringUtils;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiGenerator {

    private static String BASE_URL="http://localhost:8080/api/v1/";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    public static <S> S createApi(Class<S> apiClass) {
        return createApi(apiClass, null, null);
    }

    public static <S> S createApi(
            Class<S> serviceClass, String username, String password) {
        if (!StringUtils.isEmpty(username)
                && !StringUtils.isEmpty(password)) {
            String authToken = Credentials.basic(username, password);
            return createApi(serviceClass, authToken);
        }

        return createApi(serviceClass, null);
    }

    public static <S> S createApi(Class<S> apiClass, final String authToken) {
        if (!StringUtils.isEmpty(authToken)) {
            AuthenticationInterceptor interceptor =
                    new AuthenticationInterceptor(authToken);

            if (!httpClient.interceptors().contains(interceptor)) {
                httpClient.addInterceptor(interceptor);

                builder.client(httpClient.build());
                builder.client(httpClient.build());
                retrofit = builder.build();
            }
        }

        return retrofit.create(apiClass);
    }

}
