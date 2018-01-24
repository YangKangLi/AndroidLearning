package cn.com.ziquan.android.learning.lesson4.section5;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.com.ziquan.android.learning.lesson4.R;

/**
 * Created by Administrator on 2018/1/24.
 */

public class NewsListFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView lvNewsList;

    private List<NewsBean> mNewsData = new ArrayList<>();

    private NewsAdapter mNewsAdapter;

    private boolean mIsTwoPane = false;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.section_5_fragment_news_list, container, false);
        initNews();
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.fragment_news_content) != null) {
            mIsTwoPane = true;
        }
    }

    private void initView(View view) {
        lvNewsList = (ListView) view.findViewById(R.id.list_view);
        mNewsAdapter = new NewsAdapter();
        lvNewsList.setAdapter(mNewsAdapter);
        lvNewsList.setOnItemClickListener(this);
    }

    private void initNews() {
        mNewsData.add(new NewsBean("第1条新闻", "第1条新闻的内容第1条新闻的内容第1条新闻的内容第1条新闻的内容第1条新闻的内容第1条新闻的内容第1条新闻的内容"));
        mNewsData.add(new NewsBean("第2条新闻", "第2条新闻的内容第2条新闻的内容第2条新闻的内容第2条新闻的内容第2条新闻的内容第2条新闻的内容第2条新闻的内容"));
        mNewsData.add(new NewsBean("第3条新闻", "第3条新闻的内容第3条新闻的内容第3条新闻的内容第3条新闻的内容第3条新闻的内容第3条新闻的内容第3条新闻的内容"));
        mNewsData.add(new NewsBean("第4条新闻", "第4条新闻的内容第4条新闻的内容第4条新闻的内容第4条新闻的内容第4条新闻的内容第4条新闻的内容第4条新闻的内容"));
        mNewsData.add(new NewsBean("第5条新闻", "第5条新闻的内容第5条新闻的内容第5条新闻的内容第5条新闻的内容第5条新闻的内容第5条新闻的内容第5条新闻的内容"));
        mNewsData.add(new NewsBean("第6条新闻", "第6条新闻的内容第6条新闻的内容第6条新闻的内容第6条新闻的内容第6条新闻的内容第6条新闻的内容第6条新闻的内容"));
        mNewsData.add(new NewsBean("第7条新闻", "第7条新闻的内容第7条新闻的内容第7条新闻的内容第7条新闻的内容第7条新闻的内容第7条新闻的内容第7条新闻的内容"));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (mIsTwoPane) {

        } else {
            Intent intent = new Intent(getActivity(), NewsContentActivity.class);
            intent.putExtra("NEW_BUNDLE", mNewsAdapter.getItem(position));
            startActivity(intent);
        }
    }

    class NewsAdapter extends ArrayAdapter<NewsBean> {

        public NewsAdapter() {
            super(getActivity(), android.R.layout.simple_list_item_1, mNewsData);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            NewsBean bean = getItem(position);
            View view = LayoutInflater.from(getActivity()).inflate(android.R.layout.simple_list_item_1, parent, false);
            TextView textView = (TextView) view.findViewById(android.R.id.text1);
            textView.setText(bean.getTitle());
            return view;
        }
    }
}
