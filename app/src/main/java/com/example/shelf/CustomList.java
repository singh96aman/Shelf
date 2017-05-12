package com.example.shelf;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shelf.Sublistsdrinks.ColdDrinks;

/**
 * Created by amansinghthakur on 08/09/16.
 */
public class CustomList extends ArrayAdapter<String> {

    private final Activity context;
    private final Integer[] imageId;
    private final Integer[] imageId2;
    private final Integer[] imageId3;
    //ArrayList<Integer>[] productcount;
    static int i=0;

    public CustomList(Activity context,
                      String[] web, Integer[] price, Integer[] imageId, Integer[] imageId2, Integer[] imageId3) {
        super(context, R.layout.list_single,web);
        this.context = context;
        Constants.web = web;
        Constants.price = price;
        this.imageId = imageId;
        this.imageId2 = imageId2;
        this.imageId3 = imageId3;
        //productcount = new ArrayList[2];
        //productcount[0] = new ArrayList<>();
        //productcount[1]=new ArrayList<>();
    }



    @Override
    public View getView(final int position, View view, final ViewGroup parent) {
        final LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        TextView txtTitle2 = (TextView) rowView.findViewById(R.id.txt2);
        final TextView txtcount = (TextView) rowView.findViewById(R.id.txtcount);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        ImageView imageView1= (ImageView) rowView.findViewById(R.id.imageView1);
        ImageView imageView2 = (ImageView) rowView.findViewById(R.id.imageView2);

        txtTitle.setText(Constants.web[position]);
        txtTitle2.setText(Integer.toString(Constants.price[position]));
        txtcount.setText(Integer.toString(Constants.count[position]));

        imageView.setImageResource(imageId[position]);
        imageView1.setImageResource(imageId2[position]);
        imageView2.setImageResource(imageId3[position]);



        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),(Constants.count[position]+1)+" "+Constants.web[position]+" Added",Toast.LENGTH_SHORT).show();
                Constants.total+=Constants.price[position];
                Constants.count[position]++;
                Constants.positionpro.add(position);
                Log.i("yadavkimaaka",Integer.toString(Constants.positionpro.get(i)));
                i++;
                txtcount.setText(Integer.toString(Constants.count[position]));
                ColdDrinks.onChange(Constants.total);
                Log.i("Yadav","RakhelReturns");
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Constants.count[position]!=0) {
                    Toast.makeText(getContext(),"Element Subtracted",Toast.LENGTH_SHORT).show();
                    Constants.count[position]--;
                    Constants.total -= Constants.price[position];
                    ColdDrinks.onChange(Constants.total);
                    txtcount.setText(Integer.toString(Constants.count[position]));
                }
                else
                    Toast.makeText(getContext(),"Element Not added",Toast.LENGTH_SHORT).show();
            }
        });


        return rowView;
    }
}