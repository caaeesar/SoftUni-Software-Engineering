package com.example.mobilelelewebapplication;

import com.example.mobilelelewebapplication.model.entity.BrandEntity;
import com.example.mobilelelewebapplication.model.entity.ModelEntity;
import com.example.mobilelelewebapplication.model.entity.RoleEntity;
import com.example.mobilelelewebapplication.model.entity.enums.Category;
import com.example.mobilelelewebapplication.model.entity.enums.RoleType;
import com.example.mobilelelewebapplication.repository.BrandRepository;
import com.example.mobilelelewebapplication.repository.ModelRepository;
import com.example.mobilelelewebapplication.repository.RoleRepository;
import com.example.mobilelelewebapplication.service.BrandService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BrandRepository brandRepository;
    private final BrandService brandService;
    private final RoleRepository roleRepository;
    private final ModelRepository modelRepository;

    public DataInitializer(BrandRepository brandRepository, ModelRepository modelRepository, BrandService brandService, RoleRepository roleRepository) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.brandService = brandService;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (roleRepository.count() == 0) {
            roleRepository.save(new RoleEntity(RoleType.USER));
            roleRepository.save(new RoleEntity(RoleType.ADMIN));
        }

        if (brandRepository.count() == 0 && modelRepository.count() == 0) {

            BrandEntity opel = BrandEntity.builder()
                    .name("Opel")
                    .created(LocalDateTime.now())
                    .build();
            brandRepository.save(opel);

            BrandEntity bmw = BrandEntity.builder()
                    .name("BMW")
                    .created(LocalDateTime.now())
                    .build();
            brandRepository.save(bmw);

            ModelEntity opelAdam = ModelEntity.builder()
                    .name("Adam")
                    .category(Category.CAR)
                    .startYear(2013)
                    .endYear(2019)
                    .brand(opel)
                    .imageUrl("https://dizzyriders.bg/uploads/thumbs/news/201502/1488/noviyat-opel-adam-s-n-stilna-malka-raket-620x427.jpg")
                    .created(LocalDateTime.now())
                    .build();
            modelRepository.save(opelAdam);

            ModelEntity opelAgila = ModelEntity.builder()
                    .name("Agila")
                    .category(Category.CAR)
                    .startYear(2000)
                    .endYear(2007)
                    .brand(opel)
                    .imageUrl("https://images.ams.bg/images/galleries/109591/opel-agila-1460796175_big.jpg")
                    .created(LocalDateTime.now())
                    .build();
            modelRepository.save(opelAgila);

            ModelEntity opelAgilaB = ModelEntity.builder()
                    .name("Agila B")
                    .category(Category.CAR)
                    .startYear(2008)
                    .endYear(2015)
                    .brand(opel)
                    .imageUrl("https://i.auto-bild.de/mdb/large/70/b-9ce.jpeg")
                    .created(LocalDateTime.now())
                    .build();
            modelRepository.save(opelAgilaB);

            ModelEntity opelAmpera = ModelEntity.builder()
                    .name("Ampera")
                    .category(Category.CAR)
                    .startYear(2011)
                    .brand(opel)
                    .imageUrl("https://automedia.investor.bg/media/files/resized/article/640x/525/dcfe2a1563407196172630088f400525-2012-06-wafdmg69j9v235h57xp1.jpg")
                    .created(LocalDateTime.now())
                    .build();
            modelRepository.save(opelAmpera);

            ModelEntity bmw5 = ModelEntity.builder()
                    .name("BMW 5")
                    .category(Category.CAR)
                    .startYear(1972)
                    .brand(bmw)
                    .imageUrl("https://www.bmw.bg/content/dam/bmw/common/all-models/5-series/sedan/2023/5-series-sedan-silver.png")
                    .created(LocalDateTime.now())
                    .build();
            modelRepository.save(bmw5);

            ModelEntity bmw6 = ModelEntity.builder()
                    .name("BMW 6")
                    .category(Category.CAR)
                    .startYear(2003)
                    .brand(bmw)
                    .imageUrl("https://www.bmw.bg/content/dam/bmw/common/all-models/6-series/gran-turismo/2021/highlights/bmw-6-series-gran-turismo-gallery-image-individual-02_1920.jpg.asset.1628852738385.jpg")
                    .created(LocalDateTime.now())
                    .build();
            modelRepository.save(bmw6);

            ModelEntity bmw7 = ModelEntity.builder()
                    .name("BMW 7")
                    .category(Category.CAR)
                    .startYear(1977)
                    .brand(bmw)
                    .imageUrl("https://webnews.bg/uploads/images/44/1444/571444/768x432.jpg?_=1650527727")
                    .created(LocalDateTime.now())
                    .build();
            modelRepository.save(bmw7);

            ModelEntity bmw8 = ModelEntity.builder()
                    .name("BMW 8")
                    .category(Category.CAR)
                    .startYear(2018)
                    .brand(bmw)
                    .imageUrl("https://www.bmw.bg/content/dam/bmw/common/all-models/8-series/gran-coupe/2022/navigation/bmw-8series-gran-coupe-modelfinder-stage2-890x501.png")
                    .created(LocalDateTime.now())
                    .build();
            modelRepository.save(bmw8);

            ModelEntity bmwF800S = ModelEntity.builder()
                    .name("F800S")
                    .category(Category.MOTORCYCLE)
                    .startYear(2006)
                    .endYear(2010)
                    .brand(bmw)
                    .imageUrl("https://mcn-images.bauersecure.com/wp-images/2921/1440x960/123133_bmw-f800s.jpg?mode=max&quality=90&scale=down")
                    .created(LocalDateTime.now())
                    .build();
            modelRepository.save(bmwF800S);

            ModelEntity bmwG11 = ModelEntity.builder()
                    .name("G11")
                    .category(Category.CAR)
                    .startYear(2015)
                    .brand(bmw)
                    .imageUrl("https://www.auto-data.net/images/f7/file5201463.jpg")
                    .created(LocalDateTime.now())
                    .build();
            modelRepository.save(bmwG11);

            opel.setModified(LocalDateTime.now());
            opel.setModels(List.of(opelAdam, opelAgila, opelAgilaB, opelAmpera));
            brandRepository.saveAndFlush(opel);

            bmw.setModified(LocalDateTime.now());
            bmw.setModels(List.of(bmw5, bmw6, bmw7, bmw8, bmwF800S, bmwG11));
            brandRepository.saveAndFlush(bmw);
        }
        brandService.getAllBrands();
    }
}
