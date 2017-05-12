package com.example.shelf;

import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by amansinghthakur on 10/09/16.
 */
public class Cart extends Fragment {

    View myView;
    ListView mainListView2;
    TextView t1;
    Button b1, b2;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.cart,container,false);
        t1 = (TextView) myView.findViewById(R.id.texttotal);
        b1= (Button) myView.findViewById(R.id.buttonpay);
        b2 = (Button) myView.findViewById(R.id.buttonpromo);

        CustomCart apapter = new CustomCart(getActivity(),Constants.imageId,Constants.web,Constants.price,Constants.count);
        mainListView2 = (ListView) myView.findViewById(R.id.listview2);

        mainListView2.setAdapter(apapter);

        t1.setText(Integer.toString(Constants.total));
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Paid!",Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeLangDialog();
            }
        });

        return myView;
    }
    public void showChangeLangDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.custom_dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText edt = (EditText) dialogView.findViewById(R.id.edit1);

        dialogBuilder.setTitle("Promo Code");
        dialogBuilder.setMessage("Enter promo code");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();
                String s1=edt.getText().toString();
                String s2="FILM100";
                if(s1.equals(s2)==true) {
                    Constants.total = (int) (Constants.total - Constants.total * 0.1);
                    t1.setText(Integer.toString(Constants.total));
                    Toast.makeText(getContext(),"Congratulations 10% is deducted",Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }


}
