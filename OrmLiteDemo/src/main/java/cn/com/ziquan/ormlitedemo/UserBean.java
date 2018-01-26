package cn.com.ziquan.ormlitedemo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2018/1/26.
 */

@DatabaseTable(tableName = "user")
public class UserBean {

    @DatabaseField(columnName = "id", id = true)
    private String id;

    @DatabaseField(columnName = "user")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
