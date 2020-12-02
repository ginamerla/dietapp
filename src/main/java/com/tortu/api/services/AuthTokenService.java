package com.tortu.api.services;

import com.tortu.api.models.Token;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import javax.ws.rs.PathParam;
import java.io.IOException;

/**
 * Interface for token service
 */
@Service
public interface AuthTokenService {
    /**
     * Makes the call to validate the tokenId
     * @param tokenId to validate
     */
    @GET("verify/{tokenId}")
    void validateToken(@Path("tokenId") String tokenId);

    /**
     * Makes the call to generate a new token
     * @return Token generated
     */
    @GET("new")
    Call<Token> generateToken() throws IOException;

    /**
     * Makes the call to refresh the token
     * @param tokenId to refresh
     * @return token updated
     */
    @PUT("update/{tokenId}")
    Call<Token> refreshToken(@Path("tokenId") String tokenId);

    /**
     * Makes the call to get the token
     * @param tokenId
     * @return token object found
     */
    @GET("get/{tokenid}")
    Call<Token> getToken(@PathParam("tokenid")String tokenId);
}
