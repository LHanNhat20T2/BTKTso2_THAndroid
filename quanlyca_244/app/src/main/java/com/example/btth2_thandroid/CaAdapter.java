package com.example.btth2_thandroid;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class CaAdapter extends FirebaseRecyclerAdapter<Ca, CaAdapter.myViewHolder> {

    public CaAdapter(@NonNull FirebaseRecyclerOptions<Ca> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") int position, @NonNull Ca model) {
        holder.tenkhoc.setText(model.getSciencename());
        holder.tenthgoi.setText(model.getCommonname());
        holder.dactinh.setText(model.getCharacteristic());
        holder.mausac.setText(model.getColor());
        Glide.with(holder.img.getContext()).load(model.getSurl()).apply(new RequestOptions().override(55,55))
                .into(holder.img);
        //detail
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Detail.class);

                intent.putExtra("anh1", model.getSurl());
                intent.putExtra("science", model.getSciencename());
                intent.putExtra("commom", model.getCommonname());
                intent.putExtra("char", model.getCharacteristic());
                intent.putExtra("color", model.getColor());
                v.getContext().startActivity(intent);
            }
        });

//        Remove
        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.tenkhoc.getContext());
                builder.setTitle("Bạn có chắc chắn muốn xóa không?");
                builder.setMessage("Dữ liệu xóa không thể hoàn tác");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("Ca")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("Canel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(holder.tenkhoc.getContext(), "Canlled", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
        }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        CircleImageView img;
        TextView tenkhoc,tenthgoi,dactinh,mausac;
        ImageButton btnRemove;

        Button btnEdit,btnDelete;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (CircleImageView) itemView.findViewById(R.id.img1);
            tenkhoc = (TextView) itemView.findViewById(R.id.tvtenkhoahoc);
            tenthgoi = (TextView)  itemView.findViewById(R.id.tvtenthuongoi);
            dactinh = (TextView) itemView.findViewById(R.id.tvdactinh);
            mausac = (TextView) itemView.findViewById(R.id.tvmausac);
//            btnEdit = (Button) itemView.findViewById(R.id.btnEdit);
            btnRemove = (ImageButton) itemView.findViewById(R.id.imgbtnremove);

        }
}
}