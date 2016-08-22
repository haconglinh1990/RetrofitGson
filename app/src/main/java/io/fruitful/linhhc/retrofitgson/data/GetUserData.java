package io.fruitful.linhhc.retrofitgson.data;

import android.app.Activity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import io.fruitful.linhhc.retrofitgson.model.User;
import io.fruitful.linhhc.retrofitgson.ultils.Constant;

/**
 * Created by haconglinh1990 on 19/08/2016.
 */
public class GetUserData {
    public List<User> users;

    private static final Type USER_TYPE = new TypeToken<List<User>>() {
    }.getType();


    public GetUserData(Activity activity){

        Gson gson = new Gson();

        InputStream input = null;
        Reader reader = null;
        try {
            input = activity.getAssets().open("userJson.txt");
            reader = new InputStreamReader(input, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        users = gson.fromJson(reader, USER_TYPE);


    }

    public List<User> getUsers() {
        return users;
    }
}
