package io.fruitful.linhhc.retrofitgson.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import io.fruitful.linhhc.retrofitgson.R;
import io.fruitful.linhhc.retrofitgson.ui.fragment.MainFragment;
import io.fruitful.linhhc.retrofitgson.ultils.Constant;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    Fragment mainFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        action();

        if (savedInstanceState == null) {

            mainFragment = new MainFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.main_frameLayout, mainFragment, Constant.MAIN_FRAGMENT_TAG)
                    .commit();

        } else {
            mainFragment = getSupportFragmentManager().findFragmentByTag(Constant.MAIN_FRAGMENT_TAG);
        }
    }



    private void init() {
        toolbar = (Toolbar) findViewById(R.id.activityMain_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void action() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

}
