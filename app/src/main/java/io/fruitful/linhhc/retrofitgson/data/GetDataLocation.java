package io.fruitful.linhhc.retrofitgson.data;

import android.util.Log;

import java.util.List;

import io.fruitful.linhhc.retrofitgson.api.LocationService;
import io.fruitful.linhhc.retrofitgson.model.DataLocation;
import io.fruitful.linhhc.retrofitgson.model.Result;
import io.fruitful.linhhc.retrofitgson.ultils.Constant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by haconglinh1990 on 22/08/2016.
 */
public class GetDataLocation{

    public void getResultList(final LocationCallBack locationCallBack) {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .build();

        LocationService locationService = retrofit.create(LocationService.class);

        Call<DataLocation> dataLocation = locationService.loadLocation();
        dataLocation.enqueue(new Callback<DataLocation>() {
            @Override
            public void onResponse(Call<DataLocation> call, Response<DataLocation> response) {
                if (response.isSuccessful()) {
                    List<Result> resultList = response.body().getResults();
                    locationCallBack.onCompleted(resultList);
                }
            }

            @Override
            public void onFailure(Call<DataLocation> call, Throwable t) {
                Log.e("meomeo", t.getMessage());
            }

        });
    }

    public interface LocationCallBack {
        public void onCompleted(List<Result> resultList);
    }
}
