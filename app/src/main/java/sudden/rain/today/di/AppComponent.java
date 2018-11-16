package sudden.rain.today.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import sudden.rain.today.data.repository.RepositoryCurrentCondition;
import sudden.rain.today.data.repository.RepositoryDailyForecasts;
import sudden.rain.today.data.repository.RepositoryHourlyForecasts;
import sudden.rain.today.data.repository.RepositoryLocations;
import sudden.rain.today.presentation.presenter.PresenterMain;
import sudden.rain.today.presentation.presenter.PresenterSearchCity;
import sudden.rain.today.ui.activity.MainActivity;
import sudden.rain.today.ui.activity.SearchCityActivity;

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    Context getContext();

    void inject(MainActivity activity);

    void inject(SearchCityActivity activity);

    void inject(PresenterMain presenter);

    void inject(PresenterSearchCity presenter);

    void inject(RepositoryCurrentCondition repository);

    void inject(RepositoryDailyForecasts repository);

    void inject(RepositoryHourlyForecasts repository);

    void inject(RepositoryLocations repository);
}
