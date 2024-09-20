import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Product {
    private final String name;

    private final List<Product> childProducts = new ArrayList<>();

    private Product parent = null;

    public Product(String name) {
        this.name = name;
    }

    public boolean addProduct(Product p) {
        Product current = this.parent;
        while (current != null) {
            if (current.equals(p)) {
                return false;
            }
            current = current.parent;
        }
        this.childProducts.add(p);
        p.setParent(this);
        return true;
    }

    private void setParent(Product product) {
        this.parent = product;
    }

    public String getName() {
        return name;
    }

    public List<Product> getChildProducts() {
        return this.childProducts;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
