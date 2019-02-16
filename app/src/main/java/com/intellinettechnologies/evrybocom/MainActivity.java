package com.intellinettechnologies.evrybocom;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.intellinettechnologies.evrybocom.adapter.fragmentTabAdapter;
import com.intellinettechnologies.evrybocom.fragments.Design;
import com.intellinettechnologies.evrybocom.fragments.Fabric;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager vp    = findViewById(R.id.viewpager);
        TabLayout tabs  = findViewById(R.id.tabs);

        fragmentTabAdapter adapter = new fragmentTabAdapter(getSupportFragmentManager());

        // Add the notifications and messages Fragments to adapter
        adapter.addFragment(new Fabric(), getString(R.string.fabric_fragment));
        adapter.addFragment(new Design(), getString(R.string.design_fragment));
        Log.d("VT","Fragments added to profile adapter");

        vp.setAdapter(adapter);
        vp.setOffscreenPageLimit(2);
        tabs.setupWithViewPager(vp);
    }
}
