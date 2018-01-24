package cn.com.ziquan.android.learning.lesson4.section2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.com.ziquan.android.learning.lesson4.R;

public class Section2Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section2);

        getSupportActionBar().setTitle("Fragment的简单用法");

        findViewById(R.id.btn_first_fragment).setOnClickListener(this);
        findViewById(R.id.btn_second_fragment).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_first_fragment:
                replaceFragment(new FirstFragment());
                break;
            case R.id.btn_second_fragment:
                replaceFragment(new SecondFragment());
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        // 模拟返回栈
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
