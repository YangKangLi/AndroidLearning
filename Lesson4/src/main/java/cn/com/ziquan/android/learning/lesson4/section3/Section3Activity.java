package cn.com.ziquan.android.learning.lesson4.section3;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.com.ziquan.android.learning.lesson4.R;

public class Section3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section3);

        getSupportActionBar().setTitle("Fragment与Activity之间通信");
    }

    public void methodAdd(int a, int b) {
        int result = a + b;
        showResultInFragment(result);
    }

    private void showResultInFragment(int result) {
        SubFragment subFragment = (SubFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_sub);
        subFragment.showResult(result);
    }
}
