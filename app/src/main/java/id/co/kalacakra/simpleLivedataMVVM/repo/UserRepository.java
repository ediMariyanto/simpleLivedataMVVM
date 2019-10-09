package id.co.kalacakra.simpleLivedataMVVM.repo;

import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;
import javax.inject.Singleton;

import id.co.kalacakra.simpleLivedataMVVM.AppExecutors;
import id.co.kalacakra.simpleLivedataMVVM.api.AppService;
import id.co.kalacakra.simpleLivedataMVVM.util.SingleLiveEvent;
import id.co.kalacakra.simpleLivedataMVVM.vo.userManagement.RegisterRequest;
import id.co.kalacakra.simpleLivedataMVVM.vo.userManagement.RegisterResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class UserRepository {

    private final AppService appService;
    private final AppExecutors appExecutors;

    @Inject
    public UserRepository(AppExecutors appExecutors, AppService appService) {
        this.appService = appService;
        this.appExecutors = appExecutors;
    }


    public SingleLiveEvent<RegisterResponse> logon(String token, String email) {
        SingleLiveEvent<RegisterResponse> registerResponseMutableLiveData = new SingleLiveEvent<>();

        appService.doRegisterUser(token, new RegisterRequest(email)).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful()) {
                    registerResponseMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                registerResponseMutableLiveData.setValue(null);
            }
        });
        return registerResponseMutableLiveData;
    }

}
