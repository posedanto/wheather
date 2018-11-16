package sudden.rain.today.data.model;

import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("Key")
    private String key;

    @SerializedName("Type")
    private String type;

    @SerializedName("LocalizedName")
    private String localizedName;

    @SerializedName("EnglishName")
    private String englishName;

    @SerializedName("Country")
    private SubLocation country;

    @SerializedName("AdministrativeArea")
    private SubLocation administrativeArea;

    public String getKey() {
        return key;
    }

    public String getType() {
        return type;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public SubLocation getCountry() {
        return country;
    }

    public SubLocation getAdministrativeArea() {
        return administrativeArea;
    }

    public static class SubLocation {

        @SerializedName("ID")
        private String id;

        @SerializedName("LocalizedName")
        private String localizedName;

        @SerializedName("EnglishName")
        private String englishName;

        public String getId() {
            return id;
        }

        public String getLocalizedName() {
            return localizedName;
        }

        public String getEnglishName() {
            return englishName;
        }
    }
}
