package com.itibo.mongo.bean;

import com.itibo.mongo.model.UserModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by union on 15.02.2016.
 */

@ViewScoped
@ManagedBean
public class UserBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private int currentPage;
    private int pageItems;
    private UserModel searchModel;
    private List<UserModel> userModelList;
    private List<UserModel> users;

    @PostConstruct
    public void init() {
        currentPage = 0;
        pageItems = 3;
        searchModel = new UserModel();
        userModelList = new LinkedList<>();
        users = new LinkedList<>();

        users.add(new UserModel("1001", "Audio Album", "A Love Supreme", "Sony Music", "John Coltrane", ""));
        users.add(new UserModel("1002", "Audio Album", "Zdorovo i Vechno", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel("1003", "Audio Track", "Ivan Govnon", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel("1004", "Audio Track", "Pesnya pro Lenina", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel("1005", "Audio Track", "KGB-Rock", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel("1006", "Audio Album", "Na nachih glazah", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel("1007", "Audio Album", "Zdorovo i Vechno", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel("1008", "Audio Track", "Ivan Govnon", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel("1009", "Audio Track", "Pesnya pro Lenina", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel("1010", "Audio Track", "KGB-Rock", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel("1011", "Audio Album", "A Love Supreme", "Sony Music", "John Coltrane", ""));
        users.add(new UserModel("1012", "Audio Album", "Zdorovo i Vechno", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel("1013", "Audio Track", "Ivan Govnon", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel("1014", "Audio Track", "Pesnya pro Lenina", "Grob Records", "Egor Letov", "Egor Letov"));
        users.add(new UserModel("1015", "Audio Track", "KGB-Rock", "Grob Records", "Egor Letov", "Egor Letov"));
    }

    private boolean isEmptyRequest() throws IllegalAccessException {
        Field[] fields = UserModel.class.getDeclaredFields();
        boolean flag;

        for (Field field : fields) {
            flag = field.isAccessible();
            if (!flag) {
                field.setAccessible(true);
            }

            Object parameterValue = field.get(searchModel);
            if (parameterValue != null && !"".equals(parameterValue.toString())) {
                return false;
            }
            field.setAccessible(flag);
        }
        return true;
    }

    private boolean isEqual(UserModel user) throws IllegalAccessException {
        Field[] fields = UserModel.class.getDeclaredFields();
        boolean flag;
        boolean isEquals;
        for (Field field : fields) {
            flag = field.isAccessible();
            if (!flag) {
                field.setAccessible(true);
            }

            Object parameterValue = field.get(searchModel);
            Object userField = field.get(user);
            field.setAccessible(flag);

            isEquals = (parameterValue != null &&
                    (parameterValue.toString().isEmpty() ||
                            userField.toString().toLowerCase().contains(parameterValue.toString().toLowerCase())));

            if (!isEquals) {
                return false;
            }
        }
        return true;
    }

    public List<UserModel> applyFilter() throws IllegalAccessException {
        userModelList.clear();
        if (!isEmptyRequest()) {
            for (UserModel user : users) {
                if (isEqual(user)) {
                    userModelList.add(user);
                }
            }
            return userModelList;
        }
        userModelList.addAll(users);
        return userModelList;
    }

    public List<UserModel> getSubstringList() throws IllegalAccessException {
        List<UserModel> result = applyFilter();

        int startPosition = currentPage * pageItems;
        int endPosition = currentPage * pageItems + pageItems;
        if (endPosition > result.size()) {
            endPosition = result.size();
        }
        return result.subList(startPosition, endPosition);
    }

    public void action(AjaxBehaviorEvent event) throws AbortProcessingException {
        currentPage = (int) event.getComponent().getAttributes().get("index") - 1;
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

    public UserModel getSearchModel() {
        return searchModel;
    }

    public void setSearchModel(UserModel searchModel) {
        this.searchModel = searchModel;
    }

    public List<UserModel> getUserModelList() {
        return userModelList;
    }

    public void setUserModelList(List<UserModel> userModelList) {
        this.userModelList = userModelList;
    }
}