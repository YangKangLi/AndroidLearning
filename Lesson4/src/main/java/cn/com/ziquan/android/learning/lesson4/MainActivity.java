package cn.com.ziquan.android.learning.lesson4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import cn.com.ziquan.android.learning.lesson4.section1.Section1Activity;
import cn.com.ziquan.android.learning.lesson4.section2.Section2Activity;
import cn.com.ziquan.android.learning.lesson4.section3.Section3Activity;

/**
 * Created by Administrator on 2018/1/24.
 */

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String[] SECTION_LIST = {
            "Section1：Fragment的简单用法",
            "Section2：动态添加Fragment",
            "Section3：Fragment与Activity之间通信"};

    private ListView lvSectionList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("第4章：Fragment");

        // 初始化章节列表
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, SECTION_LIST);
        lvSectionList = (ListView) findViewById(R.id.list_view);
        lvSectionList.setAdapter(adapter);
        lvSectionList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (position) {
            case 0:
                startActivity(new Intent(MainActivity.this, Section1Activity.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, Section2Activity.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity.this, Section3Activity.class));
                break;
        }
    }
}
