package com.example.cnkua.discoverethiopia.Controllers;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cnkua.discoverethiopia.R;

public class AttractionDecsActivity extends AppCompatActivity  {

    TextView TitleView;
    TextView QuoteView;
    TextView DescriptionView;
    TextView Info;
    ImageView img;
    String Title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_decs);

        TitleView = (TextView)findViewById(R.id.attraction_name);
        QuoteView = (TextView)findViewById(R.id.quote);
        DescriptionView =(TextView)findViewById(R.id.description);
        img = (ImageView)findViewById(R.id.attraction_thumbnail);
        Info =(TextView)findViewById(R.id.inform);

        Intent i1 = getIntent();

         Title = i1.getExtras().getString("AttractionName");
        String Quote = i1.getExtras().getString("Quote");
        String Description = i1.getExtras().getString("AttractionDesctiption");
        int thumbnail = i1.getExtras().getInt("AttractionImage");
        int info = i1.getExtras().getInt("Information");

        TitleView.setText(Title);
        QuoteView.setText(Quote);
        DescriptionView.setText(Description);
        img.setImageResource(thumbnail);
        Info.setText(info);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+Title));
                startActivity(i2);
            }
        });

    }


}
