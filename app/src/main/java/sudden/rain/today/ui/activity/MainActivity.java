package sudden.rain.today.ui.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.ArrayList;

import javax.inject.Inject;

import sudden.rain.today.R;
import sudden.rain.today.App;
import sudden.rain.today.data.model.CurrentCondition;
import sudden.rain.today.data.model.DailyForecast;
import sudden.rain.today.presentation.contract.ContractMain;
import sudden.rain.today.ui.view.CurrentConditionView;
import sudden.rain.today.ui.view.DailyForecastsView;

public class MainActivity extends AppCompatActivity implements ContractMain.View {

    private static final int PERMISSIONS_REQUEST_ACCESS_LOCATION = 0;

    @Inject
    ContractMain.Presenter presenter;

    private CurrentConditionView currentCondition;

    private DailyForecastsView dailyForecasts;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        App.getComponent().inject(this);

        initView();
    }

    private void initView() {
        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });

        currentCondition = findViewById(R.id.currentCondition);
        dailyForecasts = findViewById(R.id.dailyForecasts);
        progressBar = findViewById(R.id.progressBar);
    }

    @Override
    public void requestLocation() {
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                locationFound(location);
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            public void onProviderEnabled(String provider) {
            }

            public void onProviderDisabled(String provider) {
            }
        };

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_ACCESS_LOCATION);
        } else {
            Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (lastKnownLocation != null) {
                locationFound(lastKnownLocation);
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        }
    }

    private void locationFound(Location location) {
        presenter.onLocationFound(location.getLongitude() + "," + location.getLatitude());
    }

    @Override
    public void updateCurrentCondition(CurrentCondition condition) {
        currentCondition.setCurrentCondition("Moscow", condition);
    }

    @Override
    public void updateDailyForecasts(ArrayList<DailyForecast> forecasts) {
        dailyForecasts.setDailyForecasts(forecasts);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSIONS_REQUEST_ACCESS_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    requestLocation();
                }
        }
    }

    @Override
    public void showForecasts() {
        currentCondition.setVisibility(View.VISIBLE);
        dailyForecasts.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }
}
