package com.example.administrator.myapplication.floating.action;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

/**
 * Created by ChenHong on 2017/5/11.
 */

public class ShowFloatingAction extends Activity{
    private Toolbar toolBar;
    private RecyclerView mRecycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_floating_action_layout);
        toolBar = (Toolbar) findViewById(R.id.toolBar);
        toolBar.getMenu().add("巡防记录").setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        mRecycleView = (RecyclerView) findViewById(R.id.data_recycleview);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView.setAdapter(new DataAdapter());
    }

    class DataAdapter extends RecyclerView.Adapter<MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(getLayoutInflater().inflate(R.layout.activity_item, parent, false));
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 5;
        }
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView view;
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
