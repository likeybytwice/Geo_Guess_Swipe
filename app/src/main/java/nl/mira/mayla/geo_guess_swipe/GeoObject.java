package nl.mira.mayla.geo_guess_swipe;

public class GeoObject {
    //data model for each object that will be shown in the RecyclerView

    private String mGeoName;
    private int mGeoImageName;


    public GeoObject(String mGeoName, int mGeoImageName) {
        this.mGeoName = mGeoName;
        this.mGeoImageName = mGeoImageName;

    }


    public String getGeoName() {
        return mGeoName;

    }

    public void setGeoName(String mGeoName) {
        this.mGeoName = mGeoName;

    }

    public int getmGeoImageName() {
        return mGeoImageName;

    }

    public void setGeoImageName(int mGeoImageName) {
        this.mGeoImageName = mGeoImageName;

    }

    public static final String[] PRE_DEFINED_GEO_OBJECT_NAMES = {
            "yes_denmark",
            "no_canada",
            "no_bangladesh",
            "yes_kazachstan",
            "no_colombia",
            "yes_poland",
            "yes_malta",
            "no_thailand",
    };


    public static final int[] PRE_DEFINED_GEO_OBJECT_IMAGE_IDS = {
            R.drawable.img1_yes_denmark,
            R.drawable.img2_no_canada,
            R.drawable.img3_no_bangladesh,
            R.drawable.img4_yes_kazachstan,
            R.drawable.img5_no_colombia,
            R.drawable.img6_yes_poland,
            R.drawable.img7_yes_malta,
            R.drawable.img8_no_thailand
    };
}
