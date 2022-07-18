package com.example.listview_test;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.List;

import adapter.MyAdapter;

public class MainActivity extends AppCompatActivity {

    private List<Data> mData = null;
    private Context mContext;
    private MyAdapter mAdapter;
    private ListView list_one;
    int flag = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);

        mContext = MainActivity.this;
        bindViews();
        mData = new LinkedList<Data>();
        mAdapter = new MyAdapter(mContext, (LinkedList<Data>) mData);
        list_one.setAdapter(mAdapter);

        findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.add(new Data(R.mipmap.guile, "太笨啦QAQ～～～ X " + flag));
                flag++;
            }
        });

        findViewById(R.id.add_button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.add(5, new Data(R.mipmap.guile, "太笨啦QAQ～～～ X " + flag));
                flag++;
            }
        });

        findViewById(R.id.remove_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mData.size() > 0) {
                    mAdapter.remove(mData.get(0));
                    flag--;
                } else {
                    Toast.makeText(mContext, "没有可以删除的记录啦～", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.remove_button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.remove(2);
                if (flag > 3) {
                    flag--;
                }
            }
        });
    }

    private void bindViews() {
        list_one = (ListView) findViewById(R.id.listView);
    }


}