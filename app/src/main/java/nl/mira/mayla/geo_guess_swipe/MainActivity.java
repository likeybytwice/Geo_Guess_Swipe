package nl.mira.mayla.geo_guess_swipe;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Local variables
    private List<GeoObject> mGeoObjects = new ArrayList<>();
    private TextView introText;
    private RecyclerView mGeoRecyclerView;
    private GeoObjectAdapter mAdapter = new GeoObjectAdapter(this, mGeoObjects);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize variables
        introText = findViewById(R.id.textView);
        introText.setText("Can you guess if the streetview images are in Europe? Swipe the image left for Europe, right for not Europe");
        mGeoRecyclerView = findViewById(R.id.recyclerView);

        //Add the data to the list
        for (int i = 0; i < GeoObject.PRE_DEFINED_GEO_OBJECT_NAMES.length; i++) {
            mGeoObjects.add(new GeoObject(GeoObject.PRE_DEFINED_GEO_OBJECT_NAMES[i],
                    GeoObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS[i]));

        }

        //Displaying the recyclerView
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        mGeoRecyclerView.setLayoutManager(mLayoutManager);

        //Set adapter
        mGeoRecyclerView.setAdapter(mAdapter);

        ItemTouchHelper.SimpleCallback swipeRight = new ItemTouchHelper.SimpleCallback(0 , ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                //get index matching/corresponding to the selected position
                int position = (viewHolder.getAdapterPosition());

                GeoObject geoObject = mGeoObjects.get(position);
                checkAnswer(geoObject, "right");

                mGeoObjects.remove(position);
                mAdapter.notifyItemRemoved(position);

            }
        };

        ItemTouchHelper.SimpleCallback swipeLeft = new ItemTouchHelper.SimpleCallback(0 , ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                //get index matching/corresponding to the selected position
                int position = (viewHolder.getAdapterPosition());

                GeoObject geoObject = mGeoObjects.get(position);
                checkAnswer(geoObject, "left");

                mGeoObjects.remove(position);
                mAdapter.notifyItemRemoved(position);

            }
        };

        ItemTouchHelper itemTouchSwipeLeft = new ItemTouchHelper(swipeLeft);
        ItemTouchHelper itemTouchSwipeRight = new ItemTouchHelper(swipeRight);

        itemTouchSwipeLeft.attachToRecyclerView(mGeoRecyclerView);
        itemTouchSwipeRight.attachToRecyclerView(mGeoRecyclerView);

    }


    public void checkAnswer(GeoObject geoObject, String swipeDirection){

        String name = geoObject.getGeoName();

        //Remove _ from geo object names
        String answer = name.split("_")[0];

        //Check answers via object names
        if (answer.equalsIgnoreCase("yes") & swipeDirection.equalsIgnoreCase("left") |
                (answer.equalsIgnoreCase("no") & swipeDirection.equalsIgnoreCase("right"))){
            Snackbar.make(getCurrentFocus(),"You were correct!",Snackbar.LENGTH_LONG).show();

        }else{
            Snackbar.make(getCurrentFocus(),"You were wrong. . .",Snackbar.LENGTH_LONG).show();
        }

    }
}
