package sudden.rain.today.data.repository.callback;

import sudden.rain.today.data.model.Location;

public interface IRepositoryLocationCallback {
    void onLocationLoaded(Location location);

    void onFailure(Throwable throwable);
}
