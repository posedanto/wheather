package sudden.rain.today.presentation.contract;

import java.util.ArrayList;

import sudden.rain.today.data.model.Location;

public interface ContractSearchCity {

    interface View {
        void updateLocations(ArrayList<Location> locations);
    }

    interface Presenter extends ContractBasePresenter<View> {
        void onSearchTextChange(String query);

        void onSearchSubmit(String query);
    }
}
