package sudden.rain.today.data.repository.callback;

import java.util.ArrayList;

import sudden.rain.today.data.model.Location;

public interface IRepositoryLocationsCallback {
    void onLocationsLoaded(ArrayList<Location> locations);

    void onFailure(Throwable throwable);
}
