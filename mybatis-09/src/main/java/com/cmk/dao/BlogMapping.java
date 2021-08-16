package com.cmk.dao;

import com.cmk.bean.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapping {

    void addBlog(Blog blog);

    List<Blog> queryBlog(Map map);
}
