package cn.com.ziquan.android.learning.lesson4.section2;

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

public class FirstFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.section_2_fragment_first, container, false);
        return view;
    }
}
