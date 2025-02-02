package webshop;

public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public void saleProduct(long id, int amount){
        Product product=productRepository.findProductById(id);
        if (product.getStock()<amount){
            throw new IllegalArgumentException("Not enough!");
        }
        productRepository.updateProductStock(id,amount);
    }
}
