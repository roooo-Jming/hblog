package com.ruixin.bean;

/**
 * @Author Mingrui Ji
 * @CreateTime 7/27/21 8:10 PM
 * @Version 1.0.0
 */

public class Focus {

    private Integer article_id;
    private String user_name;

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Focus(Integer article_id, String user_name) {
        this.article_id = article_id;
        this.user_name = user_name;
    }

    public Focus(){}
}
