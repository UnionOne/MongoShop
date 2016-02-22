package com.itibo.mongo.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by union on 22.02.2016.
 */

@ManagedBean
@SessionScoped
public class CollapsibleController {
    private boolean collapsed;

    @PostConstruct
    public void init() {
        this.collapsed = false;
    }

    public boolean isCollapsed() {
        return collapsed;
    }

    public void setCollapsed(boolean collapsed) {
        this.collapsed = collapsed;
    }

    @Override
    public String toString() {
        return "CollapsibleController{" +
                "collapsed=" + collapsed +
                '}';
    }
}