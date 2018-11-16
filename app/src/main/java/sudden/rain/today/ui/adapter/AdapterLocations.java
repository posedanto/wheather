package sudden.rain.today.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import sudden.rain.today.R;
import sudden.rain.today.data.model.Location;

public class AdapterLocations extends RecyclerView.Adapter<AdapterLocations.ViewHolderLocations> {

    private ArrayList<Location> locations = new ArrayList<>();

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    @NonNull
    @Override
    public ViewHolderLocations onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_location, viewGroup, false);
        return new ViewHolderLocations(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderLocations viewHolderLocations, int position) {
        viewHolderLocations.onBind(locations.get(position));
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    class ViewHolderLocations extends RecyclerView.ViewHolder {

        private TextView city, administrativeArea, country;

        public ViewHolderLocations(@NonNull View itemView) {
            super(itemView);
            city = itemView.findViewById(R.id.city);
            administrativeArea = itemView.findViewById(R.id.administrativeArea);
            country = itemView.findViewById(R.id.country);
        }

        public void onBind(Location location) {
            city.setText(location.getLocalizedName());
            administrativeArea.setText(location.getAdministrativeArea().getLocalizedName());
            country.setText(location.getCountry().getLocalizedName());
        }
    }
}
