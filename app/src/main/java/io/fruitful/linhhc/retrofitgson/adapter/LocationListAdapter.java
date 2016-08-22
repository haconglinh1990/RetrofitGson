package io.fruitful.linhhc.retrofitgson.adapter;

import android.content.Context;
import android.location.Location;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import io.fruitful.linhhc.retrofitgson.R;
import io.fruitful.linhhc.retrofitgson.model.Result;
import io.fruitful.linhhc.retrofitgson.ultils.Constant;

/**
 * Created by haconglinh1990 on 22/08/2016.
 */
public class LocationListAdapter extends RecyclerView.Adapter<LocationListAdapter.LocationViewHolder>{
    Context context;
    List<Result> resultList;

    public LocationListAdapter(Context context, List<Result> resultList) {
        this.context = context;
        this.resultList = resultList;
    }

    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cardview_location, parent, false);

        return new LocationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LocationViewHolder holder, int position) {

        Result result = resultList.get(position);

        holder.nameATM.setText(result.getName());
        holder.addressATM.setText(result.getVicinity());

        if ((result.getOpeningHours() == null) || result.getOpeningHours().isOpenNow()) {
            holder.openStatus.setText("Open Now");
        } else {
            holder.openStatus.setText("Close Now");
        }

        Location myDinh = new Location("My Dinh");
        myDinh.setLatitude(Constant.LATITUDE_MY_DINH);
        myDinh.setLongitude(Constant.LONGTITUDE_MY_DINH);
        Location newLocation=new Location("New Location");
        newLocation.setLatitude(result.getGeometry().getLocation().getLat());
        newLocation.setLongitude(result.getGeometry().getLocation().getLng());
        String distance = String.format("%.02f", myDinh.distanceTo(newLocation));
        holder.distance.setText(distance + " m");

        if (result.getPhotos().size() == 0) {
            Picasso.with(context)
                    .load(result.getIcon())
                    .placeholder(R.drawable.voz6)
                    .error(R.drawable.voz5)
                    .into(holder.iconATM);
        } else {
            Picasso.with(context)
                    .load(Constant.BASE_URL +
                            "maps/api/place/photo?maxwidth=400&photoreference=" +
                            result.getPhotos().get(0).getPhotoReference() +
                            "&key=" + Constant.API_KEY)
                    .placeholder(R.drawable.voz6)
                    .error(R.drawable.voz5)
                    .into(holder.iconATM);
        }

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class LocationViewHolder extends RecyclerView.ViewHolder{
        public ImageView iconATM;
        TextView nameATM, addressATM, distance, openStatus;

        public LocationViewHolder(View itemView) {
            super(itemView);
            iconATM = (ImageView) itemView.findViewById(R.id.imageView_iconATM);
            nameATM = (TextView) itemView.findViewById(R.id.tv_nameATM);
            addressATM = (TextView) itemView.findViewById(R.id.tv_addressATM);
            openStatus = (TextView) itemView.findViewById(R.id.tv_openStatus);
            distance = (TextView) itemView.findViewById(R.id.tv_distance);
        }
    }

}
