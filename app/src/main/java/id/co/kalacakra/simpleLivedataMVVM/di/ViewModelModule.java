package id.co.kalacakra.simpleLivedataMVVM.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import id.co.kalacakra.simpleLivedataMVVM.ui.login.LoginViewModel;
import id.co.kalacakra.simpleLivedataMVVM.ui.main.MainViewModel;
import id.co.kalacakra.simpleLivedataMVVM.viewModel.DapenViewModelFactory;

@Module
abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindMainActivityViewModel(MainViewModel mainViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    abstract ViewModel bindLoginFragmentViewModel(LoginViewModel loginViewModel);


    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(DapenViewModelFactory factory);
}
