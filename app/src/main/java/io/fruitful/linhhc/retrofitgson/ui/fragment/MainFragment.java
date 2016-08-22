package io.fruitful.linhhc.retrofitgson.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import io.fruitful.linhhc.retrofitgson.R;
import io.fruitful.linhhc.retrofitgson.ultils.Constant;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    Fragment jsonFragment, retrofitFragment;

    Button goToJsonFragment, goToRetrofitFragment;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        goToJsonFragment = (Button) view.findViewById(R.id.btn_goToJsonFragment);
        goToRetrofitFragment = (Button) view.findViewById(R.id.btn_goToRetrofitFragment);

        action();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {

        }

    }

    private void action() {
        goToJsonFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToJsonFragment();
            }
        });

        goToRetrofitFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRetrofitFragment();
            }
        });
    }

    private void goToJsonFragment() {
        jsonFragment = new JsonFragment();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_frameLayout, jsonFragment, Constant.JSON_FRAGMENT_TAG)
                .addToBackStack(Constant.JSON_FRAGMENT_TAG)
                .commit();
    }

    private void goToRetrofitFragment() {
        retrofitFragment = new RetrofitFragment();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_frameLayout, retrofitFragment, Constant.RETROFIT_FRAGMENT_TAG)
                .addToBackStack(Constant.RETROFIT_FRAGMENT_TAG)
                .commit();
    }



}
