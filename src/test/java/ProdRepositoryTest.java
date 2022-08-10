import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProdRepositoryTest {

    ProdRepository repo = new ProdRepository();

    Product item1 = new Product(12, "Random Product", 300);
    Book book1 = new Book(7, "Some Book", 400, "Author1");
    Smartphone iPhone1 = new Smartphone(3225, "iPhoneX", 40000, "China");
    Product item2 = new Product();

    @Test
    public void shouldSetAndGetIdNamePriceWithoutConstructor() {

        item2.setId(17);

        int expected = 17;
        int actual = item2.getId();

        item2.setName("Glasses");

        String expected1 = "Glasses";
        String actual1 = item2.getName();

        item2.setPrice(1500);

        int expected2 = 1500;
        int actual2 = item2.getPrice();


        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);

    }

    @Test
    public void shouldSetAndGetAuthorForBookAndManufacturerForSmartphone() {

        book1.setAuthor("Hemingway");

        String expected = "Hemingway";
        String actual = book1.getAuthor();

        iPhone1.setManufacturer("China");

        String expected1 = "China";
        String actual1 = iPhone1.getManufacturer();

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expected1, actual1);
    }

    @Test
    public void shouldSave() {

        repo.save(item1);
        repo.save(item2);
        repo.save(book1);
        repo.save(iPhone1);

        Product[] expected = {item1, item2, book1, iPhone1};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {

        repo.save(book1);
        repo.save(iPhone1);

        repo.deleteById(7);

        Product[] expected = {iPhone1};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shallFindById() {

        repo.save(item1);

        repo.findById(12);

        Product[] expected = {item1};
        Product[] actual = repo.getItems();
        ///System.out.println(repo.getItems());
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shallDoException() {

        repo.save(item1);
        repo.save(item2);
        repo.save(book1);
        repo.save(iPhone1);

        Assertions.assertThrows(RuntimeException.class, () -> {
            repo.deleteById(999);

        });

    }



}
