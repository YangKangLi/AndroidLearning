package cn.com.ziquan.lib.ormlite;

import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.support.ConnectionSource;

/**
 * Created by Administrator on 2018/1/26.
 */

public interface OnCreateDatabaseListener {

    void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource);
}
