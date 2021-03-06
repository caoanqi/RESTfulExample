package com.caoyl.lfi.dao;

import com.caoyl.lfi.bean.IdeaBean;

import java.util.List;

public interface IdeaDao {
    public IdeaBean getIdeaById(String id);

    public boolean deleteIdeaById(String id);

    public boolean createIdea(IdeaBean ideaBean);

    public boolean updateIdea(IdeaBean ideaBean);

    public List<IdeaBean> getAllIdeas();
}
