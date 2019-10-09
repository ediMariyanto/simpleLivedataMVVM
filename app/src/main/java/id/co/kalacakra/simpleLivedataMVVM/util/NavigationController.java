package id.co.kalacakra.simpleLivedataMVVM.util;

import androidx.fragment.app.FragmentManager;

import javax.inject.Inject;

import id.co.kalacakra.simpleLivedataMVVM.MainActivity;
import id.co.kalacakra.simpleLivedataMVVM.R;
import id.co.kalacakra.simpleLivedataMVVM.ui.login.LoginFragment;


public class NavigationController {

    private final int containerId;
    private final FragmentManager fragmentManager;

    @Inject
    public NavigationController(MainActivity mainActivity) {
        this.containerId = R.id.frml_container_login;
        this.fragmentManager = mainActivity.getSupportFragmentManager();
    }

    public void navigateLogin() {
        LoginFragment loginFragment = LoginFragment.newInstance();
        fragmentManager.beginTransaction()
                .replace(containerId, loginFragment)
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }


}
