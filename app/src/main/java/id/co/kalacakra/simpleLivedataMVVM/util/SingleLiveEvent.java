package id.co.kalacakra.simpleLivedataMVVM.util;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.atomic.AtomicBoolean;

import timber.log.Timber;

public class SingleLiveEvent<T> extends MutableLiveData<T> {

//    private static final String TAG = "SingleLiveEvent";

    private final AtomicBoolean mPending = new AtomicBoolean(false);

    @MainThread
    public void observe(@NotNull LifecycleOwner owner, @NotNull final Observer<? super T> observer) {

        if (hasActiveObservers()) {
            Timber.w("Multiple observers registered but only one will be notified of changes.");
        }

        super.observe(owner, t -> {
            if (mPending.compareAndSet(true, false)) {
                observer.onChanged(t);
            }
        });
    }

    @MainThread
    public void setValue(@Nullable T t) {
        mPending.set(true);
        super.setValue(t);
    }

    @MainThread
    public void call() {
        setValue(null);
    }
}




