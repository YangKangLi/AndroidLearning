package cn.com.ziquan.android.learning.lesson4.section5;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.com.ziquan.android.learning.lesson4.R;

public class NewsContentActivity extends AppCompatActivity {

    private static final String KEY_NEWS_BEAN = "key_news_bean";

    public static void actionStart(Activity activity, NewsBean bean) {
        Intent intent = new Intent(activity, NewsContentActivity.class);
        intent.putExtra(KEY_NEWS_BEAN, bean);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section5_news_content);

        NewsBean newsBean = (NewsBean) getIntent().getSerializableExtra(KEY_NEWS_BEAN);

        NewsContentFragment fragment = (NewsContentFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_news_content);
        fragment.refresh(newsBean);

    }
}
