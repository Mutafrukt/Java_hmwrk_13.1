public class ProdRepository {

    Product[] items = new Product[0];
    ///private Product[] items;

    public void save(Product item) {

        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Product findById(int id){

        ///int copyToIndex = 0;
        for(Product item : items){
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        if (findById(id) == null) {
            NotFoundException s = new NotFoundException("ID does not exist: " + id);
            throw new RuntimeException("ID does not exist: " + id);

        }
        Product[] tmp = new Product[items.length - 1];
        int copyToIndex = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }

    public Product[] getItems() {
        return items;
    }
}
