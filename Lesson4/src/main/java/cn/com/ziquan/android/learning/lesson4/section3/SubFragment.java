package cn.com.ziquan.android.learning.lesson4.section3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.com.ziquan.android.learning.lesson4.R;
import cn.com.ziquan.android.learning.lesson4.section2.Section2Activity;

/**
 * Created by Administrator on 2018/1/24.
 */

public class SubFragment extends Fragment implements View.OnClickListener {

    private TextView tvResult;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.section_3_fragment_sub, container, false);
        intViews(view);
        return view;
    }

    private void intViews(View view) {
        tvResult = (TextView) view.findViewById(R.id.tv_result);
        view.findViewById(R.id.btn_send_msg).setOnClickListener(this);
    }

    public void showResult(int result) {
        tvResult.setText(String.valueOf(result));
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_send_msg) {
            Section3Activity activity = (Section3Activity) getActivity();
            activity.methodAdd(10, 12);
        }
    }
}
