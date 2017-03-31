package com.app.digitalfood.activities.controllers;

import com.app.digitalfood.activities.modals.IModalOffer;
import com.app.digitalfood.activities.modals.ModalOffer;
import com.app.digitalfood.activities.view.fragment.OfferFragment;

/**
 * Created by beyond on 30-Mar-17.
 */

public class OfferController implements IOfferController {
    private OfferFragment offerFragment;
    private IModalOffer modalOffer;

    public OfferController(OfferFragment offerFragment) {
        this.offerFragment = offerFragment;
        modalOffer = new ModalOffer(this);
    }



}
