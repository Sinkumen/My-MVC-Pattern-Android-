package com.example.cnkua.discoverethiopia.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cnkua.discoverethiopia.Controllers.AttractionDecsActivity;
import com.example.cnkua.discoverethiopia.ImageFixer;
import com.example.cnkua.discoverethiopia.Models.Attraction;
import com.example.cnkua.discoverethiopia.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CNKU A on 5/16/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context context ;
    private List<Attraction> data;

    public RecyclerViewAdapter(Context context, List<Attraction> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater =  LayoutInflater.from(context);
        view = inflater.inflate(R.layout.cardview_attractions,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.name.setText(data.get(position).getName());
        holder.img_attraction_thumbnails.setImageBitmap(ImageFixer.decodeSampledBitmapFromResource(context.getResources(),data.get(position).getThumbnail(),120,190));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(context, AttractionDecsActivity.class);
                i2.putExtra("AttractionName",data.get(position).getName());
                i2.putExtra("Quote",data.get(position).getQuote());
                i2.putExtra("AttractionDesctiption",data.get(position).getDescription());
                i2.putExtra("AttractionImage",data.get(position).getThumbnail());
                i2.putExtra("Information",data.get(position).getInfo());
                context.startActivity(i2);
            }

        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        ImageView img_attraction_thumbnails;
        CardView cardView ;


        public MyViewHolder(View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.attraction_name);
            img_attraction_thumbnails = (ImageView)itemView.findViewById(R.id.attraction_image);
            cardView =(CardView)itemView.findViewById(R.id.cardview);
        }
    }
    public void setFilter(ArrayList<Attraction> new_list){
        data =new ArrayList<>();
        data.addAll(new_list);
        notifyDataSetChanged();
    }
}
