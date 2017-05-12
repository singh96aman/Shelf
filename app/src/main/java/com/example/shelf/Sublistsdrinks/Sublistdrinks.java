package com.example.shelf.Sublistsdrinks;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.shelf.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by amansinghthakur on 08/09/16.
 */
public class Sublistdrinks extends Fragment {

    ListView mainListView;
    View myView;
    ArrayAdapter<String> listAdapter ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.sublistdrinks,container,false);

        mainListView = (ListView) myView.findViewById(R.id.mainListView);
        String[] web = new String[] { "Cold Drinks", "Juices", "Whiskey", "Rum", "Vodka",
                "Brandy", "Scotch", "Wine", "Champaigne"};

        ArrayList<String> drinklist = new ArrayList<String>();
        drinklist.addAll( Arrays.asList(web) );
        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.listviewtextentry, drinklist);
        mainListView.setAdapter( listAdapter );

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               switch (position)
               {
                   case 0 : android.app.FragmentManager fragmentManager = getFragmentManager();
                       fragmentManager.beginTransaction().replace(R.id.content_frame,new ColdDrinks()).commit();
               }
            }
        });

        return myView;

    }
}
