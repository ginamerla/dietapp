package com.tortu.api.configuration;

import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Service
public class TokenServiceGenerator {

    private static final String BASE_URL = "http://localhost:8887/auth-svc/api/v1/auth/";
    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).addConverterFactory(ScalarsConverterFactory.create());
    private static Retrofit retrofit = builder.build();
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
    // how to use this class: AuthTokenService service  = TokenServiceGenerator.createService(AuthTokenService.class);
}
