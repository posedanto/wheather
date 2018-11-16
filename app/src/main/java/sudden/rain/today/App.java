package sudden.rain.today;

import android.app.Application;

import sudden.rain.today.di.AppComponent;
import sudden.rain.today.di.AppModule;
import sudden.rain.today.di.DaggerAppComponent;

public class App extends Application {
    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent
                .builder()
                .appModule(new AppModule(getApplicationContext()))
                .build();

        AppPrefs.initPrefs();
    }

    public static AppComponent getComponent() {
        return component;
    }
}
