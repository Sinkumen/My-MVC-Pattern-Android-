package com.example.cnkua.discoverethiopia.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cnkua.discoverethiopia.ImageFixer;
import com.example.cnkua.discoverethiopia.Models.Agent;
import com.example.cnkua.discoverethiopia.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CNKU A on 5/20/2018.
 */

public class AgentRecyclerViewAdapter extends RecyclerView.Adapter<AgentRecyclerViewAdapter.MyViewHolder> {
    private Context mcontext ;
    private List<Agent> agent_data;

    public AgentRecyclerViewAdapter(Context context, List<Agent> agent_data) {
        this.mcontext = context;
        this.agent_data = agent_data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater =  LayoutInflater.from(mcontext);
        view = inflater.inflate(R.layout.cardview_agent,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position) {
        holder.name.setText(agent_data.get(position).getName());
        holder.img_agent.setImageBitmap(ImageFixer.decodeSampledBitmapFromResource(mcontext.getResources(),agent_data.get(position).getImage(),120,190));
        holder.info.setText(agent_data.get(position).getInfo());




    }

    @Override
    public int getItemCount() {
        return agent_data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView info;
        ImageView img_agent;
        CardView cardView ;


        public MyViewHolder(View itemView) {
            super(itemView);

            name =(TextView)itemView.findViewById(R.id.Name);
            info = (TextView)itemView.findViewById(R.id.agent_info);
            img_agent =(ImageView)itemView.findViewById(R.id.agent_img);
            cardView =(CardView)itemView.findViewById(R.id.agent_cardView);
        }
    }
    public void setFilter(ArrayList<Agent> new_list){
        agent_data =new ArrayList<Agent>();
        agent_data.addAll(new_list);
        notifyDataSetChanged();
    }

}
