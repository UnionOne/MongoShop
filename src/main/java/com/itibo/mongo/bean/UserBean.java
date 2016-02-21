package com.itibo.mongo.bean;

import com.itibo.mongo.model.UserModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by union on 15.02.2016.
 */

@ViewScoped
@ManagedBean(name = "users")
public class UserBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private int currentPage;
    private int pageItems;

    private List<UserModel> users;

    @PostConstruct
    public void init() {
        currentPage = 0;
        pageItems = 3;

        users = new LinkedList<>();
        users.add(new UserModel(1001, "Audio Album", "A Love Supreme", "Sony Music", "John Coltrane", ""));
        users.add(new UserModel(1002, "Audio Album", "Zdorovo i Vechno", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel(1003, "Audio Track", "Ivan Govnon", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel(1004, "Audio Track", "Pesnya pro Lenina", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel(1005, "Audio Track", "KGB-Rock", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel(1006, "Audio Album", "Na nachih glazah", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel(1007, "Audio Album", "Zdorovo i Vechno", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel(1008, "Audio Track", "Ivan Govnon", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel(1009, "Audio Track", "Pesnya pro Lenina", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel(1010, "Audio Track", "KGB-Rock", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel(1011, "Audio Album", "A Love Supreme", "Sony Music", "John Coltrane", ""));
        users.add(new UserModel(1012, "Audio Album", "Zdorovo i Vechno", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel(1013, "Audio Track", "Ivan Govnon", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel(1014, "Audio Track", "Pesnya pro Lenina", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel(1015, "Audio Track", "KGB-Rock", "Grob Records", "Egor Letov", "Egor Letov"));
    }

    public List<UserModel> getSubstringList() {
        int startPosition = currentPage * pageItems;
        int endPosition = currentPage * pageItems + pageItems;
        if(endPosition > users.size()) {
            endPosition = users.size();
        }
        return users.subList(startPosition, endPosition);
    }

    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageItems() {
        return pageItems;
    }

    public void setPageItems(int pageItems) {
        this.pageItems = pageItems;
    }

    public String save() {
        for (UserModel user : users) {
            user.setEditable(false);
        }
        return null;
    }

    public String edit(UserModel user) {
        user.setEditable(true);
        return null;
    }

    public void action(AjaxBehaviorEvent event) throws AbortProcessingException {
        currentPage = (int) event.getComponent().getAttributes().get("index") - 1;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "users=" + users +
                '}';
    }
}