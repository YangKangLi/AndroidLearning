package cn.com.ziquan.android.learning.lesson4.section5;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.com.ziquan.android.learning.lesson4.R;

/**
 * Created by Administrator on 2018/1/24.
 */

public class NewsContentFragment extends Fragment {

    private TextView tvNewsTitle;

    private TextView tvNewsContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.section_5_fragment_news_content, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        tvNewsTitle = (TextView) view.findViewById(R.id.tv_title);
        tvNewsContent = (TextView) view.findViewById(R.id.tv_content);
    }

    public void refresh(NewsBean newsBean) {
        tvNewsTitle.setText(newsBean.getTitle());
        tvNewsContent.setText(newsBean.getContent());
    }
}
