package bg.softuni.bookshopsystem.service;

import java.io.IOException;

public interface CategoryService {

    boolean isDataSeeded();

    void seedCategories() throws IOException;

}
