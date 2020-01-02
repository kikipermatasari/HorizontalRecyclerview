package com.kominfo.pp.horizontalrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.AsyncTask;
import android.os.Bundle;

import com.kominfo.pp.horizontalrecyclerview.adapter.TestAdapter;
import com.kominfo.pp.horizontalrecyclerview.model.TestModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = "MainActivity";
    RecyclerView recyclerView;
    SwipeRefreshLayout swipe;
    private TestAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private ArrayList<TestModel> listDataArrayList = new ArrayList<TestModel>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);

        adapter = new TestAdapter(listDataArrayList, this);

        //layoutManager = new LinearLayoutManager(this);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        //layoutManager = new GridLayoutManager(getApplicationContext(),2);

        layoutManager.setAutoMeasureEnabled(true);

        recyclerView.setHasFixedSize(false);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

        swipe   = (SwipeRefreshLayout)findViewById(R.id.swipe_refresh_layout);

        // menamilkan widget refresh
        swipe.setOnRefreshListener(this);

        swipe.post(new Runnable() {
                       @Override
                       public void run() {
                           swipe.setRefreshing(true);
                           listDataArrayList.clear();
                           adapter.notifyDataSetChanged();
                           new loadData().execute();
                       }
                   }
        );
    }

    @Override
    public void onRefresh() {
        listDataArrayList.clear();
        adapter.notifyDataSetChanged();
        new loadData().execute();
    }

    private class loadData extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... args) {
            readData();
            return null;
        }
    }

    private void readData(){
        listDataArrayList.add(new TestModel(R.drawable.ic_launcher_background,"Title1"));
        listDataArrayList.add(new TestModel(R.drawable.ic_launcher_background,"Title2"));
        listDataArrayList.add(new TestModel(R.drawable.ic_launcher_background,"Title3"));
        listDataArrayList.add(new TestModel(R.drawable.ic_launcher_background,"Title4"));
        listDataArrayList.add(new TestModel(R.drawable.ic_launcher_background,"Title5"));
        adapter.notifyDataSetChanged();
        swipe.setRefreshing(false);
    }
}
