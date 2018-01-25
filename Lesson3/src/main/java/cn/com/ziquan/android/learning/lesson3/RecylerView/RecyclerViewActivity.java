package cn.com.ziquan.android.learning.lesson3.RecylerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.com.ziquan.android.learning.lesson3.ListView.Fruit;
import cn.com.ziquan.android.learning.lesson3.R;

public class RecyclerViewActivity extends AppCompatActivity {

    private List<Fruit> fruit=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);


        initFruits();//初始化水果数据
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recyler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter=new FruitAdapter(fruit);
        recyclerView.setAdapter(adapter);
    }

    private void initFruits() {
        for (int i=0;i<20;i++){
            Fruit apple=new Fruit("apple",R.mipmap.apple);
            fruit.add(apple);
            Fruit pear=new Fruit("pear",R.mipmap.pear);
            fruit.add(pear);
        }
    }
}
