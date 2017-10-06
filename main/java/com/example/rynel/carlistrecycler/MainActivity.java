package com.example.rynel.carlistrecycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.example.rynel.carlistrecycler.dummy.Car;
import com.example.rynel.carlistrecycler.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CarFragment.OnListFragmentInteractionListener {

    private static final String CAR_FRAG_TAG = "Red frame";
    private RecyclerView rvCarList;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    private List<Car> carList;
    ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //binding
        rvCarList = (RecyclerView) findViewById(R.id.rvCarList);
        carList = new ArrayList<>();


    }



    public void addCar(View view) {

        switch (view.getId()) {

            case R.id.addCar:

                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameRed,
                                new CarFragment(), CAR_FRAG_TAG).addToBackStack(CAR_FRAG_TAG)
                        .commit();
                break;



        }
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
