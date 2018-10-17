package nl.mira.mayla.geo_guess_swipe;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class GeoObjectViewHolder extends RecyclerView.ViewHolder {
    //ViewHolder displays all the row items that are in the RecyclerView

        public ImageView geoImage;
        public View view;


        public GeoObjectViewHolder(View itemView) {
            super(itemView);
            this.geoImage = itemView.findViewById(R.id.geoImageView);
            this.view = itemView;

        }

}
