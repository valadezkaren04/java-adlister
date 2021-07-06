import java.util.ArrayList;
import java.util.List;

public class ListProducts implements Products{

    private List<Product> products = new ArrayList<>();

    public ListProducts() {
        //doesn't take any arguments ; gets all the database from within
        insert(new Product("Switch Pro Controller", 69.99));
        insert(new Product("Yoshi's Crafted World", 59.99));
        insert(new Product("Monster Hunter Rise", 59.99));
    }

    @Override
    public List<Product> all() {
        return this.products;
    }

    @Override
    public void insert(Product product) {
        this.products.add(product);

    }
}
