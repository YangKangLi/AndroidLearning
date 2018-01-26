package cn.com.ziquan.ormlitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.sql.SQLException;

import cn.com.ziquan.lib.ormlite.LibOrmLite;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        LibOrmLite.DaoInterface<UserBean> dao = LibOrmLite.getInstance().getDaoInterface(UserBean.class);
//        try {
//            UserBean userBean = new UserBean();
//            userBean.setId("112");
//            userBean.setName("Adam");
//            dao.insert(userBean);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        LibOrmLite.DaoInterface<UserBean2, Integer> dao2 = LibOrmLite.getInstance().getDaoInterface(UserBean2.class);
        try {
            UserBean2 userBean2 = new UserBean2();
            userBean2.setName("Adam");
            dao2.insert(userBean2);
            //dao2.deleteById(2);

            //LibOrmLite.getInstance().getDaoInterface(UserBean2.class).deleteById(3);
            LibOrmLite.getInstance().getDaoInterface(UserBean2.class).deleteById(userBean2.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

