package id.co.kalacakra.simpleLivedataMVVM.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import id.co.kalacakra.simpleLivedataMVVM.SimpleLivedataMVVMApp;

@Singleton
@Component(modules = {AndroidInjectionModule.class,
        AppModule.class,
        MainActivityModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(SimpleLivedataMVVMApp simpleLivedataMVVMApp);
}