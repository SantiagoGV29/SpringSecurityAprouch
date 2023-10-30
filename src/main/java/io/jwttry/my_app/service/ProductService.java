package io.jwttry.my_app.service;

import io.jwttry.my_app.domain.Product;
import io.jwttry.my_app.domain.User;
import io.jwttry.my_app.model.ProductDTO;
import io.jwttry.my_app.repos.ProductRepository;
import io.jwttry.my_app.repos.UserRepository;
import io.jwttry.my_app.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public ProductService(final ProductRepository productRepository,
            final UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public List<ProductDTO> findAll() {
        final List<Product> products = productRepository.findAll(Sort.by("id"));
        return products.stream()
                .map(product -> mapToDTO(product, new ProductDTO()))
                .toList();
    }

    public ProductDTO get(final Long id) {
        return productRepository.findById(id)
                .map(product -> mapToDTO(product, new ProductDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final ProductDTO productDTO) {
        final Product product = new Product();
        mapToEntity(productDTO, product);
        return productRepository.save(product).getId();
    }

    public void update(final Long id, final ProductDTO productDTO) {
        final Product product = productRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(productDTO, product);
        productRepository.save(product);
    }

    public void delete(final Long id) {
        productRepository.deleteById(id);
    }

    private ProductDTO mapToDTO(final Product product, final ProductDTO productDTO) {
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setUser(product.getUser() == null ? null : product.getUser().getId());
        return productDTO;
    }

    private Product mapToEntity(final ProductDTO productDTO, final Product product) {
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        final User user = productDTO.getUser() == null ? null : userRepository.findById(productDTO.getUser())
                .orElseThrow(() -> new NotFoundException("User not found"));
        product.setUser(user);
        return product;
    }

}
