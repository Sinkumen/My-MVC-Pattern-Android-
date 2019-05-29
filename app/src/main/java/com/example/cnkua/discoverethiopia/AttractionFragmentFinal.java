package com.example.cnkua.discoverethiopia;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.cnkua.discoverethiopia.Adapters.RecyclerViewAdapter;
import com.example.cnkua.discoverethiopia.Models.Attraction;

import java.util.ArrayList;

/**
 * Created by CNKU A on 5/16/2018.
 */

public class AttractionFragmentFinal extends Fragment implements android.widget.SearchView.OnQueryTextListener,MenuItem.OnActionExpandListener {

    ArrayList<Attraction> lstAttractions;
    RecyclerViewAdapter myAdapter;
    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_attraction_final,container,false);
        mContext = getActivity();
        lstAttractions = new ArrayList<>();
        lstAttractions.add(new Attraction("Axum","",R.string.axum_info,"Aksum is a city in northern Ethiopia. It's known for its tall, carved obelisks, relics of the ancient Kingdom of Aksum. Most are in the northern Stelae Park, including a huge fallen pillar, now in pieces. Centuries-old St. Mary of Zion is a Christian church and pilgrimage site believed to have housed the biblical Ark of the Covenant. The neighboring Chapel of the Tablet is said to contain the Ark today.",R.drawable.axum));
        lstAttractions.add(new Attraction("Fsiledes","",R.string.Fasilede_info,"Fasil Ghebbi (Royal Enclosure) is the remains of a fortress-city within Gondar, Ethiopia. It was founded in the 17th century by Emperor Fasilides (Fasil) and was the home of Ethiopia's emperors. Its unique architecture shows diverse influences including Nubian styles. The site was inscribed as a UNESCO World Heritage Site in 1979. Ghebbi is an Amharic word for a compound or enclosure",R.drawable.fasiledes_castle));
        lstAttractions.add(new Attraction("Lalibela","",R.string.Lalibela_info,"Lalibela (Amharic: ላሊበላ) is a town in Amhara Region, northern Ethiopia famous for monolithic rock-cut churches. The whole of Lalibela offers an exceptional testimony to the medieval and post-medieval civilization of Ethiopia.[1] Lalibela is one of Ethiopia's holiest cities, second only to Aksum, and a center of pilgrimage. Unlike Aksum, the population of Lalibela is almost completely Ethiopian Orthodox Christian. Ethiopia was one of the earliest nations to adopt Christianity in the first half of the fourth century, and its historical roots date to the time of the Apostles. The churches themselves date from the seventh to thirteenth centuries, and are traditionally dated to the reign of the Zagwe dynasty king Gebre Mesqel Lalibela (r. ca. 1181–1221 AD).",R.drawable.lalibela));
        lstAttractions.add(new Attraction("Addis Ababa","",R.string.Addis_Ababa_info,"Addis Ababa, Ethiopia’s sprawling capital in the highlands bordering the Great Rift Valley, is the country’s commercial and cultural hub. Its National Museum exhibits Ethiopian art, traditional crafts and prehistoric fossils, including replicas of the famous early hominid, \"Lucy.\" The burial place of the 20th-century emperor Haile Selassie, copper-domed Holy Trinity Cathedral, is a neo-baroque architectural landmark.",R.drawable.aa));
        lstAttractions.add(new Attraction("Debre Damo","",R.string.Debre_damo_info,"Debre Damo is the name of a flat-topped mountain, or amba, and a 6th-century monastery in northern Ethiopia. The mountain is a steeply rising plateau of trapezoidal shape, about 1000 by 400 m in dimension.",R.drawable.axum));
        lstAttractions.add(new Attraction("Ertale","",R.string.Erta_Ale_info,"Erta Ale is a continuously active basaltic shield volcano in the Afar Region of northeastern Ethiopia. It is situated in the Afar Depression, a badland desert area. Erta Ale is the most active volcano in Ethiopia",R.drawable.ertale));
        lstAttractions.add(new Attraction("Harar","",R.string.harar_info,"Harar is a city in eastern Ethiopia. It’s surrounded by a centuries-old defensive wall that has several large gates, including Duke's Gate. The city is known for its mazelike alleys and traditional houses decorated inside with flat hanging baskets. A replica house features at the Harar Community Centre Museum. A holy Islamic city, Harar has many mosques, including the Grand Jami Mosque with its tall white minarets.",R.drawable.harar)) ;
        lstAttractions.add(new Attraction("Mekelle","",R.string.Mekelle,"Mek’ele is the capital city of the Tigray region, in northern Ethiopia. In the center, the grand palace of 19th-century Emperor Yohannes IV is now the Yohannes IV Museum. The tall Martyrs’ Memorial Monument commemorates those who fought the communist Derg regime in the late 20th century. The city’s markets are an important stop for salt merchants arriving from the Danakil Depression in the country’s northeast.",R.drawable.mekelle));
        lstAttractions.add(new Attraction("Sof Omar","",R.string.sof_omer_info,"Sof Omar Cave is the longest cave in Ethiopia at 15.1 kilometres (9.4 mi) long; sources claim it is the longest system of caves in Africa.[1] It is situated to the east of Robe, in the Bale Zone of the Oromia Region in southeastern Ethiopia, through which the Weyib River (Gestro River) flows.[2] It sinks at the Ayiew Maco entrance and reappears at the Holuca resurgence 1 kilometre (0.62 mi) away. According to tradition Sof Omar was the name of a Muslim holy man who lived in the area and Ayiew the name of his daughter. Maco and Holuca are local names for 'name' and 'cave', respectively. Long a religious centre, it is sacred both to Islam and the local Oromo traditional religion. The caves are known for their many pillars, particularly in the 'Chamber of Columns'.",R.drawable.sof_omar));
        lstAttractions.add(new Attraction("Tana","",R.string.tana_info,"Lake Tana (also spelled T'ana, Amharic: ጣና ሀይቅ, Ṭana Ḥäyq, T’ana Hāyk’; an older variant is Tsana, Ge'ez: ጻና Ṣānā; sometimes called \"Dembiya\" after the region to the north of the lake) is the source of the Blue Nile and is the largest lake in Ethiopia. Located in Amhara Region in the north-western Ethiopian Highlands, the lake is approximately 84 kilometers long and 66 kilometers wide, with a maximum depth of 15 meters,[1] and an elevation of 1,788 meters.[2] Lake Tana is fed by the Lesser Abay, Reb and Gumara rivers. Its surface area ranges from 3,000 to 3,500 km², depending on season and rainfall. The lake level has been regulated since the construction of the control weir where the lake discharges into the Blue Nile. This controls the flow to the Blue Nile Falls (Tis Abbai) and hydro-power station.",R.drawable.tana));
        setHasOptionsMenu(true);
        RecyclerView myRecycler = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        myAdapter = new RecyclerViewAdapter(container.getContext(),lstAttractions);
        myRecycler.setLayoutManager(new GridLayoutManager(container.getContext(),2));
        myRecycler.setAdapter(myAdapter);


        return rootView;
    }

    public ArrayList<Attraction> getLstAttractions() {
        return lstAttractions;
    }
    public void setMyAdapter(ArrayList<Attraction> newList){
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
        ArrayList<Attraction> newList = new ArrayList<>();
        for (Attraction attraction:lstAttractions){
            String name = attraction.getName().toLowerCase();
            if (name.contains(newText)){
                newList.add(attraction);
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
