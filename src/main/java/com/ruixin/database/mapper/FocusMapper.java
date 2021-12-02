package com.ruixin.database.mapper;

import com.ruixin.bean.Focus;
import com.ruixin.bean.News;
import com.ruixin.bean.PlayNews;
import com.ruixin.bean.User;
import com.ruixin.database.data.DisplayFocus;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author Mingrui Ji
 * @CreateTime 7/27/21 8:08 PM
 * @Version 1.0.0
 */

public interface FocusMapper {

    @Insert("insert into h_focus(user_name,article_id)"+" values(#{user_name},#{article_id})")
    void addFocus(Focus focus)throws Exception;

    @Select("select * from h_focus where article_id=#{article_id} and user_name=#{user_name}")
    Focus query(Focus focus) throws Exception;

    @Select("select h_news.title,h_type.name,h_user.username,h_news.read from h_focus,h_news,h_type,h_user where h_user.id=h_news.create_by and h_focus.article_id=h_news.id and h_news.type_id=h_type.id and user_name=#{user_focus}")
    List<DisplayFocus> queryAll(String user_focus);
}
