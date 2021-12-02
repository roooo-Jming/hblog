package com.ruixin.bean;

import java.sql.Date;

/**
 * @Author Mingrui Ji
 * @CreateTime 7/29/21 1:00 AM
 * @Version 1.0.0
 */

public class PlayNews {
    private String title;
    private int type;
    private Date createDate;
    private String writer;
    private int read;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }
}
