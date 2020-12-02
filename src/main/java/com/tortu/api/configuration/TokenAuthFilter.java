package com.tortu.api.configuration;

import com.tortu.api.models.Token;
import com.tortu.api.services.AuthTokenService;
//import com.tortu.api.services.impl.AuthTokenServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import retrofit2.Call;
import retrofit2.Response;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Log4j2
public class TokenAuthFilter implements Filter {

    public static final String TOKEN_HEADER = "AUTH";
    Call<Token> callSync;
    Response<Token> resp;
    @Autowired
    public AuthTokenService authTokenService = TokenServiceGenerator.createService(AuthTokenService.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        log.info("Making the authentication call...");

        if(request.getHeader(TOKEN_HEADER)==null){
            log.error("Token Header not found");
            callSync = authTokenService.generateToken();
            resp = callSync.execute();
        }else{
            String tokenId = request.getHeader(TOKEN_HEADER);
            log.info("Validating header:{}", tokenId);
            try{
                authTokenService.validateToken(tokenId);
                resp = callSync.execute();
            }catch (Error e){
                log.error("Token not valid");
                authTokenService.refreshToken(tokenId);
                callSync = authTokenService.refreshToken(tokenId);
            }

        }


        try {

            log.info("URL: {}",resp.raw().request().url());
            Token token = resp.body();


            if(token!=null){
                log.info("token id:{}",token.getTokenId());
                response.setHeader(TOKEN_HEADER, token.getTokenId());
            }else{
                log.error("Token is null");
            }
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (RuntimeException e) {
            log.info("Authentication Error: {} | Message:{}", e.getStackTrace(), e.getMessage());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @Override
    public void destroy() {

    }

    public void createToken(){

    }
}
