public class ProdManager {

    protected ProdRepository repo;

    public ProdManager(ProdRepository repo) {
        this.repo = repo;
    }

    public void save(Product item) {
        repo.save(item);
    }

    public Product[] getItems() {
        return repo.getItems();
    }

    public void deleteById(int id) {
        repo.deleteById(id);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product item : repo.getItems()) {
            if (matches(item, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product item, String search) {
        if (item.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }


}
