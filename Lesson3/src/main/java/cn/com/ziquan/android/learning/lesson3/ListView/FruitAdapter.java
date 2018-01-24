package cn.com.ziquan.android.learning.lesson3.ListView;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import cn.com.ziquan.android.learning.lesson3.R;

/**
 * Created by 万贤飞 on 2018/1/24.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;

    public FruitAdapter(@NonNull Context context, @IdRes int textViewResourceId, @NonNull List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        /*
        *
        * convertView 这个参数用于将之以前加载号得布局进行缓存，以便以后可以进行重复使用(优化list view)
        * */
//        Fruit fruit= (Fruit) getItem(position);//实例
//        View view;
//        if (convertView==null){
//            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
//        }else {
//            view=convertView;
//        }
//        ImageView imageView= (ImageView) view.findViewById(R.id.imageview);
//        TextView fruitName=(TextView)view.findViewById(R.id.text_view);
//        imageView.setImageResource(fruit.getImageId());
//        fruitName.setText(fruit.getName());
//        return view;

        //继续优化
        Fruit fruit = (Fruit) getItem(position);//实例
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.imageview);
            viewHolder.fruitName = (TextView) view.findViewById(R.id.text_view);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.imageView.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());

        return view;
    }
    private class ViewHolder {
        ImageView imageView;
        TextView fruitName;
    }
}
