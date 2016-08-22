package io.fruitful.linhhc.retrofitgson.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.fruitful.linhhc.retrofitgson.R;
import io.fruitful.linhhc.retrofitgson.adapter.UserListAdapter;
import io.fruitful.linhhc.retrofitgson.data.GetUserData;
import io.fruitful.linhhc.retrofitgson.model.User;

public class JsonFragment extends Fragment {

    List<User> users;
    RecyclerView recyclerViewUser;
    UserListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_json, container, false);
        recyclerViewUser = (RecyclerView) view.findViewById(R.id.recycleView_user);

        users = new GetUserData(getActivity()).getUsers();

        adapter = new UserListAdapter(getActivity(), users);
        recyclerViewUser.setAdapter(adapter);
        recyclerViewUser.setHasFixedSize(true);
        recyclerViewUser.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }


}
