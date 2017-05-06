package com.app.digitalfood.activities.view.interfaces;

import com.app.digitalfood.DataObject.CategoryData;
import com.app.digitalfood.DataObject.OfferData;

import java.util.List;

/**
 * Created by beyond on 07-Mar-17.
 */

public interface iOrderPage {

    void setMenuListinAdapter(List<CategoryData> menuList);
   // void setOfferList(List<OfferData> offerList);
    void setDiscription(boolean expand);
}
