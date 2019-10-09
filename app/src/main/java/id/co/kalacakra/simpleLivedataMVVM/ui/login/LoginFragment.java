package id.co.kalacakra.simpleLivedataMVVM.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import java.util.Objects;

import javax.inject.Inject;

import id.co.kalacakra.simpleLivedataMVVM.MainActivity;
import id.co.kalacakra.simpleLivedataMVVM.R;
import id.co.kalacakra.simpleLivedataMVVM.binding.FragmentDataBindingComponent;
import id.co.kalacakra.simpleLivedataMVVM.databinding.LoginFragmentBinding;
import id.co.kalacakra.simpleLivedataMVVM.di.Injectable;
import id.co.kalacakra.simpleLivedataMVVM.util.AutoClearedValue;
import id.co.kalacakra.simpleLivedataMVVM.util.NavigationController;

public class LoginFragment extends Fragment implements Injectable, MainActivity.OnBackPressedListner {

    private LoginViewModel mViewModel;
    @Inject
    NavigationController navigationController;

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    androidx.databinding.DataBindingComponent dataBindingComponent = new FragmentDataBindingComponent(this);
    AutoClearedValue<LoginFragmentBinding> binding;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        LoginFragmentBinding loginFragmentBinding = DataBindingUtil.inflate(inflater,
                R.layout.login_fragment, container, false, dataBindingComponent);
        binding = new AutoClearedValue<>(this, loginFragmentBinding);

        return loginFragmentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel.class);
        // TODO: Use the ViewModel

        initComponent();
        initData();
    }

    private void initData() {
        mViewModel.getRegisterResponseSingleLiveEvent().observe(getViewLifecycleOwner(), result->{
            if(result != null){
                // TODO : Do something
            }
        });
    }

    private void initComponent() {

        binding.get().btnLogin.setOnClickListener(v ->{
            String token = "";
            String email = binding.get().getUserId();
            getbankList(token, email);
        });
    }

    private void getbankList(String token, String email) {
        mViewModel.getLogin(token, email);
    }

    @Override
    public boolean onBackPressed() {
        Objects.requireNonNull(getActivity()).finish();
        return true;
    }
}
