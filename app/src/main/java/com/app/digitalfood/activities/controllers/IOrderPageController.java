package com.app.digitalfood.activities.controllers;

import com.app.digitalfood.DataObject.CategoryData;
import com.app.digitalfood.DataObject.MenuItemData;
import com.app.digitalfood.DataObject.OfferData;

import java.util.List;

/**
 * Created by beyond on 29-Mar-17.
 */

public interface IOrderPageController {

    void getMenuCategories(String branch_id);
    void setMenuList(List<CategoryData> menuList);

    void getOffers(String branchId);
    void setOffers(List<OfferData> offerDatas);
}
