package com.app.digitalfood.activities.modals;

/**
 * Created by beyond on 01-Jun-17.
 */

public interface IModalOrderPage {
    void categoryList(String branch_id);
    void offerlist(String branch_id);
    void categoryItem(String branch_id, int categoryId);
}
