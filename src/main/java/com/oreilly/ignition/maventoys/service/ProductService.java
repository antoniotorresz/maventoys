package com.oreilly.ignition.maventoys.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.oreilly.ignition.maventoys.model.CustomApiResponse;
import com.oreilly.ignition.maventoys.model.entity.Category;
import com.oreilly.ignition.maventoys.model.entity.Inventory;
import com.oreilly.ignition.maventoys.model.entity.Product;
import com.oreilly.ignition.maventoys.model.entity.Sale;
import com.oreilly.ignition.maventoys.repository.CategoryRepository;
import com.oreilly.ignition.maventoys.repository.InventoryRepository;
import com.oreilly.ignition.maventoys.repository.ProductRepository;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.EntityNotFoundException;

/**
 * This class represents a service for managing products.
 */
@Service
public class ProductService {
    /**
     * The repository for managing products.
     */
    private final ProductRepository productRepository;
    /**
     * The repository for managing inventory.
     */
    private final InventoryRepository inventoryRepository;
    /**
     * The repository for managing categories.
     */
    private final CategoryRepository categoryRepository;

    /**
     * Constructs a new instance of the ProductService class.
     *
     * @param productRepo   the product repository
     * @param inventoryRepo the inventory repository
     * @param categoryRepo  the category repository
     */
    @Autowired
    public ProductService(final ProductRepository productRepo, final InventoryRepository inventoryRepo,
            final CategoryRepository categoryRepo) {
        this.productRepository = productRepo;
        this.inventoryRepository = inventoryRepo;
        this.categoryRepository = categoryRepo;
    }

