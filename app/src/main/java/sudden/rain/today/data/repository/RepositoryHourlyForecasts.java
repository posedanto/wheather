package sudden.rain.today.data.repository;

import javax.inject.Inject;

import sudden.rain.today.data.network.IAccuWeatherAPI;

public class RepositoryHourlyForecasts implements IRepositoryHourlyForecasts {

    @Inject
    IAccuWeatherAPI weatherAPI;
}
