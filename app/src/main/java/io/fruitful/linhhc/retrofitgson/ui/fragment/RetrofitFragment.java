package io.fruitful.linhhc.retrofitgson.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.fruitful.linhhc.retrofitgson.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RetrofitFragment extends Fragment {


    public RetrofitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_retrofit, container, false);
    }

}
