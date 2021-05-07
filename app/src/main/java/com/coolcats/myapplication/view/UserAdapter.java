package com.coolcats.myapplication.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.coolcats.myapplication.R;
import com.coolcats.myapplication.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {


    private List<User> userList;


    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item_layout, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        User user = userList.get(position);

        Glide.with(holder.itemView)
                .setDefaultRequestOptions(RequestOptions.centerCropTransform())
                .load(user.getPicture().getLarge())
                .into(holder.imageView);
        holder.userName.setText(user.getName().getFirst());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        public TextView userName;
        public ImageView imageView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.first_name);
            imageView = itemView.findViewById(R.id.imageview);

        }
    }
}
