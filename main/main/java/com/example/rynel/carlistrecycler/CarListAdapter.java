package com.example.rynel.carlistrecycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rynel on 10/5/2017.
 */

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.ViewHolder> {

    List<Car> carList = new ArrayList<>();

    public CarListAdapter( List<Car> carList ) {
        this.carList = carList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //create a view inflated with the animal list items.

        View view = LayoutInflater.from( parent.getContext() ).inflate(
                R.layout.car_list_item, parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Car car = carList.get( position );

        holder.carModel.setText( car.getModel() );
        holder.carType.setText( car.getType() );
        holder.carYear.setText( car.getYear() );
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView carModel, carType, carYear;

        public ViewHolder(View itemView) {
            super(itemView);

            carModel = (TextView) itemView.findViewById( R.id.tvCarListModel );
            carType = (TextView) itemView.findViewById( R.id.tvCarListType );
            carYear = (TextView) itemView.findViewById( R.id.tvCarListYear );
        }
    }
}