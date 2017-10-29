package com.example.rynel.carlistrecycler;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CarListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CarListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CarListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    CarListAdapter carListAdapter;
    List<Car> carList= new ArrayList<>();

    public CarListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CarListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CarListFragment newInstance(String param1, String param2) {
        CarListFragment fragment = new CarListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //bind the view.
        layoutManager = new LinearLayoutManager( view.getContext() );
        itemAnimator = new DefaultItemAnimator();
        carListAdapter = new CarListAdapter(carList);

        recyclerView = (RecyclerView) view.findViewById( R.id.rvCarList );
        recyclerView.setAdapter( carListAdapter );
        recyclerView.setItemAnimator( itemAnimator );
        recyclerView.setLayoutManager( layoutManager );

        /*
        carList.add( new Car( "model", "type", "year" ));
        carList.add( new Car( "model", "type", "year" ));
        carList.add( new Car( "model", "type", "year" ));//*/
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void setCarList( List<Car> list ) {
        carList = list;
        carListAdapter = new CarListAdapter( list );
        recyclerView.setAdapter( carListAdapter );
    }

//    public void addCar( String model, String type, String year ) {
//        carList.add( new Car( model, type, year ));
//    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}