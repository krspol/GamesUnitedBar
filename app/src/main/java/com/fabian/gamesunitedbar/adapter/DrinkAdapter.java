package com.fabian.gamesunitedbar.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fabian.gamesunitedbar.R;
import com.fabian.gamesunitedbar.data.SqlLiteDb;
import com.fabian.gamesunitedbar.model.Drink;
import com.squareup.picasso.Picasso;


import java.util.List;

/**
 * Created by Fabian Polkosnik on 28.06.2017.
 */

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.MyViewAdapter> {

    private List<Drink> data;
    private Context context;

    public DrinkAdapter(List<Drink> data , Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public MyViewAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_drink_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewAdapter holder, int position) {
        holder.getTitle().setText(data.get(position).getName());
        holder.getPrice().setText(data.get(position).getPrice()+" zł");
        holder.getVolume().setText(data.get(position).getVolume()+" ml");
        Picasso.with(context).load(data.get(position).getPhoto()).resize(400,400).into(holder.getPhoto());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewAdapter extends RecyclerView.ViewHolder {

        private ImageView photo;
        private TextView title;
        private TextView price;
        private TextView volume;


        private ImageButton increaseBtn;
        private ImageButton decreaseBtn;
        private Button addBtn;
        private EditText drinkCounter;

        private SqlLiteDb sqlLiteDb;

        public MyViewAdapter(View view) {
            super(view);

            sqlLiteDb = new SqlLiteDb(context);

            photo = (ImageView) view.findViewById(R.id.drink_photo);
            title = (TextView) view.findViewById(R.id.drink_name);
            price = (TextView) view.findViewById(R.id.drink_price);
            volume = (TextView) view.findViewById(R.id.drink_volume);

            increaseBtn = (ImageButton) view.findViewById(R.id.drink_increase);
            decreaseBtn = (ImageButton) view.findViewById(R.id.drink_decrease);
            drinkCounter = (EditText) view.findViewById(R.id.drink_counter);
            addBtn = (Button) view.findViewById(R.id.add_to_cart_btn);


            increaseBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int counter = Integer.parseInt(drinkCounter.getText().toString());
                    counter = counter <= 5 ? counter + 1 : counter;

                    drinkCounter.setText(counter+"", TextView.BufferType.EDITABLE);
                }
            });
            decreaseBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int counter = Integer.parseInt(drinkCounter.getText().toString());
                    counter = counter > 0 ? counter - 1 : counter;

                    drinkCounter.setText(counter+"", TextView.BufferType.EDITABLE);
                }
            });

            addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SQLiteDatabase _db = sqlLiteDb.getWritableDatabase();

                    ContentValues values = new ContentValues();
                    values.put(SqlLiteDb.COLUMN_NAME_PRODUCT, title.getText().toString());
                    values.put(SqlLiteDb.COLUMN_NAME_AMOUNT, Integer.parseInt( drinkCounter.getText().toString()));
                    values.put(SqlLiteDb.COLUMN_NAME_PRICE, Double.parseDouble( price.getText().toString()));

                    long result = _db.insert(SqlLiteDb.TABLE_NAME, null, values);

                    // TODO tost not working
                    if(result == -1)
                        Toast.makeText(context, "There was a problem with adding new record", Toast.LENGTH_SHORT);
                    else
                        Toast.makeText(context, "Record successfully added", Toast.LENGTH_SHORT);
                }
            });

        }
        public ImageView getPhoto() {
            return photo;
        }

        public void setPhoto(ImageView photo) {
            this.photo = photo;
        }

        public TextView getTitle() {
            return title;
        }

        public void setTitle(TextView title) {
            this.title = title;
        }

        public TextView getPrice() {
            return price;
        }

        public void setPrice(TextView price) {
            this.price = price;
        }

        public TextView getVolume() {
            return volume;
        }

        public void setVolume(TextView volume) {
            this.volume = volume;
        }
    }
}


