package bg.softuni.andreysapplication.service;

import bg.softuni.andreysapplication.model.service.ItemServiceModel;
import bg.softuni.andreysapplication.model.view.ItemDetailsViewModel;
import bg.softuni.andreysapplication.model.view.ItemViewModel;

import java.util.List;

public interface ItemService {
    boolean createItem(ItemServiceModel itemServiceModel);

    List<ItemViewModel> findAllItems();

    ItemDetailsViewModel findItemDetailsById(String id);

    void deleteItemById(String id);
}
