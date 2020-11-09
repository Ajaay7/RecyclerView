package com.edureka.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    Context context;
    LayoutInflater inflater;

    String[] name = {"amaryllis", "anemone", "aster", "azalea",
            "beebalm", "birdofparadise", "bluebell", "buttercup", "cherryblossom", "chrysanthemum"};

    int[] img = new int[]{R.drawable.amaryllis, R.drawable.anemone, R.drawable.aster, R.drawable.azalea, R.drawable.beebalm,
            R.drawable.birdofparadise, R.drawable.bluebell, R.drawable.buttercup, R.drawable.cherryblossom,
            R.drawable.chrysanthemum, R.drawable.crocus};

    String[] phone = new String[]{"1111", "2222", "3333", "4444", "5555", "6666", "7777", "8888", "9999", "1212", "4567"};

    public RecyclerAdapter(MainActivity mainActivity) {

        this.context = mainActivity;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflate XML file
        View view = inflater.inflate(R.layout.item_list, parent, false);
        RecyclerViewHolder viewholder = new RecyclerViewHolder(view);


        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        //Load data
        holder.tv1.setTag(holder); // set this so while clicking on text it calls the clickListener
        holder.tv1.setText(name[position]);                        // 4
        holder.tv1.setOnClickListener(clickListener);

        holder.imageview.setTag(holder);  // set this so while clicking on image it calls the clickListener
        holder.imageview.setImageResource(img[position]);
        holder.imageview.setOnClickListener(clickListener);


        holder.tv3.setTag(holder);  // set this so while clicking on image it calls the clickListener
        holder.tv3.setText(phone[position]);
        holder.tv3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                RecyclerViewHolder vholder = (RecyclerViewHolder) v.getTag();
                int position = vholder.getPosition();

                //Log.d("tag1", "holder is : " + vholder + "Phone number is: " + phone[position] + ", id : " + v.getTag().equals(vholder.tv2.getTag()));
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone[position]));
                context.startActivity(intent);
            }
        });
    }

    View.OnClickListener clickListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            RecyclerViewHolder vholder = (RecyclerViewHolder) v.getTag();
            int position = vholder.getPosition();

            Toast.makeText(context, "This is Position " + name[position], Toast.LENGTH_SHORT).show();

        }
    };

        @Override
        public int getItemCount() {
            //How many rows to be displayed
            return name.length;
        }

}
