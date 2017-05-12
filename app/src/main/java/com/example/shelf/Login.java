package com.example.shelf;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by amansinghthakur on 10/09/16.
 */
public class Login extends Fragment{

    View myView;
    TextView t1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.login,container,false);

        t1 = (TextView) myView.findViewById(R.id.continuelogging);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame,new Home()).commit();
            }
        });

        return myView;

    }
}
