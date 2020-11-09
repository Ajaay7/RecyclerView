package com.edureka.recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder
{
    TextView tv1,tv2,tv3;
    ImageView imageview;

    public RecyclerViewHolder(@NonNull View itemView)
    {
        super(itemView);

        tv1 = (TextView) itemView.findViewById(R.id.list_title);
        tv2 = (TextView) itemView.findViewById(R.id.list_desc);
        tv3= (TextView) itemView.findViewById(R.id.list_phno);
        imageview = (ImageView) itemView.findViewById(R.id.list_avatar);

    }
}
