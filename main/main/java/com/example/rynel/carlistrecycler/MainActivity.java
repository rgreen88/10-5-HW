package com.example.rynel.carlistrecycler;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements AddCarFragment.OnFragmentInteractionListener, CarListFragment.OnFragmentInteractionListener {

    List<Car> carList = new ArrayList<>();
    CarListFragment carListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carListFragment = (CarListFragment) getSupportFragmentManager().findFragmentById( R.id.fCarList );
        carListFragment.setRetainInstance( true );
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void getCar( String model, String type, String year ) {
        carList.add( new Car( model, type, year )); //fixme created constructor to pass string data
        carListFragment.setCarList( carList );

    }
}