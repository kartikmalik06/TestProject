package com.app.digitalfood.activities.modals;

/**
 * Created by beyond on 29-Mar-17.
 */

public interface IModalCategoryMenu {

    void categoryList(String branch_id);
    void offerlist(String branch_id);
    void categoryItem(String branch_id, int categoryId);
}
