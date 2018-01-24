package cn.com.ziquan.android.learning.lesson4.section1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.com.ziquan.android.learning.lesson4.R;

/**
 * Created by Administrator on 2018/1/24.
 */

public class LeftFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.section_1_fragment_left, container, false);
        return view;
    }
}
