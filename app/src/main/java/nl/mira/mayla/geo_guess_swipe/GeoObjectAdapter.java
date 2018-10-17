package nl.mira.mayla.geo_guess_swipe;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class GeoObjectAdapter extends RecyclerView.Adapter<GeoObjectViewHolder> {


    private Context context;
    public List<GeoObject> listGeoObject;

    public GeoObjectAdapter(Context context, List<GeoObject> listGeoObject) {
        this.context = context;
        this.listGeoObject = listGeoObject;
    }

    //The next step is to inflate our layout to display the row items in the RecylcerView
    @Override
    public GeoObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cell, parent, false);
        return new GeoObjectViewHolder(view);
    }

    //Bind  data to the viewHolders
    @Override
    public void onBindViewHolder(final GeoObjectViewHolder holder, final int position) {

        // Gets a single item in the list from its position
        final GeoObject geoObject = listGeoObject.get(position);

        // The holder argument is used to reference the views inside the viewHolder
        // Populate the views with the data from the list
        holder.geoImage.setImageResource(geoObject.getmGeoImageName());

    }

    @Override
    public int getItemCount() {
        return listGeoObject.size();
    }

}
