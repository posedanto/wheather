package sudden.rain.today.presentation.presenter;

import java.util.ArrayList;

import javax.inject.Inject;

import sudden.rain.today.App;
import sudden.rain.today.data.model.Location;
import sudden.rain.today.data.repository.IRepositoryLocations;
import sudden.rain.today.data.repository.callback.IRepositoryLocationsCallback;
import sudden.rain.today.presentation.contract.ContractSearchCity;

public class PresenterSearchCity extends PresenterBase<ContractSearchCity.View> implements ContractSearchCity.Presenter {

    @Inject
    IRepositoryLocations repositoryLocation;

    public PresenterSearchCity() {
        App.getComponent().inject(this);
    }

    @Override
    public void onSearchTextChange(String query) {
        if (query.length() > 2) {
            repositoryLocation.requestLocationsByAutocomplete(query, new RepositoryLocationCallback());
        }
    }

    @Override
    public void onSearchSubmit(String query) {
        repositoryLocation.requestLocationsByCityName(query, new RepositoryLocationCallback());
    }

    private class RepositoryLocationCallback implements IRepositoryLocationsCallback {
        @Override
        public void onLocationsLoaded(ArrayList<Location> locations) {
            getView().updateLocations(locations);
        }

        @Override
        public void onFailure(Throwable throwable) {

        }
    }
}
