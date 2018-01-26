package cn.com.ziquan.lib.ormlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

/**
 * Created by Administrator on 2018/1/26.
 */

public class LibOrmLite {


    private static volatile LibOrmLite sInstance = new LibOrmLite();

    private Context mContext;

    private String mDatabaseName;

    private int mDatabaseVersion;

    private OnCreateDatabaseListener mOnCreateDatabaseListener;

    private OnUpgradeDatabaseListener mOnUpgradeDatabaseListener;

    private OrmLiteSqliteOpenHelper mOrmLiteSQLiteOpenHelper;


    public static LibOrmLite getInstance() {
        return sInstance;
    }


    private LibOrmLite() {

    }

    public LibOrmLite setContext(Context context) {
        mContext = context;
        return this;
    }

    public LibOrmLite setDatabaseName(String databaseName) {
        mDatabaseName = databaseName;
        return this;
    }

    public LibOrmLite setDatabaseVersion(int databaseVersion) {
        mDatabaseVersion = databaseVersion;
        return this;
    }

    public LibOrmLite setOnCreateDatabaseListener(OnCreateDatabaseListener onCreateDatabaseListener) {
        mOnCreateDatabaseListener = onCreateDatabaseListener;
        return this;
    }

    public LibOrmLite setOnUpgradeDatabaseListener(OnUpgradeDatabaseListener onUpgradeDatabaseListener) {
        mOnUpgradeDatabaseListener = onUpgradeDatabaseListener;
        return this;
    }


    public void init() {
        if (mOrmLiteSQLiteOpenHelper == null) {

            if (TextUtils.isEmpty(mDatabaseName)) {
                mDatabaseName = mContext.getPackageName().replace(".", "_") + ".db";
            }

            if (mDatabaseVersion < 1) {
                mDatabaseVersion = 1;
            }

            mOrmLiteSQLiteOpenHelper = new OrmLiteSqliteOpenHelper(mContext, mDatabaseName, null, mDatabaseVersion) {
                @Override
                public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
                    if (mOnCreateDatabaseListener != null) {
                        mOnCreateDatabaseListener.onCreate(sqLiteDatabase, connectionSource);
                    }
                }

                @Override
                public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int oldVersion, int newVersion) {
                    if (mOnUpgradeDatabaseListener != null) {
                        mOnUpgradeDatabaseListener.onUpgrade(sqLiteDatabase, connectionSource, oldVersion, newVersion);
                    }
                }
            };
        }
    }

    public <T, ID> DaoInterface<T, ID> getDaoInterface(Class<T> cls) {
        DaoInterface<T, ID> retDao = null;
        if (retDao == null) {
            synchronized (LibOrmLite.class) {
                if (retDao == null) {
                    retDao = new DaoInterface<>(cls);
                }
            }
        }
        return retDao;
    }

    public class DaoInterface<T, ID> {

        private Dao<T, ID> mORMLiteDao;

        private DaoInterface(Class<T> cls) {
            try {
                mORMLiteDao = mOrmLiteSQLiteOpenHelper.getDao(cls);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        public boolean insert(T t) throws SQLException {
            return mORMLiteDao.create(t) > 0;
        }

        public boolean delete(T t) throws SQLException {
            return mORMLiteDao.delete(t) > 0;
        }

        public boolean deleteById(ID id) throws SQLException {
            return mORMLiteDao.deleteById(id) > 0;
        }
    }
}
