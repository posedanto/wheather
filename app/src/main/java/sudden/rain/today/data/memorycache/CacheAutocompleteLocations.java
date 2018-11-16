package sudden.rain.today.data.memorycache;

import java.util.ArrayList;
import java.util.HashMap;

import sudden.rain.today.data.model.Location;

public class CacheAutocompleteLocations {
    private HashMap<String, ArrayList<Location>> data;

    public ArrayList<Location> getLocation(String key) {
        return data != null ? data.get(key) : null;
    }

    public void addData(String key, ArrayList<Location> locations) {
        if (key == null || locations == null)
            return;

        if (data == null)
            data = new HashMap<>();

        data.put(key, locations);
    }

    public void resetCache() {
        data = null;
    }
}
