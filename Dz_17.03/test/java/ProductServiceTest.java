import org.example.ProductBusinessImpl;
import org.example.ProductService;
import org.example.ProductServiceStub;

import java.util.List;

public class ProductServiceTest {
    public static void main(String[] args) {
        ProductService productService = new ProductServiceStub();
        ProductBusinessImpl productBusiness = new ProductBusinessImpl(productService);

        List<String> availableProducts = productBusiness.getAvailableProducts("TestUser");
        System.out.println("Available Products:\n" + availableProducts);
    }
}
