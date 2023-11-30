package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GunRepository implements Repository<Gun> {

    private Collection<Gun> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return this.models;
    }

    @Override
    public void add(Gun model) {
       Gun search = this.models.stream().filter(g -> g.equals(model)).findFirst().orElse(null);
       if (search == null) {
           this.models.add(model);
       }
    }

    @Override
    public boolean remove(Gun model) {
        return this.models.remove(model);
    }

    @Override
    public Gun find(String name) {
        return this.models.stream().filter(g -> g.getName().equals(name)).findFirst().get();
    }
}
