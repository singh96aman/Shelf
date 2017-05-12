package com.example.shelf.Sublistsdrinks;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.shelf.Cart;
import com.example.shelf.Constants;
import com.example.shelf.CustomList;
import com.example.shelf.R;

/**
 * Created by amansinghthakur on 08/09/16.
 */
public class ColdDrinks extends Fragment {

    ListView mainListView;
    View myView;
    ImageView Add, Sub;
    static TextView t1;
    TableLayout table1;
    Button b1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.colddrinks, container, false);

        CustomList adapter = new
                CustomList(getActivity(), Constants.web, Constants.price, Constants.imageId, Constants.add, Constants.sub);
        mainListView = (ListView) myView.findViewById(R.id.listview1);


        Add = (ImageView) myView.findViewById(R.id.imageView1);
        Sub = (ImageView) myView.findViewById(R.id.imageView2);
        t1 = (TextView) myView.findViewById(R.id.txtcart);
        b1 = (Button) myView.findViewById(R.id.btncheckout);
        //table1 = (TableLayout) myView.findViewById(R.id.table1);
        t1.setText(Integer.toString(Constants.total));

        mainListView.setAdapter(adapter);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame,new Cart()).commit();
            }
        });

        return myView;
    }

    public static void onChange(int total)
    {
        t1.setText(Integer.toString(total));
    }

}
