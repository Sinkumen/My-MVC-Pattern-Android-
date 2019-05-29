package com.example.cnkua.discoverethiopia.Controllers;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cnkua.discoverethiopia.R;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = (Button)findViewById(R.id.button1);
        TextView t1 = (TextView)findViewById(R.id.grad);
        RelativeLayout r1 = (RelativeLayout)findViewById(R.id.Root);
       // t1.setBackground(ImageFixer.decodeSampledBitmapFromResource(getResources(),R.drawable.gradient,120,190)));
    }
    public void RedirectToAttraction(View view){
        Intent i1 = new Intent(this,AttractionsActivity.class);
        startActivity(i1);
    }
    public void RedirectToAgent(View view){
        Intent i2 = new Intent(this,AgentActivity.class);
        startActivity(i2);
    }
}
