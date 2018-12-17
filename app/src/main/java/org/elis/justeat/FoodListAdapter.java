package org.elis.justeat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class FoodListAdapter extends RecyclerView.Adapter {

    private LayoutInflater mInflater;
    private ArrayList<food> data;


    public FoodListAdapter(Context context, ArrayList<food> data){
        this.data = data;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View rowView = mInflater.inflate(R.layout.row, viewGroup,false);

        return new FoodViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        FoodViewHolder foodViewHolder = (FoodViewHolder)viewHolder;
        foodViewHolder.productName.setText(data.get(i).getName());
        foodViewHolder.productPrice.setText(data.get(i).getPrezzo());
        foodViewHolder.productQuantity.setText(data.get(i).getQuantità());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView productName, productPrice, productQuantity;
        public Button addBtn,removeBtn;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            productName=itemView.findViewById(R.id.item_name);
            productPrice=itemView.findViewById(R.id.item_price);
            productQuantity=itemView.findViewById(R.id.item_quantity);
            addBtn=itemView.findViewById(R.id.plus_btn);
            removeBtn=itemView.findViewById(R.id.minus_btn);

            addBtn.setOnClickListener(this);
            removeBtn.setOnClickListener(this);

        }

        public void addOne(TextView itemTotal){
            int item= Integer.valueOf(itemTotal.getText().toString());
            item= item+1;
            itemTotal.setText(String.valueOf(item));
        }

        public void removeOne(TextView itemTotal)  {
            int item = Integer.valueOf(itemTotal.getText().toString());
            if(item>0){
                item= item-1;
                itemTotal.setText(String.valueOf(item));
            }
        }

        @Override
        public void onClick(View view) {
            if(view.getId()==R.id.plus_btn){
                addOne(productQuantity);
            }else if (view.getId()==R.id.minus_btn){
                removeOne(productQuantity);
            }
        }
    }
}



