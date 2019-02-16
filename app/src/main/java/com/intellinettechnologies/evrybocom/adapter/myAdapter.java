package com.intellinettechnologies.evrybocom.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.intellinettechnologies.evrybocom.R;
import com.intellinettechnologies.evrybocom.model.Data;

import java.util.ArrayList;


public class myAdapter extends RecyclerView.Adapter<myAdapter.MyViewHolder> {

    ArrayList<Data> data;
    int id;

    private ItemClickListener mClickListener;
    private ArrayList<Drawable> bannerImages;
    Context context;

    public myAdapter(ArrayList<Data> data, ArrayList<Drawable> bannerImages, Context context) {
        this.data = data;
        this.bannerImages = bannerImages;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_adapter, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        RequestOptions options = new RequestOptions();
        options.centerCrop();


        Glide.with(context)
                .load(bannerImages.get(position))
                .apply(options)
                .into(holder.mImage);


       // holder.mImage.setImageDrawable(bannerImages.get(position));
        holder.mType.setText(data.get(position).getType());
        holder.mVendor.setText(data.get(position).getVendor());
        holder.mcode.setText(data.get(position).getCode());
        holder.mAvailable.setText(data.get(position).getAvailable());
        holder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mClickListener != null)
                    mClickListener.onItemClick(view, data.get(position).getId());

                Log.d("VT", "inside viewHolder id" + data.get(position).getId());
                Log.d("VT", "inside viewHolder  title" + data.get(position).getVendor());
            }
        });

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImage;
        TextView mType, mVendor, mcode, mAvailable;
        LinearLayout mLinearLayout;

        public MyViewHolder(View view) {
            super(view);
            mImage = view.findViewById(R.id.tImage);
            mType = view.findViewById(R.id.tType);
            mVendor = view.findViewById(R.id.tVendor);
            mcode = view.findViewById(R.id.tCode);
            mAvailable = view.findViewById(R.id.tAvailable);
            mLinearLayout = view.findViewById(R.id.myImage);

            Log.d("VT", "inside viewHolder");

        }


    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, String id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
}