    /**
     * Finds products based on the specified criteria.
     *
     * @param page         the page number
     * @param limit        the maximum number of products per page
     * @param name         the name of the product
     * @param categoryName the name of the category
     * @param stock        the minimum stock quantity
     * @param active       the active status of the products
     * @return a CustomApiResponse containing the fetched products
     */
    public final CustomApiResponse find(final Integer page, final Integer limit, final String name,
            final String categoryName, final Integer stock,
            final Boolean active) {
        try {
            if (stock > 0) {
                return new CustomApiResponse("success", HttpStatus.OK.value(), "Products fetched successfully",
                        productRepository.findProductsByStock(stock));
            }
            if (active == null) {
                if (limit > 0) {
                    return new CustomApiResponse("success", HttpStatus.OK.value(), "Products fetched successfully",
                            productRepository.findAll(PageRequest.of(page, limit)).toList());
                } else {
                    return new CustomApiResponse("success", HttpStatus.OK.value(), "Products fetched successfully",
                            productRepository.findAll());
                }
            } else {
                return new CustomApiResponse("success", HttpStatus.OK.value(), "Products fetched successfully",
                        this.findByActive(active));
            }
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "An error ocurred while fetching products", e.toString());
        }
    }

    /**
     * Finds a product by its ID.
     *
     * @param id the ID of the product to find
     * @return a CustomApiResponse containing the fetched product
     */
    public CustomApiResponse findById(@NonNull final Integer id) {
        try {
            Product product = productRepository.findById(id).orElseThrow(
                    () -> new EntityNotFoundException("Product not found for ID: " + id));
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Product fetched successfully", product);
        } catch (EntityNotFoundException e) {
            return new CustomApiResponse("error", HttpStatus.NOT_FOUND.value(),
                    "An error ocurred while fetching product", e.toString());
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "An error ocurred while fetching product", e.toString());
        }
    }

    /**
     * Saves a product to the repository.
     *
     * @param product the product to save
     * @return a CustomApiResponse object representing the result of the save
     *         operation
     */
    public CustomApiResponse save(@NonNull final Product product) {
        try {
            return new CustomApiResponse("success", HttpStatus.CREATED.value(), "Product saved successfully",
                    productRepository.save(product));
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "An error ocurred while saving product", e.toString());
        }
    }

    /**
     * Updates a product by its ID.
     *
     * @param productId the ID of the product to update
     * @param product   the updated product object
     * @return a CustomApiResponse object representing the result of the update
     *         operation
     */
    public CustomApiResponse update(@NonNull final Integer productId, @NonNull final Product product) {
        try {
            Product existingProduct = productRepository.findById(productId).orElseThrow(
                    () -> new EntityNotFoundException("Product not found for ID: " + productId));
            existingProduct = product;
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Product updated successfully",
                    productRepository.save(existingProduct));
        } catch (EntityNotFoundException e) {
            return new CustomApiResponse("error", HttpStatus.NOT_FOUND.value(),
                    "An error ocurred while updating product", e.toString());
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "An error ocurred while updating product", e.toString());
        }
    }

    /**
     * Updates the price and cost of a product.
     *
     * @param productId the ID of the product to update
     * @param product   the updated product object
     * @return an Object representing the updated product
     */
    public CustomApiResponse updatePriceAndCost(@NonNull final Integer productId, @NonNull final Product product) {
        try {
            Product existingProduct = productRepository.findById(productId).orElseThrow(
                    () -> new EntityNotFoundException("Product not found for ID: " + productId));
            existingProduct.setPrice(product.getPrice());
            existingProduct.setCost(product.getCost());
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Product updated successfully",
                    productRepository.save(existingProduct));
        } catch (EntityNotFoundException e) {
            return new CustomApiResponse("error", HttpStatus.NOT_FOUND.value(),
                    "An error ocurred while updating product", e.toString());
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "An error ocurred while updating product", e.toString());
        }
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete
     * @return a CustomApiResponse object representing the result of the delete
     *         operation
     */
    public CustomApiResponse deleteById(@NonNull final Integer id) {
        try {
            Product product = productRepository.findById(id).orElseThrow(
                    () -> new EntityNotFoundException("Product not found for ID: " + id));
            product.setActive(false);
            productRepository.save(product);
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Product deleted successfully", null);
        } catch (EntityNotFoundException e) {
            return new CustomApiResponse("error", HttpStatus.NOT_FOUND.value(),
                    "An error ocurred while deleting product", e.toString());
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "An error ocurred while deleting product", e.toString());
        }
    }

    /**
     * Retrieves products by their active status.
     *
     * @param active the active status of the products to retrieve
     * @return a list of products matching the specified active status
     */
    public List<Product> findByActive(final Boolean active) {
        return productRepository.findAll()
                .stream().filter(p -> p.getActive() == active).toList();
    }

    /**
     * Updates the price and cost of a product.
     *
     * @param productId the ID of the product to update
     * @param price     the new price of the product
     * @param cost      the new cost of the product
     */
    public void updatePriceAndCost(final Integer productId, final Double price, final Double cost) {
        System.out.println("Updating price and cost for product " + productId + " to " + price + " and " + cost);
        productRepository.updatePriceAndCost(productId, price, cost);
    }

    /**
     * Retrieves products by their IDs.
     *
     * @param ids the IDs of the products to retrieve
     * @return a list of products matching the specified IDs
     */
    public List<Product> findByIds(final List<Integer> ids) {
        return productRepository.findByIdIn(ids);
    }

    /**
     * Finds products by stock level.
     *
     * @param stock the stock level to search for
     * @return a list of products with stock level equal to the given stock
     */
    public List<Object> findProductsByStock(final Integer stock) {
        List<Object> lowStockList = new ArrayList<>();
        for (Object[] lowStock : productRepository.findProductsByStock(stock)) {
            lowStockList.add(new HashMap<String, Object>() {
                {
                    put("id", lowStock[0]);
                    put("stockOnHand", lowStock[1]);
                }
            });
        }
        return lowStockList;
    }

    /**
     * Retrieves the total number of active products.
     *
     * @return the total number of active products
     */
    public Integer findTotalActiveProducts() {
        return productRepository.findTotalActiveProducts();
    }

    /**
     * Finds inventories by product ID.
     *
     * @param productId the ID of the product
     * @return the custom API response containing the inventories
     */
    public CustomApiResponse findInventoriesByProductId(@NonNull final Integer productId) {
        try {
            Product product = productRepository.findById(productId).orElseThrow(
                    () -> new EntityNotFoundException("Product not found for this id :: " + productId));
            List<Inventory> inventories = inventoryRepository.findByProductId(product.getId());
            HashMap<Object, Object> inventoryPerProduct = new HashMap<Object, Object>() {
                {
                    put("product", product);
                    put("totalStock", inventories.stream().mapToInt(Inventory::getStockOnHand).sum());
                    put("inventory", new ArrayList<Object>() {
                        {
                            for (Inventory inventory : inventories) {
                                add(new HashMap<Object, Object>() {
                                    {
                                        put("id", inventory.getId());
                                        put("stockOnHand", inventory.getStockOnHand());
                                    }
                                });
                            }
                        }
                    });
                }
            };
            return new CustomApiResponse("success", HttpStatus.OK.value(),
                    "Fetched all inventory of the product id: " + productId, inventoryPerProduct);
        } catch (EntityNotFoundException e) {
            return new CustomApiResponse("error", HttpStatus.NOT_FOUND.value(), e.getMessage(), null);
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
        }
    }

    /**
     * Finds the sales of a product by its ID.
     *
     * @param id The ID of the product.
     * @return A CustomApiResponse object containing the result of the operation.
     *         If the product is found, the response will contain the sales of the
     *         product.
     *         If the product is not found, the response will contain an error
     *         message.
     *         If an exception occurs, the response will contain an error message.
     */
    public CustomApiResponse findSalesByProductId(@NonNull final Integer id) {
        try {
            Product product = productRepository.findById(id).orElseThrow(
                    () -> new EntityNotFoundException("Product not found for this id :: " + id));
            List<Sale> sales = productRepository.findAllSalesWithInvoicesAndProducts(product.getId());
            return new CustomApiResponse("success", HttpStatus.OK.value(),
                    "Fetched all sales of the product id: " + id, sales);
        } catch (EntityNotFoundException e) {
            return new CustomApiResponse("error", HttpStatus.NOT_FOUND.value(), e.getMessage(), null);
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
        }
    }

    /**
     * Retrieves a list of the most sold products.
     *
     * @return A list of Object arrays representing the most sold products.
     */
    public CustomApiResponse findMostSoldProducts() {
        List<Object[]> topSold = productRepository.findMostSoldProducts();
        HashMap<Object, Object> bestSellers = new HashMap<Object, Object>() {
            {
                put("bestSellers", new ArrayList<Object>() {
                    {
                        for (Object[] productQuantity : topSold) {
                            add(new HashMap<Object, Object>() {
                                {
                                    put("product", productRepository.findById((Integer) productQuantity[0]).get());
                                    put("quantity", productQuantity[1]);
                                }
                            });
                        }
                    }
                });
            }
        };
        return new CustomApiResponse("success", HttpStatus.OK.value(), "Fetched the most sold products", bestSellers);
    }

    /**
     * Retrieves a list of the most sold products by category.
     *
     * @param name the name of the category
     * @return A list of Object arrays representing the most sold products by
     *         category.
     */
    public CustomApiResponse findMostSoldProductsByCategory(@NonNull final String name) {
        try {
            Optional<Category> category = categoryRepository.findByName(name);
            if (!category.isPresent()) {
                throw new EntityNotFoundException("Category not found for this name :: " + name);
            }
            List<Object[]> topSold = productRepository.findMostSoldProductsByCategory(category.get().getId());
            HashMap<Object, Object> bestSellers = new HashMap<Object, Object>() {
                {
                    put("bestSellers", new ArrayList<Object>() {
                        {
                            for (Object[] productQuantity : topSold) {
                                add(new HashMap<Object, Object>() {
                                    {
                                        put("product", productRepository.findById((Integer) productQuantity[0]).get());
                                        put("quantity", productQuantity[1]);
                                    }
                                });
                            }
                        }
                    });
                }
            };
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Fetched the most sold products by category",
                    bestSellers);
        } catch (EntityNotFoundException e) {
            return new CustomApiResponse("error", HttpStatus.NOT_FOUND.value(), e.getMessage(), null);
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
        }
    }

    /**
     * Performs a bulk cost price update using a CSV file.
     * @param csvFile the CSV file containing the data for the bulk update
     * @return a CustomApiResponse object representing the result of the bulk update
     * @throws FileNotFoundException if the specified file is not found
     * @throws IOException           if an I/O error occurs while reading the file
     */
    public CustomApiResponse bulkCostPriceUpdate(@NonNull final MultipartFile csvFile)
            throws FileNotFoundException, IOException {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH_mm_ss");
        String pathToSave = "src/main/resources/static/bulk_updates/product_bulk_" + currentTime.format(formatter)
                + ".csv";
        Files.write(Paths.get(pathToSave), csvFile.getBytes());
        int count;

        try (FileReader fileReader = new FileReader(pathToSave);
                CSVParser csvParser = CSVFormat.DEFAULT.withHeader().parse(fileReader)) {
            List<CSVRecord> records = csvParser.getRecords();
            count = records.size();
            for (CSVRecord row : records) {
                // Access each record's values using the header names
                System.out.println("Updating product " + row.get("id") + " to price " + row.get("price") + " and cost "
                        + row.get("cost"));
                this.updatePriceAndCost(Integer.parseInt(row.get("id")),
                        Double.parseDouble(row.get("price")), Double.parseDouble(row.get("cost")));
            }
            System.out.println("Finished updating " + count + " products");
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Bulk update successful",
                    "Updated " + count + " products");
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
        }
    }
}
