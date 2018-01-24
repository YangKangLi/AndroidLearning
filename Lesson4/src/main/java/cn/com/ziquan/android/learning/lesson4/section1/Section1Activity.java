package cn.com.ziquan.android.learning.lesson4.section1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.com.ziquan.android.learning.lesson4.R;

public class Section1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section1);

        getSupportActionBar().setTitle("Fragment的简单用法");
    }
}
