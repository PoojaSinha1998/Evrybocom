package com.intellinettechnologies.evrybocom.fragments;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.intellinettechnologies.evrybocom.DetailActivity;
import com.intellinettechnologies.evrybocom.R;
import com.intellinettechnologies.evrybocom.adapter.myAdapter;
import com.intellinettechnologies.evrybocom.application.myapplication;
import com.intellinettechnologies.evrybocom.model.Data;

import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fabric extends Fragment implements myAdapter.ItemClickListener{
    View mainView;
    RequestQueue requestQueue;
    ArrayList<Data> posts;
    myAdapter mAdapter;
    RecyclerView recyclerView;
    ArrayList<Drawable> bannerImages = new ArrayList<>();

    public Fabric() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView = inflater.inflate(R.layout.fragment_fabric, container, false);
        recyclerView = mainView.findViewById(R.id.recyclerView);
        requestQueue = Volley.newRequestQueue(getActivity());
        getImagesFromAssets();
        new getVediosFromServer().execute();
        return mainView;
    }

    @Override
    public void onItemClick(View view, String id) {
       // Toast.makeText(getActivity(),"Item Clicked",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getActivity(),DetailActivity.class);
        intent.putExtra("ID",id);
        startActivity(intent);


    }

    @SuppressLint("StaticFieldLeak")
    private class getVediosFromServer extends AsyncTask<Void, Void, Void> {

        ProgressDialog dialog = new ProgressDialog(getActivity());

        @Override
        protected void onPreExecute() {
            Log.d("VT", "inside pre Response: ");
            super.onPreExecute();
            dialog.setMessage("Please wait.");
            dialog.setIndeterminate(true);
            dialog.setCancelable(false);
            dialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            dialog.dismiss();
            Log.d("VT", "inside post Response: ");
        }

        @Override
        protected Void doInBackground(Void... voids) {

            String url = "https://api.jsonbin.io/b/5c681a181198012fc89b3f06/6";
            Log.d("VT", "inside do Response: " + url);
            final JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    Log.d("VT", "jsonresponse: " + response);

                    Type listType = new TypeToken<List<Data>>() {
                    }.getType();
                    posts = new Gson().fromJson(response.toString(), listType);

                    Log.d("VT", "Data using Data Type :" + posts.get(1).getAvailable());

                    myapplication.setExamples(posts);
                    for (int i = 0; i < posts.size(); i++) {
                        Log.d("VT", "response one by one :" + posts.get(i).getAvailable());
                    }
                    setAdapterOnRecyclerView();

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("VT", "inside error Response: " + error);
                    error.printStackTrace();
                }
            });
            requestQueue.add(request);
            return null;
        }
    }

    private void setAdapterOnRecyclerView() {
        mAdapter = new myAdapter(myapplication.getExamples(),bannerImages, getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter.setClickListener(this);
        recyclerView.setAdapter(mAdapter);
    }

    public void getImagesFromAssets() {

        Drawable tempImage;
        AssetManager assetManager = getActivity().getAssets();

        try {
            /* Get List of images from banners folder */
            String[] fileList = assetManager.list("image");
            InputStream inputStream;

            for (String fName : fileList) {
                inputStream = assetManager.open("image/" + fName);
                tempImage = Drawable.createFromStream(inputStream, null);
                bannerImages.add(tempImage);
            }
            myapplication.setMyImages(bannerImages);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
