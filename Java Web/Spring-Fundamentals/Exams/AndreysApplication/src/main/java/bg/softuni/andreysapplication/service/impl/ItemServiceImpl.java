package bg.softuni.andreysapplication.service.impl;

import bg.softuni.andreysapplication.model.entity.Item;
import bg.softuni.andreysapplication.model.service.ItemServiceModel;
import bg.softuni.andreysapplication.model.view.ItemDetailsViewModel;
import bg.softuni.andreysapplication.model.view.ItemViewModel;
import bg.softuni.andreysapplication.repository.CategoryRepository;
import bg.softuni.andreysapplication.repository.ItemRepository;
import bg.softuni.andreysapplication.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean createItem(ItemServiceModel itemServiceModel) {
        Optional<Item> itemByName = itemRepository.findItemByName(itemServiceModel.getName());
        if (itemByName.isPresent()) {
            return false;
        }

        Item item = modelMapper.map(itemServiceModel, Item.class);
        item.setCategory(categoryRepository.getCategoryByName(itemServiceModel.getCategory()));
        itemRepository.save(item);
        return true;
    }

    @Override
    public List<ItemViewModel> findAllItems() {
        List<Item> allItems = itemRepository.findAll();

        return allItems.stream()
                .map(item -> {
                    ItemViewModel itemViewModel = modelMapper.map(item, ItemViewModel.class);
                    itemViewModel.setImageUrl("/img/" + item.getGender() + "-" + item.getCategory().getName() + ".jpg");
                    return itemViewModel;
                })
                .toList();
    }

    @Override
    public ItemDetailsViewModel findItemDetailsById(String id) {
        Item item = itemRepository.getItemById(id);
        ItemDetailsViewModel itemDetailsViewModel = modelMapper.map(item, ItemDetailsViewModel.class);
        itemDetailsViewModel.setImageUrl("/img/" + item.getGender() + "-" + item.getCategory().getName() + ".jpg");
        return itemDetailsViewModel;
    }

    @Override
    public void deleteItemById(String id) {
        itemRepository.deleteById(id);
    }
}
