package com.example.maccoffe;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SandwichesAdapter extends RecyclerView.Adapter<SandwichesAdapter.sandwichHolder>{
    private static final String TAG = "Sand";
   private   ArrayList<SandwichesMoudel> sandwichProducts;
    private  ITotalPrice iTotalPrice;

    public SandwichesAdapter(ArrayList<SandwichesMoudel> sandwichProducts, ITotalPrice iTotalPrice) {

        this.iTotalPrice=iTotalPrice;
        this.sandwichProducts = sandwichProducts;
    }

    @NonNull
    @Override
    public sandwichHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sandwich, parent, false);
        sandwichHolder holder=new sandwichHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull sandwichHolder holder, int position) {
        SandwichesMoudel sandwichesMoudel = sandwichProducts.get(position);
        holder.textViewCoffeeName.setText(sandwichesMoudel.getName());
        holder.textViewPrice.setText(sandwichesMoudel.getPrize() + " " + "EGP");

        Log.i(TAG, "onBindViewHolder: " + sandwichesMoudel.getImageUrl());
        Picasso.get().load(sandwichesMoudel.getImageUrl()).into(holder.imageViewproduct);

        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sandwichProducts.get(holder.getAdapterPosition()).Quantity++;
                holder.textViewQuantity.setText(sandwichProducts.get(holder.getAdapterPosition()).Quantity + "");

                calculate();

            }
        });

        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sandwichProducts.get(holder.getAdapterPosition()).Quantity == 0) {
                    return;
                }

                sandwichProducts.get(holder.getAdapterPosition()).Quantity--;
                holder.textViewQuantity.setText(sandwichProducts.get(holder.getAdapterPosition()).Quantity + "");
                calculate();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailsActivity.class);
                intent.putExtra("sandwich", sandwichesMoudel);
                view.getContext().startActivity(intent);
            }
        });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                  new  AlertDialog.Builder(view.getContext())
                          .setTitle("Alert")
                          .setMessage("are you delete")
                          .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                              @Override
                              public void onClick(DialogInterface dialogInterface, int i) {
                                  sandwichProducts.remove(holder.getAdapterPosition());
                                  notifyItemRemoved(holder.getAdapterPosition());
                              }
                          })
                          .setNegativeButton("Cancel", null)
                          .setCancelable(true)
                          .show();
                    return false;
            }
    });



    }

    public void calculate(){

        int totalprice=0;
        for(int i=0; i<sandwichProducts.size(); i++){
            totalprice+=sandwichProducts.get(i).getPrize()* sandwichProducts.get(i).Quantity;
        }
        iTotalPrice.onpriceChanfe(totalprice);
    }

    @Override
    public int getItemCount() {
        return sandwichProducts.size();
    }


    class sandwichHolder extends RecyclerView.ViewHolder{
        ImageView imageViewproduct ;
        Button plus, minus;
        TextView textViewCoffeeName, textViewQuantity, textViewPrice;
        View layout;


        public sandwichHolder(@NonNull View itemView) {
            super(itemView);
            imageViewproduct=itemView.findViewById(R.id.image_product);
            plus=itemView.findViewById(R.id.button_plus);
            minus=itemView.findViewById(R.id.button_minnus);
            textViewCoffeeName=itemView.findViewById(R.id.name_product);
            textViewQuantity=itemView.findViewById(R.id.quantity);
            textViewPrice=itemView.findViewById(R.id.price);
            layout=itemView.findViewById(R.id.layout_id);
        }
    }

}