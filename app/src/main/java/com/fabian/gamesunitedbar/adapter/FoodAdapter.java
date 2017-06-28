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

import com.fabian.gamesunitedbar.AppToolbarCompatActivity;
import com.fabian.gamesunitedbar.R;
import com.fabian.gamesunitedbar.data.SqlLiteDb;
import com.fabian.gamesunitedbar.model.Food;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Fabian Polkosnik on 27.06.2017.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {

    private List<Food> data;
    private Context context;


    public FoodAdapter(List<Food> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_food_item, parent, false));
    }

    @Override public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.getTitle().setText(data.get(position).getTitle());
        holder.getDescription().setText(data.get(position).getDescription());
        holder.getPrice().setText("" + data.get(position).getPrice());
        holder.getAvaiable().setText("Avaiable " + data.get(position).isAvaiable());
        Picasso.with(context).load(data.get(position).getImage()).resize(400,400).into(holder.getImage());
    }

    @Override public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView text;
        private TextView description;
        private TextView price;
        private TextView avaiable;

        private ImageButton increaseBtn;
        private ImageButton decreaseBtn;
        private Button addBtn;
        private EditText foodCounter;

        private SqlLiteDb sqlLiteDb;

        public MyViewHolder(View view) {
            super(view);

            sqlLiteDb = new SqlLiteDb(context);

            image = (ImageView) view.findViewById(R.id.food_photo);
            text = (TextView) view.findViewById(R.id.food_name);
            description = (TextView) view.findViewById(R.id.food_description);
            price = (TextView) view.findViewById(R.id.food_price);
            avaiable = (TextView) view.findViewById(R.id.food_avaiable);

            increaseBtn = (ImageButton) view.findViewById(R.id.food_increase);
            decreaseBtn = (ImageButton) view.findViewById(R.id.food_decrease);
            addBtn = (Button) view.findViewById(R.id.add_to_cart_btn);
            foodCounter = (EditText) view.findViewById(R.id.food_counter);

            increaseBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int counter = Integer.parseInt(foodCounter.getText().toString());
                    counter = counter <= 5 ? counter + 1 : counter;

                    foodCounter.setText(counter+"", TextView.BufferType.EDITABLE);
                }
            });
            decreaseBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int counter = Integer.parseInt(foodCounter.getText().toString());
                    counter = counter > 0 ? counter - 1 : counter;

                    foodCounter.setText(counter+"", TextView.BufferType.EDITABLE);
                }
            });

            addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SQLiteDatabase _db = sqlLiteDb.getWritableDatabase();

                    ContentValues values = new ContentValues();
                    values.put(SqlLiteDb.COLUMN_NAME_PRODUCT, text.getText().toString());
                    values.put(SqlLiteDb.COLUMN_NAME_AMOUNT, Integer.parseInt( foodCounter.getText().toString()));
                    values.put(SqlLiteDb.COLUMN_NAME_PRICE, Double.parseDouble( price.getText().toString()));

                    long result = _db.insert(SqlLiteDb.TABLE_NAME, null, values);

                    // TODO toast not working
                    if(result == -1)
                        Toast.makeText(context, "There was a problem with adding new record", Toast.LENGTH_SHORT);
                    else {
                        Toast.makeText(context, "Record successfully added", Toast.LENGTH_SHORT);
                        AppToolbarCompatActivity.productsInCart += Integer.parseInt(foodCounter.getText().toString());
                        ((AppToolbarCompatActivity)context).invalidateOptionsMenu();
                    }
                }
            });
        }


        public ImageView getImage() {
            return image;
        }

        public TextView getDescription() {
            return description;
        }

        public TextView getTitle() {
            return text;
        }

        public TextView getPrice() { return price; }

        public TextView getAvaiable(){ return avaiable; }

    }
}


