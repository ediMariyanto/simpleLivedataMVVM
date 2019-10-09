package id.co.kalacakra.simpleLivedataMVVM;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import id.co.kalacakra.simpleLivedataMVVM.di.Injectable;
import id.co.kalacakra.simpleLivedataMVVM.util.NavigationController;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector,
        Injectable{

    @Inject
    NavigationController navigationController;
    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        navigationController.navigateLogin();

        //getting bottom navigation view and attaching the listener
//        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
//        navigation.setOnNavigationItemSelectedListener(this);
    }


//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.navigation_profile:
//                return navigationController.navigateLastPProfileFragment();
//
//            case R.id.navigation_mayaccount:
//                return navigationController.navigateAccountFragment();
//
//            case R.id.navigation_dashboard:
//                return navigationController.navigateDashboardFragment();
//
//            case R.id.navigation_disbursement:
//                return navigationController.navigateDisbursementFragment();
//
//            case R.id.navigation_person_plane:
//                return navigationController.navigatePensionPlanFragment();
//
//        }
//        return false;
//    }


//    private boolean loadFragment(Fragment fragment) {
//        //switching fragment
//        if (fragment != null) {
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.frml_container_login, fragment)
//                    .commit();
//            return true;
//        }
//        return false;
//    }


    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frml_container_login);
        if (!(fragment instanceof OnBackPressedListner) || !((OnBackPressedListner) fragment).onBackPressed()) {
            super.onBackPressed();
        }
    }

    public interface OnBackPressedListner {
        boolean onBackPressed();
    }
}
