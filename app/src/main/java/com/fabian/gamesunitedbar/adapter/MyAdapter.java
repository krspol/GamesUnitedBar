package com.fabian.gamesunitedbar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fabian.gamesunitedbar.R;
import com.fabian.gamesunitedbar.model.MenuItem;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Fabian Polkosnik on 26.06.2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<MenuItem> data;
    private Context context;

    public MyAdapter(List<MenuItem> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_main_item, parent, false));
    }

    @Override public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.getTextView().setText(data.get(position).getName());
        holder.getDescription().setText(data.get(position).getDescription());
        Picasso.with(context).load(data.get(position).getImageUrl()).into(holder.getImage());
    }

    @Override public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView image;
        private TextView text;
        private TextView description;
        private View listItem;


        public MyViewHolder(View view) {
            super(view);
            image = (ImageView) view.findViewById(R.id.menu_item_image);
            text = (TextView) view.findViewById(R.id.menu_item_title);
            description = (TextView) view.findViewById(R.id.menu_item_description);
            listItem = view;

            view.setOnClickListener(this);
        }


        public ImageView getImage() {
            return image;
        }

        public TextView getDescription() {
            return description;
        }

        public TextView getTextView() {
            return text;
        }


        @Override public void onClick(View v) {

        }
    }
}