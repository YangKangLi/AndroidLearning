package cn.com.ziquan.android.learning.lesson3.ListView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

import cn.com.ziquan.android.learning.lesson3.R;

public class ListViewActivity extends AppCompatActivity {
    private List<Fruit> fruitList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initFruits();
        FruitAdapter adapter=new FruitAdapter(ListViewActivity.this,R.layout.fruit_item,fruitList);
        ListView listView=(ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);

    }
    private void initFruits() {
        for (int i=0;i<50;i++){
            Fruit apple=new Fruit("Apple",R.mipmap.apple);
            fruitList.add(apple);
            i++;
        }

    }
}
