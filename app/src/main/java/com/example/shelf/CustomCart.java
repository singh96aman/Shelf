package com.example.shelf;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by amansinghthakur on 02/10/16.
 */
public class CustomCart extends ArrayAdapter<Integer> {

    // Image, // product // price // count

    private final Activity context;
    private final Integer ImgId[];
    private final String[] product;
    private final Integer[] price;
    private final Integer[] count;
    //private final ArrayList<Integer> productpro;
    static int i=0;

    public CustomCart(Activity context, Integer[] imgId, String[] product, Integer[] price, Integer[] count) {
        super(context,R.layout.list_cart,Constants.positionpro);
        this.context = context;
        this.ImgId = imgId;
        this.product = product;
        this.price = price;
        this.count = count;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            final LayoutInflater inflater = context.getLayoutInflater();
            View rowView= inflater.inflate(R.layout.list_cart, null, true);

            TextView t1 =(TextView) rowView.findViewById(R.id.txtproductcart);
            TextView t2 = (TextView) rowView.findViewById(R.id.txtpricecart);
            TextView t3 = (TextView) rowView.findViewById(R.id.txtcountcart);
            ImageView img = (ImageView) rowView.findViewById(R.id.imgcart);
        try {
            t1.setVisibility(View.VISIBLE);
            t2.setVisibility(View.VISIBLE);
            t3.setVisibility(View.VISIBLE);
            img.setVisibility(View.VISIBLE);
            t1.setText(Constants.web[Constants.positionpro.get(position)]);
            t2.setText(Integer.toString(Constants.price[Constants.positionpro.get(position)]));
            t3.setText(Integer.toString(Constants.count[Constants.positionpro.get(position)]));
            img.setImageResource(Constants.imageId[Constants.positionpro.get(position)]);
        }catch (Exception e)
        {}

            /*
            t1.setText(Constants.web[position]);
            t2.setText(Integer.toString(Constants.price[position]));
            t3.setText(Integer.toString(Constants.count[position]));
            img.setImageResource(Constants.imageId[position]);
            */
            return rowView;
    }
}
