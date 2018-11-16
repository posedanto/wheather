package sudden.rain.today.data.network;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import sudden.rain.today.data.network.response.ResponseCurrentCondition;
import sudden.rain.today.data.network.response.ResponseDailyForecasts;
import sudden.rain.today.data.model.Location;
import sudden.rain.today.data.network.response.ResponseHourlyForecasts;

public interface IAccuWeatherAPI {

    @GET("locations/v1/cities/geoposition/search")
    Call<Location> getLocationByGeoposition(
            @Query("apikey") String apiKey,
            @Query("q") String geoposition,
            @Query("language") String lang);

    @GET("locations/v1/cities/autocomplete")
    Call<ArrayList<Location>> getLocationsByAutocomplete(
            @Query("apikey") String apiKey,
            @Query("q") String query,
            @Query("language") String lang);

    @GET("locations/v1/cities/search")
    Call<ArrayList<Location>> getLocationsByCityName(
            @Query("apikey") String apiKey,
            @Query("q") String cityName,
            @Query("language") String lang);

    @GET("currentconditions/v1/{location}")
    Call<ArrayList<ResponseCurrentCondition>> getCurrentCondition(
            @Path("location") String location,
            @Query("apikey") String apiKey,
            @Query("language") String lang,
            @Query("details") boolean details);

    @GET("forecasts/v1/daily/5day/{location}")
    Call<ResponseDailyForecasts> getDailyForecast(
            @Path("location") String location,
            @Query("apikey") String apiKey,
            @Query("language") String lang,
            @Query("details") boolean details,
            @Query("metric") boolean metric);

    @GET("forecasts/v1/hourly/12hour/{location}")
    Call<ResponseHourlyForecasts> getHourlyForecast(
            @Path("location") String location,
            @Query("apikey") String apiKey,
            @Query("language") String lang,
            @Query("details") boolean details);
}
