package id.co.kalacakra.simpleLivedataMVVM.ui.main;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import id.co.kalacakra.simpleLivedataMVVM.R;
import id.co.kalacakra.simpleLivedataMVVM.binding.FragmentDataBindingComponent;
import id.co.kalacakra.simpleLivedataMVVM.databinding.MainFragmentBinding;
import id.co.kalacakra.simpleLivedataMVVM.di.Injectable;
import id.co.kalacakra.simpleLivedataMVVM.util.AutoClearedValue;

public class MainFragment extends Fragment implements Injectable {

    private MainViewModel mViewModel;
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    androidx.databinding.DataBindingComponent dataBindingComponent = new FragmentDataBindingComponent(this);
    AutoClearedValue<MainFragmentBinding> binding;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        MainFragmentBinding mainFragmentBinding = DataBindingUtil.inflate(inflater,
                R.layout.main_fragment, container, false, dataBindingComponent);
        binding = new AutoClearedValue<>(this, mainFragmentBinding);

        return mainFragmentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);

    }

}
