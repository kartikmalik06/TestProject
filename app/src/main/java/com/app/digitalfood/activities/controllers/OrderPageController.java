package com.app.digitalfood.activities.controllers;

import android.util.Log;

import com.app.digitalfood.DataObject.CategoryData;
import com.app.digitalfood.activities.modals.IModalCategoryMenu;
import com.app.digitalfood.activities.modals.IModalOrderPage;
import com.app.digitalfood.activities.modals.ModalCategoryMenu;
import com.app.digitalfood.activities.modals.ModalOrderPage;
import com.app.digitalfood.activities.view.CategoryMenu;
import com.app.digitalfood.activities.view.OrderPage;

import java.util.List;

/**
 * Created by beyond on 01-Jun-17.
 */

public class OrderPageController implements IOrderPageController {
    private OrderPage orderPage;
    private IModalOrderPage modalOrderPage;
    String branch_id;

    public OrderPageController(OrderPage orderPage) {
        this.orderPage = orderPage;
        modalOrderPage = new ModalOrderPage(this);
    }

    @Override
    public void getMenuCategories(String branch_id) {
        Log.d("State", "getMenuCategories()");
        this.branch_id=branch_id;
        modalOrderPage.categoryList(branch_id);
    }

    @Override
    public void setMenuList(List<CategoryData> menuList) {
        orderPage.setMenuListinAdapter(menuList);

    }
}
