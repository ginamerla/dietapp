package com.tortu.api.configuration;

import com.tortu.api.models.Token;
import com.tortu.api.services.AuthTokenService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import retrofit2.Call;
import retrofit2.Response;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
@Log4j2
@Provider
@PreMatching
@Priority(2)
public class AuthorizationFilter implements ContainerRequestFilter{

    public AuthTokenService authTokenService = TokenServiceGenerator.createService(AuthTokenService.class);

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        String tokenId = containerRequestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (tokenId == null){
            log.error("No header found");
            throw new NotAuthorizedException("Bearer");
        }
        Call<Token> callSync = authTokenService.validateToken(tokenId);
        Response<Token> callResponse = callSync.execute();
        if(callResponse.code()!=200){
            log.error("Token invalid");
            throw new NotAuthorizedException("Bearer error=\"invalid_token\"");
        }
    }
}
