package com.example.cnkua.discoverethiopia;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.cnkua.discoverethiopia.Adapters.AgentRecyclerViewAdapter;
import com.example.cnkua.discoverethiopia.Models.Agent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CNKU A on 5/16/2018.
 */

public class AgentFragmentFinal extends Fragment implements android.widget.SearchView.OnQueryTextListener,MenuItem.OnActionExpandListener {
    List<Agent> lstAgents;
    AgentRecyclerViewAdapter myAdapter;
    private Context mContext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_agent_final,container,false);
        mContext = getActivity();
        lstAgents = new ArrayList<>();
        lstAgents.add(new Agent("Yama Tours",R.string.yama_info,1));
        lstAgents.add(new Agent("Imagine Ethiopia Tours",R.string.yama_info,1));
        lstAgents.add(new Agent("FKLM Ethiopia Tours, Travel and Car Rental",R.string.yama_info,1));
        lstAgents.add(new Agent("Awura Tours",R.string.yama_info,1));
        lstAgents.add(new Agent("Taitu Tours",R.string.yama_info,1));
        lstAgents.add(new Agent("Witness Ethiopia Tours",R.string.yama_info,1));
        lstAgents.add(new Agent("Zelalem Tour,travel & Car Rental Ethiopia",R.string.yama_info,1));
        lstAgents.add(new Agent("Base Ethiopia International Tour & Travel",R.string.yama_info,1));
        lstAgents.add(new Agent("Welcome Ethiopia Tours",R.string.yama_info,1));
        lstAgents.add(new Agent("Boundless Ethiopia Tours PLC",R.string.yama_info,1));
        setHasOptionsMenu(true);
        RecyclerView myRecycler = (RecyclerView) rootView.findViewById(R.id.agent_recycler);
        myAdapter = new AgentRecyclerViewAdapter(container.getContext(),lstAgents);
        myRecycler.setLayoutManager(new GridLayoutManager(container.getContext(),1));
        myRecycler.setAdapter(myAdapter);

        return rootView;
    }

    public List<Agent> getLstAgents() {
        return lstAgents;
    }
    public void setMyAdapter(ArrayList<Agent> newList){
        myAdapter.setFilter(newList);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_items,menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        android.widget.SearchView searchView = (android.widget.SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Search");
        searchView.setIconifiedByDefault(true);
        searchView.setFocusable(true);
        searchView.requestFocus();
        searchView.setIconified(false);
        searchView.requestFocusFromTouch();
        super.onCreateOptionsMenu(menu, inflater);

    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText =newText.toLowerCase();
        ArrayList<Agent> newList = new ArrayList<>();
        for (Agent agent:lstAgents){
            String name = agent.getName().toLowerCase();
            if (name.contains(newText)){
                newList.add(agent);
            }
        }
        myAdapter.setFilter(newList);


        return true;
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
        return false;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        return false;
    }
}