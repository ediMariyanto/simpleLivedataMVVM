package id.co.kalacakra.simpleLivedataMVVM.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import id.co.kalacakra.simpleLivedataMVVM.MainActivity;

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity contributeMainActivity();

}
