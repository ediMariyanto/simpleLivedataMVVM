package id.co.kalacakra.simpleLivedataMVVM.api;

import androidx.lifecycle.LiveData;

import java.util.List;

import id.co.kalacakra.simpleLivedataMVVM.vo.BankResponse;
import id.co.kalacakra.simpleLivedataMVVM.vo.userManagement.RegisterRequest;
import id.co.kalacakra.simpleLivedataMVVM.vo.userManagement.RegisterResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface AppService {
    @GET("/api/banks")
    LiveData<ApiResponse<List<BankResponse>>> getBankList(@Header("Authorization") String token);

    @POST("/api/create-reg-otp")
    Call<RegisterResponse> doRegisterUser(@Header("Authorization") String token, @Body RegisterRequest registerRequest);

}
