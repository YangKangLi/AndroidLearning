package cn.com.ziquan.android.learning.lesson3.RecylerView;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import cn.com.ziquan.android.learning.lesson3.ListView.Fruit;
import cn.com.ziquan.android.learning.lesson3.R;

/**
 * Created by 万贤飞 on 2018/1/24.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    /**
     * Fruit类和fruit_item.xml.复用
     */

    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.imageview);
            textView = (TextView) view.findViewById(R.id.text_view);
        }
    }

    public FruitAdapter(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    //绑定
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.imageView.setImageResource(fruit.getImageId());
        holder.textView.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        Log.e("TAG", "个数" + mFruitList.size());
        return mFruitList.size();

    }
}
