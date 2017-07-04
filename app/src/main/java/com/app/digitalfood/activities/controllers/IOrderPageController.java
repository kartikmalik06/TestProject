package com.app.digitalfood.activities.controllers;

import com.app.digitalfood.DataObject.CategoryData;

import java.util.List;

/**
 * Created by beyond on 01-Jun-17.
 */

public interface IOrderPageController {

    void getMenuCategories(String branch_id);
    void setMenuList(List<CategoryData> menuList);
}
