package io.fruitful.linhhc.retrofitgson.api;

import io.fruitful.linhhc.retrofitgson.model.User;
import io.fruitful.linhhc.retrofitgson.ultils.Constant;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by haconglinh1990 on 19/08/2016.
 */
public interface IRetrofitAPI {
    @GET(Constant.URL_USER)
    Call<User> loadUser(@Query("userName") String userName, @Query("userPass") String userPass);
}

