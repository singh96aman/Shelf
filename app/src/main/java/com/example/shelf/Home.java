package com.example.shelf;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shelf.Sublistsdrinks.ColdDrinks;

/**
 * Created by amansinghthakur on 07/09/16.
 */
public class Home extends Fragment  {


    View myView;
    CardView c1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.home,container,false);
    c1 = (CardView) myView.findViewById(R.id.card_view44);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame,new ColdDrinks()).commit();
            }
        });

    return myView;
    }

}
