package io.fruitful.linhhc.retrofitgson.ui.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.fruitful.linhhc.retrofitgson.R;
import io.fruitful.linhhc.retrofitgson.adapter.LocationListAdapter;
import io.fruitful.linhhc.retrofitgson.data.GetDataLocation;
import io.fruitful.linhhc.retrofitgson.model.Result;

/**
 * A simple {@link Fragment} subclass.
 */
public class RetrofitFragment extends Fragment {

    RecyclerView recyclerViewLocation;
    LocationListAdapter locationListAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_retrofit, container, false);
        recyclerViewLocation = (RecyclerView) view.findViewById(R.id.recycleView_location);

        final ProgressDialog progressDialog = ProgressDialog.show(getActivity(), "Loading Data", "Please wait !!!", true);

        new GetDataLocation().getResultList(new GetDataLocation.LocationCallBack() {
            @Override
            public void onCompleted(List<Result> resultList) {
                locationListAdapter = new LocationListAdapter(getActivity(), resultList);
                recyclerViewLocation.setAdapter(locationListAdapter);
                progressDialog.dismiss();
            }
        });

        recyclerViewLocation.setHasFixedSize(true);
        recyclerViewLocation.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
