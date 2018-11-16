package sudden.rain.today.di;

import android.content.Context;

import com.google.gson.GsonBuilder;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sudden.rain.today.BuildConfig;
import sudden.rain.today.data.memorycache.CacheAutocompleteLocations;
import sudden.rain.today.data.network.IAccuWeatherAPI;
import sudden.rain.today.data.repository.IRepositoryCurrentCondition;
import sudden.rain.today.data.repository.IRepositoryDailyForecasts;
import sudden.rain.today.data.repository.IRepositoryHourlyForecasts;
import sudden.rain.today.data.repository.IRepositoryLocations;
import sudden.rain.today.data.repository.RepositoryCurrentCondition;
import sudden.rain.today.data.repository.RepositoryDailyForecasts;
import sudden.rain.today.data.repository.RepositoryHourlyForecasts;
import sudden.rain.today.data.repository.RepositoryLocations;
import sudden.rain.today.presentation.contract.ContractMain;
import sudden.rain.today.presentation.contract.ContractSearchCity;
import sudden.rain.today.presentation.presenter.PresenterMain;
import sudden.rain.today.presentation.presenter.PresenterSearchCity;

@Module
public class AppModule {

    private WeakReference<Context> refContext;

    public AppModule(Context context) {
        this.refContext = new WeakReference<>(context);
    }

    @Provides
    @Singleton
    ContractMain.Presenter getPresenterMain() {
        return new PresenterMain();
    }

    @Provides
    @Singleton
    ContractSearchCity.Presenter getPresenterSearchCity() {
        return new PresenterSearchCity();
    }

    @Provides
    @Singleton
    IRepositoryCurrentCondition getRepositoryCurrentCondition() {
        return new RepositoryCurrentCondition();
    }

    @Provides
    @Singleton
    IRepositoryDailyForecasts getRepositoryDailyForecasts() {
        return new RepositoryDailyForecasts();
    }

    @Provides
    @Singleton
    IRepositoryHourlyForecasts getRepositoryHourlyForecasts() {
        return new RepositoryHourlyForecasts();
    }

    @Provides
    @Singleton
    IRepositoryLocations getRepositoryLocation() {
        return new RepositoryLocations();
    }

    @Provides
    @Singleton
    CacheAutocompleteLocations getCacheLocations() {
        return new CacheAutocompleteLocations();
    }

    @Provides
    @Singleton
    Context getContext() {
        if (refContext != null && refContext.get() != null)
            return refContext.get();
        else
            return null;
    }

    @Provides
    @Singleton
    IAccuWeatherAPI getAccuWeatherAPI() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .build()
                .create(IAccuWeatherAPI.class);
    }
}
