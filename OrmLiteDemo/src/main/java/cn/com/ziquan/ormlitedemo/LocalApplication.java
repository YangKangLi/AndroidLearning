package cn.com.ziquan.ormlitedemo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import cn.com.ziquan.lib.ormlite.LibOrmLite;
import cn.com.ziquan.lib.ormlite.OnCreateDatabaseListener;
import cn.com.ziquan.lib.ormlite.OnUpgradeDatabaseListener;

/**
 * Created by Administrator on 2018/1/26.
 */

public class LocalApplication extends Application {

    private static final String DB_NAME = "test.db";
    private static final int DB_VERSION = 2;

    @Override
    public void onCreate() {
        super.onCreate();

        LibOrmLite.getInstance().setContext(this)
                .setDatabaseName(DB_NAME)
                .setDatabaseVersion(DB_VERSION)
                .setOnCreateDatabaseListener(mOnCreateDatabaseListener)
                .setOnUpgradeDatabaseListener(mOnUpgradeDatabaseListener)
                .init();

    }

    private OnCreateDatabaseListener mOnCreateDatabaseListener = new OnCreateDatabaseListener() {
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
            // 自己执行需要创建的表
            try {
                TableUtils.createTableIfNotExists(connectionSource, UserBean.class);
                TableUtils.createTableIfNotExists(connectionSource, UserBean2.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    };

    private OnUpgradeDatabaseListener mOnUpgradeDatabaseListener = new OnUpgradeDatabaseListener() {
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int oldVersion, int newVersion) {
            // 自己执行要升级的表，字段等
            for (int version = oldVersion; version < newVersion; version++) {
                if (version == 1) {
                    if (mOnCreateDatabaseListener != null) {
                        mOnCreateDatabaseListener.onCreate(sqLiteDatabase, connectionSource);
                    }
                }
            }
        }
    };
}
