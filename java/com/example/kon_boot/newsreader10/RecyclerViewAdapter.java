package com.example.kon_boot.newsreader10;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


     Context context;
    private  List<Article> item;



     public RecyclerViewAdapter(Context context , List<Article>item)

     {
         this.context = context;
         this.item=item;

     }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view;
       view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);

       MyViewHolder viewHolder = new MyViewHolder(view);
       return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

     final Article item1=  item.get(position);
     holder.title.setText(item1.getTitle());
     holder.description.setText(item1.getDescription());
     Glide.with(context).load(item1.getUrlToImage()).into(holder.img);


     holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent =  new Intent(context,Detail.class);
             intent.putExtra("url",item1.getUrl());
             context.startActivity(intent);
         }
     });

    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

         TextView title;
         ImageView img;
         TextView description;

        public MyViewHolder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.Heading);
            img = itemView.findViewById(R.id.postimage);
            description=itemView.findViewById(R.id.snippet);
        }
    }
}
