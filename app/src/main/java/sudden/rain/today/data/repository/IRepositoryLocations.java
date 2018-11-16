package sudden.rain.today.data.repository;

import sudden.rain.today.data.repository.callback.IRepositoryLocationCallback;
import sudden.rain.today.data.repository.callback.IRepositoryLocationsCallback;

public interface IRepositoryLocations {

    void requestLocationByGeoposition(String geoposition, IRepositoryLocationCallback callback);

    void requestLocationsByAutocomplete(String query, IRepositoryLocationsCallback callback);

    void requestLocationsByCityName(String cityName, IRepositoryLocationsCallback callback);
}
