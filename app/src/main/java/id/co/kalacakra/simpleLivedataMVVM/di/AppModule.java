package id.co.kalacakra.simpleLivedataMVVM.di;

import android.app.Application;

import androidx.room.Room;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import id.co.kalacakra.simpleLivedataMVVM.api.AppService;
import id.co.kalacakra.simpleLivedataMVVM.db.AppDb;
import id.co.kalacakra.simpleLivedataMVVM.util.Constant;
import id.co.kalacakra.simpleLivedataMVVM.util.LiveDataCallAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
class AppModule {

    @Singleton
    @Provides
    AppService providerAppService() {

        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        okHttpBuilder.connectTimeout(30, TimeUnit.SECONDS);
        okHttpBuilder.readTimeout(30, TimeUnit.SECONDS);
        okHttpBuilder.writeTimeout(30, TimeUnit.SECONDS);
        okHttpBuilder.addInterceptor(chain -> {
            Request request = chain.request();
            Request.Builder newRequest = request.newBuilder(); //.addHeader("Authorization", Constant.API_TYPE + " " + token);

            return chain.proceed(newRequest.build());
        });

        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(okHttpBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .build()
                .create(AppService.class);
    }

    @Singleton
    @Provides
    AppDb providerDb(Application application){
        return Room.databaseBuilder(application, AppDb.class, "app.db").build();
    }

}
