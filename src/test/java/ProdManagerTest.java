import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProdManagerTest {

    ProdRepository repo = new ProdRepository();
    ProdManager manager = new ProdManager(repo);

    Product item1 = new Product(12, "Random Product", 300);
    Product book1 = new Book(7, "Some Book", 400, "Author1");
    Product iPhone1 = new Smartphone(3225, "iPhoneX", 40000, "China");
    Product samsungA52 = new Smartphone(3117, "Samsung A52", 30000, "China");
    Product iPhone2 = new Smartphone(3157, "iPhone12", 50000, "China");
    Product item2 = new Product();

    @Test
    public void shouldAdd() {

        manager.save(item1);
        manager.save(book1);
        manager.save(iPhone1);

        Product[] expected = {item1, book1, iPhone1};
        Product[] actual = manager.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindIf1(){

        manager.save(samsungA52);
        manager.save(iPhone1);
        Product[] actual = manager.searchBy("Samsung A52");
        Product[] expected = {samsungA52};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindIf0(){

        manager.save(iPhone1);
        manager.save(iPhone2);

        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindIf2(){

        manager.save(iPhone1);
        manager.save(iPhone2);
        manager.save(samsungA52);

        Product[] actual = manager.searchBy("iPhone");
        Product[] expected = {iPhone1, iPhone2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById(){

        manager.save(item1);
        manager.save(item2);
        manager.save(book1);
        manager.save(iPhone1);

        manager.deleteById(7);

        Product[] actual = manager.getItems();
        Product[] expected = {item1, item2, iPhone1};

        Assertions.assertArrayEquals(expected, actual);
    }

}
