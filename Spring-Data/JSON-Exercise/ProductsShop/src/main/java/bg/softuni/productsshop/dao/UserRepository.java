package bg.softuni.productsshop.dao;

import bg.softuni.productsshop.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findUsersBySoldProductsBuyerIsNotNullOrderBySoldProductsBuyerLastName();

//    @Query("""
//SELECT u.firstName, u.lastName, u.age, p.name, p.price
//FROM User u
//JOIN u.productsSold ps
//JOIN ps.product p
//ORDER BY COUNT(ps) DESC, u.lastName ASC
//""")
    //List<UserCountDto> getUsersAndProductsInfo();

}
