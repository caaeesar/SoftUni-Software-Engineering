package com.example.resellerapp.model.view;

import java.util.ArrayList;
import java.util.List;

public class OffersHomeViewModel {

    private List<MyOffersViewModel> myOffers = new ArrayList<>();

    private List<BoughtOffersViewModel> boughtOffers = new ArrayList<>();

    private List<OtherOffersViewModel> allOtherOffers = new ArrayList<>();


    public OffersHomeViewModel(List<MyOffersViewModel> myOffers, List<BoughtOffersViewModel> boughtOffers, List<OtherOffersViewModel> allOtherOffers) {
        this.myOffers = myOffers;
        this.boughtOffers = boughtOffers;
        this.allOtherOffers = allOtherOffers;
    }

    public OffersHomeViewModel() {
    }

    public List<MyOffersViewModel> getMyOffers() {
        return myOffers;
    }
    public void setMyOffers(List<MyOffersViewModel> myOffers) {
        this.myOffers = myOffers;
    }

    public List<BoughtOffersViewModel> getBoughtOffers() {
        return boughtOffers;
    }

    public void setBoughtOffers(List<BoughtOffersViewModel> boughtOffers) {
        this.boughtOffers = boughtOffers;
    }

    public List<OtherOffersViewModel> getAllOtherOffers() {
        return allOtherOffers;
    }

    public void setAllOtherOffers(List<OtherOffersViewModel> allOtherOffers) {
        this.allOtherOffers = allOtherOffers;
    }
}
