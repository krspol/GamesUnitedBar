package com.fabian.gamesunitedbar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.fabian.gamesunitedbar.R;
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

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView image;
        private TextView text;
        private TextView description;
        private TextView price;
        private TextView avaiable;

        private ImageButton increaseBtn;
        private ImageButton decreaseBtn;
        private Button addBtn;
        private EditText foodCounter;

        private View listItem;

        public MyViewHolder(View view) {
            super(view);

            image = (ImageView) view.findViewById(R.id.food_photo);
            text = (TextView) view.findViewById(R.id.food_name);
            description = (TextView) view.findViewById(R.id.food_description);
            price = (TextView) view.findViewById(R.id.food_price);
            avaiable = (TextView) view.findViewById(R.id.food_avaiable);

            listItem = view;

            increaseBtn = (ImageButton) view.findViewById(R.id.food_increase);
            decreaseBtn = (ImageButton) view.findViewById(R.id.food_decrease);
            addBtn = (Button) view.findViewById(R.id.add_to_cart_btn);
            foodCounter = (EditText) view.findViewById(R.id.food_counter);

            increaseBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int counter = Integer.parseInt(foodCounter.getText().toString()) + 1;

                    foodCounter.setText(counter + "");
                }
            });
            decreaseBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int counter = Integer.parseInt(foodCounter.getText().toString()) - 1;

                    foodCounter.setText(counter + "");
                }
            });

            addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // TODO add to cart SQLLite
                }
            });
            view.setOnClickListener(this);
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

        @Override public void onClick(View v) {
            final int adapterPosition = getAdapterPosition();

        }
    }
}


