package id.co.kalacakra.simpleLivedataMVVM.ui.login;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import id.co.kalacakra.simpleLivedataMVVM.repo.UserRepository;
import id.co.kalacakra.simpleLivedataMVVM.util.SingleLiveEvent;
import id.co.kalacakra.simpleLivedataMVVM.vo.userManagement.RegisterResponse;

public class LoginViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private final UserRepository userRepository;
    private SingleLiveEvent<RegisterResponse> registerResponseSingleLiveEvent = new SingleLiveEvent<>();
//    private final LiveData<Resource<List<BankResponse>>> bankListLiveData;

    @Inject
    public LoginViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
//        this.bankListLiveData = Transformations.switchMap(BankResponse, )
    }

    public SingleLiveEvent<RegisterResponse> getRegisterResponseSingleLiveEvent() {
        return registerResponseSingleLiveEvent;
    }


    void getLogin(String token, String email) {
        registerResponseSingleLiveEvent = userRepository.logon(token, email);

    }


}
