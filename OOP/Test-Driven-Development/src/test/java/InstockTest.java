import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InstockTest {

    public static final double LOWER_RANGE = 50;
    public static final double HIGHER_RANGE = 100;
    private final String DEFAULT_LABEL = "Label";
    private final int DEFAULT_QUANTITY = 10;

    private Instock instock;
    private Product defaultProduct;

    @Before
    public void setUp() {
        this.instock = new Instock();
        this.defaultProduct = new Product(DEFAULT_LABEL, 0, 0);
    }

    @Test
    public void testGetCountWithZeroProducts() {
        assertEquals(0, instock.getCount());
    }

    @Test
    public void testGetCountWithSingleProduct() {
        instock.add(defaultProduct);
        assertEquals(1, instock.getCount());
    }

    @Test
    public void testGetCountWithMoreProducts() {
        int expectedCountProducts = 100;
        for (int i = 1; i <= expectedCountProducts; i++) {
            Product product = new Product(DEFAULT_LABEL + i, 0, 0);
            instock.add(product);
        }
        assertEquals(expectedCountProducts, instock.getCount());
    }

    @Test
    public void testAddWithOneNewProduct() {
        instock.add(defaultProduct);
        assertTrue(instock.contains(defaultProduct));
    }

    @Test
    public void testFindWithFirstProduct() {
        int firstIndex = 0;
        instock.add(defaultProduct);
        Product product = instock.find(firstIndex);
        assertEquals(defaultProduct, product);
    }

    @Test
    public void testFindWithLastProduct() {
        Product first = new Product("First", 0, 0);
        Product second = new Product("Second", 0, 0);
        Product last = new Product("Third", 0, 0);
        instock.add(first);
        instock.add(second);
        instock.add(last);
        int lastIndex = instock.getCount() - 1;
        Product actualLastProduct = instock.find(lastIndex);
        assertEquals(last, actualLastProduct);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindIfThrowWithInvalidIndex() {
        instock.add(defaultProduct);
        instock.find(-1);
    }

    @Test
    public void testChangeQuantityWithExistProduct() {
        Product product = new Product(DEFAULT_LABEL,0,0);
        instock.add(product);
        instock.changeQuantity(DEFAULT_LABEL,DEFAULT_QUANTITY);
        int actualQuantity = instock.find(0).getQuantity();
        assertEquals(DEFAULT_QUANTITY,actualQuantity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityWithNonExistProduct() {
        Product someProduct = new Product("Some Label",0,0);
        instock.add(someProduct);
        instock.changeQuantity(DEFAULT_LABEL,DEFAULT_QUANTITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityWithEmptyInstock() {
        instock.changeQuantity(DEFAULT_LABEL,DEFAULT_QUANTITY);
    }

    @Test
    public void testFindByLabelWithExistProduct() {
        instock.add(defaultProduct);
        Product actualProduct = instock.findByLabel(DEFAULT_LABEL);
        assertEquals(defaultProduct,actualProduct);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelShouldThrowWithNonExistProduct() {
        Product someProduct = new Product("Some Label",0,0);
        instock.add(someProduct);
        Product actualProduct = instock.findByLabel(DEFAULT_LABEL);
        assertEquals(defaultProduct,actualProduct);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderWithExactlyArg() {
        //Arrange
        int count = 4;
        Product dProduct = new Product("D",0,0);
        Product bProduct = new Product("B",0,0);
        Product cProduct = new Product("C",0,0);
        Product aProduct = new Product("A",0,0);
        //Act
        instock.add(aProduct);
        instock.add(bProduct);
        instock.add(cProduct);
        instock.add(dProduct);
        List<Product> sortedProducts =  addProducts(aProduct, bProduct, cProduct, dProduct);
        List<Product> expected = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            expected.add(sortedProducts.get(i));
        }
        //Assert
        assertEquals(expected,instock.findFirstByAlphabeticalOrder(count));
    }

    @Test
    public void testFindFirstByAlphabeticalOrderWithOneArg() {
        //Arrange
        int count = 1;
        Product dProduct = new Product("D",0,0);
        Product bProduct = new Product("B",0,0);
        Product cProduct = new Product("C",0,0);
        Product aProduct = new Product("A",0,0);
        //Act
        instock.add(aProduct);
        instock.add(bProduct);
        instock.add(cProduct);
        instock.add(dProduct);
        List<Product> sortedProducts =  addProducts(aProduct, bProduct, cProduct, dProduct);
        List<Product> expected = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            expected.add(sortedProducts.get(i));
        }
        //Assert
         assertEquals(expected,instock.findFirstByAlphabeticalOrder(count));
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollectionWithOutOfBoundArg() {
        Product dProduct = new Product("D",0,0);
        Product bProduct = new Product("B",0,0);
        Product cProduct = new Product("C",0,0);
        Product aProduct = new Product("A",0,0);

        instock.add(aProduct);
        instock.add(bProduct);
        instock.add(cProduct);
        instock.add(dProduct);

        int invalidCount = instock.getCount() + 1;
        Iterable<Product> empty = new ArrayList<>();
        assertEquals(empty,instock.findFirstByAlphabeticalOrder(invalidCount));
    }

    @Test
    public void testFindAllByQuantityWithGivenQuantity() {
        Product someProduct = new Product("C",0,0);
        Product firstProductWithSameQuantity = new Product("A",0,DEFAULT_QUANTITY);
        Product secondProductWithSameQuantity = new Product("B",0,DEFAULT_QUANTITY);
        Product thirdProductWithSameQuantity = new Product("C",0,DEFAULT_QUANTITY);

        instock.add(someProduct);
        instock.add(firstProductWithSameQuantity);
        instock.add(secondProductWithSameQuantity);
        instock.add(thirdProductWithSameQuantity);

        List<Product> productWithGivenQuantity = addProducts(firstProductWithSameQuantity,secondProductWithSameQuantity,thirdProductWithSameQuantity);
        assertEquals(productWithGivenQuantity,instock.findAllByQuantity(DEFAULT_QUANTITY));

    }

    @Test
    public void testFindAllByQuantityWithoutGivenQuantity() {
        Product someProduct = new Product("C",0,0);
        Product firstProductWithSameQuantity = new Product("A",0,0);
        Product secondProductWithSameQuantity = new Product("B",0,0);

        instock.add(someProduct);
        instock.add(firstProductWithSameQuantity);
        instock.add(secondProductWithSameQuantity);

        assertEquals(new ArrayList<>(),instock.findAllByQuantity(DEFAULT_QUANTITY));
    }

    @Test
    public void testFindAllInPriceRangeIfExclusiveLowerBoundShouldReturnEmptyCollection() {
        //(the lower end is exclusive, the higher end is inclusive)
        // (50;100]
        Product product = new Product(DEFAULT_LABEL,50,DEFAULT_QUANTITY);
        instock.add(product);
        assertEquals(new ArrayList<>(),instock.findAllInRange(LOWER_RANGE,HIGHER_RANGE));
    }

    @Test
    public void testFindAllInPriceRangeIfBiggerThanLowerBoundReturnCorrect() {
        //(the lower end is exclusive, the higher end is inclusive)
        // (50;100]
        Product product = new Product(DEFAULT_LABEL, LOWER_RANGE + 1,DEFAULT_QUANTITY);
        instock.add(product);
        List<Product> products = new ArrayList<>();
        products.add(product);
        assertEquals(products,instock.findAllInRange(LOWER_RANGE, HIGHER_RANGE));
    }

    @Test
    public void testFindAllInPriceRangeIfBiggerThanHigherBoundReturnEmptyCollection() {
        //(the lower end is exclusive, the higher end is inclusive)
        // (50;100]
        Product product = new Product(DEFAULT_LABEL, HIGHER_RANGE + 1,DEFAULT_QUANTITY);
        instock.add(product);
        assertEquals(new ArrayList<>(),instock.findAllInRange(LOWER_RANGE, HIGHER_RANGE));
    }

    @Test
    public void testFindAllInPriceRangeIfInclusiveHigherBoundReturnCorrect() {
        //(the lower end is exclusive, the higher end is inclusive)
        // (50;100]
        Product product = new Product(DEFAULT_LABEL, HIGHER_RANGE,DEFAULT_QUANTITY);
        instock.add(product);
        List<Product> products = new ArrayList<>();
        products.add(product);
        assertEquals(products,instock.findAllInRange(LOWER_RANGE, HIGHER_RANGE));
    }

    @Test
    public void testFindFirstMostExpensiveProductsIfHaveLessCountsThanExist() {
        int counts = 2;

        Product firstProduct = new Product("First Label", 70,0);
        Product secondProduct = new Product("Second Label", 50,0);
        Product thirdProduct = new Product("Third Label", 30,0);

        instock.add(firstProduct);
        instock.add(secondProduct);
        instock.add(thirdProduct);

        List<Product> products = addProducts(firstProduct,secondProduct);

        assertEquals(products,instock.findFirstMostExpensiveProducts(counts));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsShouldThrowIfHaveBiggerCountsThanExist() {
        int counts = 2;
        instock.add(defaultProduct);
        instock.findFirstMostExpensiveProducts(counts);
    }

    @Test
    public void testFindFirstMostExpensiveProductsIfHaveSameCountAsExist(){
        int counts = 2;
        Product firstProduct = new Product("First Label", 70,0);
        Product secondProduct = new Product("Second Label", 50,0);
        instock.add(firstProduct);
        instock.add(secondProduct);
        List<Product> products = addProducts(firstProduct,secondProduct);
        assertEquals(products,instock.findFirstMostExpensiveProducts(counts));
    }

    private List<Product> addProducts(Product... products) {
     return List.of(products);
    }
}
