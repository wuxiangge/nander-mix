package com.cedar.design.pattern.creational.prototype;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhangnan
 * @date 2020-04-12 18:00
 * @description
 */
public class Pig implements Cloneable {

    private List<Date> updateList;

    @Override
    public Pig clone() throws CloneNotSupportedException {
        Pig clonePig = (Pig) super.clone();

        clonePig.updateList = new ArrayList<>(updateList);
        return clonePig;
    }

    public List<Date> getUpdateList() {
        return updateList;
    }

    public void setUpdateList(List<Date> updateList) {
        this.updateList = updateList;
    }
}
