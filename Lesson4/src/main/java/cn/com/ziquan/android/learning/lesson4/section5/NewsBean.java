package cn.com.ziquan.android.learning.lesson4.section5;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/24.
 */

public class NewsBean implements Serializable{

    private String title;

    private String content;

    public NewsBean(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
