package io.fruitful.linhhc.retrofitgson.api;

import io.fruitful.linhhc.retrofitgson.model.DataLocation;
import io.fruitful.linhhc.retrofitgson.model.User;
import io.fruitful.linhhc.retrofitgson.ultils.Constant;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by haconglinh1990 on 19/08/2016.
 */
public interface LocationService {
    //https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=21.0280149,105.776591&radius=5000&type=atm&key=AIzaSyDVlukhCGF6TbSF6AAM58WyoNPKb0arzAQ
    @GET("maps/api/place/nearbysearch/json?location=21.0280149,105.776591&radius=5000&type=atm&key=AIzaSyDVlukhCGF6TbSF6AAM58WyoNPKb0arzAQ")
    Call<DataLocation> loadLocation();
}

