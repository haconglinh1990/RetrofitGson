package io.fruitful.linhhc.retrofitgson.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import io.fruitful.linhhc.retrofitgson.R;
import io.fruitful.linhhc.retrofitgson.model.User;

/**
 * Created by haconglinh1990 on 19/08/2016.
 */
public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {
    Context context;
    private List<User> users;

    public UserListAdapter(Context context, List<User> users) {
        this.users = users;
        this.context = context;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cardview_user, parent, false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = users.get(position);

        holder.firstName.setText(user.getFirstName());
        holder.userDetail.setText(user.getUserDetailInfo());
        Picasso.with(context)
                .load(user.getUriImageUser())
                .placeholder(R.drawable.voz6)
                .error(R.drawable.voz5)
                .into(holder.imageUser);

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageUser;
        TextView firstName, userDetail;

        public UserViewHolder(View itemView) {
            super(itemView);
            imageUser = (ImageView) itemView.findViewById(R.id.imageView_imageUser);
            firstName = (TextView) itemView.findViewById(R.id.tv_firstName);
            userDetail = (TextView) itemView.findViewById(R.id.tv_userDetailInfo);
        }
    }

}
