//package com.tortu.api.services.impl;
//
//import com.tortu.api.configuration.TokenServiceGenerator;
//import com.tortu.api.models.Token;
//import com.tortu.api.services.AuthTokenService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import retrofit2.Call;
//import retrofit2.Response;
//
//import java.io.IOException;
//
///**
// * Implementation for AuthToken service
// */
//@Service
//public class AuthTokenServiceImpl implements AuthTokenService {
//
//    @Autowired
//    AuthTokenService service = TokenServiceGenerator.createService(AuthTokenService.class);
//
//    @Override
//    public void validateToken(String token) {
//        service.validateToken(token);
//    }
//
//    @Override
//    public Call<Token> generateToken() throws IOException {
////        Call<Token> callSync = service.generateToken();
////        Response<Token> resp = callSync.execute();
////        Token token = resp.body();
////        return token;
//    }
//
//    @Override
//    public Call<String> refreshToken(String token) {
//        return service.refreshToken(token);
//    }
//}
