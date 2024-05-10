package com.oreilly.ignition.maventoys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.oreilly.ignition.maventoys.model.CustomApiResponse;
import com.oreilly.ignition.maventoys.repository.EmployeeRepository;
import com.oreilly.ignition.maventoys.repository.ProductRepository;
import com.oreilly.ignition.maventoys.repository.SaleRepository;
import com.oreilly.ignition.maventoys.repository.StoreRepository;

@Service
public class AnaliticsService {
    /**
     * The repository for managing sales data.
     */
    private final SaleRepository saleRepository;
    /**
     * The repository for managing product data.
     */
    private final ProductRepository productRepository;
    /**
     * The repository for managing employee data.
     */
    private final EmployeeRepository employeeRepository;
    /**
     * The repository for managing stores data.
     */
    private final StoreRepository storeRepository;

    /**
     * Constructs an instance of the AnalyticsService.
     *
     * @param saleRepo     the repository for managing sales data.
     * @param productRepo  the repository for managing product data.
     * @param employeeRepo the repository for managing employee data.
     * @param storeRepo    the repository for managing stores data.
     */
    @Autowired
    public AnaliticsService(final SaleRepository saleRepo, final ProductRepository productRepo,
            final EmployeeRepository employeeRepo, final StoreRepository storeRepo) {
        this.saleRepository = saleRepo;
        this.productRepository = productRepo;
        this.employeeRepository = employeeRepo;
        this.storeRepository = storeRepo;
    }

    /**
     * Retrieves the total number of active products.
     *
     * @return An object containing the total number of active products.
     */
    public CustomApiResponse getTotalActiveProducts() {
        try {
            return new CustomApiResponse("success", HttpStatus.OK.value(),
                    "Fetched active products amount successfully",
                    new HashMap<String, Integer>() {
                        {
                            put("totalActiveProducts", productRepository.findTotalActiveProducts());
                        }
                    });
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error while fetching active products amount", e.toString());
        }
    }

    /**
     * Retrieves the best-selling products.
     *
     * @return a list of best-selling products, where each product is represented as
     *         a map with "productId" and "quantity" keys.
     */
    public CustomApiResponse getBestSellingProducts() {
        try {
            List<Object> bestSellingProducts = new ArrayList<>();
            for (Object productQ : productRepository.findMostSoldProducts()) {
                Object[] productQuantity = (Object[]) productQ;
                bestSellingProducts.add(new HashMap<String, Object>() {
                    {
                        put("productId", productQuantity[0]);
                        put("quantity", productQuantity[1]);
                    }
                });
            }
            return new CustomApiResponse("success", HttpStatus.OK.value(),
                    "Best selling products retrieved successfully",
                    bestSellingProducts);
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error while trying to fetch best sellers", e.toString());
        }
    }

    /**
     * Retrieves the stock of products based on the specified value.
     *
     * @param stock the minimum stock value to filter the products (optional,
     *              default value is 0)
     * @return an Object containing the products with stock greater than or equal to
     *         the specified value
     */
    public CustomApiResponse getStock(@NonNull final Integer stock) {
        try {
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Stock retrieved successfully",
                    productRepository.findProductsByStock(stock));
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error while trying to get the stock amount", e.toString());
        }
    }

    /**
     * Retrieves the total sales.
     *
     * @return An object containing the total sales.
     */
    public CustomApiResponse getTotalSales() {
        try {
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Number of sales retrieved successfully",
                    new HashMap<String, Integer>() {
                        {
                            put("totalSales", saleRepository.findTotalSales());
                        }
                    });
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "A unexpected error happened while getting total sales", e.toString());
        }
    }

    /**
     * Retrieves a list of employees with the most sales.
     *
     * @return A list of employees with their employee ID, full name, and total
     *         sales.
     */
    public CustomApiResponse getEmployeesWithMostSales() {
        try {
            List<Object> employeesWithMostSales = new ArrayList<>();
            for (Object object : employeeRepository.findEmployeesWithMostSales()) {
                employeesWithMostSales.add(new HashMap<String, Object>() {
                    {
                        put("employeeId", ((Object[]) object)[0]);
                        put("fullName", ((Object[]) object)[1]);
                        put("totalSales", ((Object[]) object)[2]);
                    }
                });
            }
            return new CustomApiResponse("success", HttpStatus.OK.value(),
                    "Fetching employees with most sales successfully",
                    employeesWithMostSales);
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "A unexpected error happened while getting employees with most sales", e.toString());
        }
    }

    /**
     * Retrieves the total revenue.
     *
     * @return An object containing the total revenue.
     */
    public CustomApiResponse getTotalRevenue() {
        try {
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Got total revenue successfully",
                    new HashMap<String, Double>() {
                        {
                            put("totalRevenue", saleRepository.getTotalRevenue());
                        }
                    });
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "A unexpected error happened while getting total revenue", e.toString());
        }
    }

    /**
     * Retrieves the most sold categories.
     *
     * @return a list of objects representing the most sold categories, each
     *         containing the category ID, name, and count.
     */
    public CustomApiResponse getMostSoldCategories() {
        try {
            List<Object> mostSoldCategories = new ArrayList<>();
            for (Object object : saleRepository.findMostSoldCategories()) {
                mostSoldCategories.add(new HashMap<String, Object>() {
                    {
                        put("categoryId", ((Object[]) object)[0]);
                        put("name", ((Object[]) object)[1]);
                        put("categoryCount", ((Object[]) object)[2]);
                    }
                });
            }
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Got most sold categories successfully",
                    mostSoldCategories);
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "A unexpected error happened while getting most sold categories", e.toString());
        }
    }

    /**
     * Retrieves the stores information.
     *
     * @return an Object containing the total number of stores
     */
    public CustomApiResponse getStores() {
        try {
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Active stores retrieved successfully",
                    new HashMap<String, Integer>() {
                        {
                            put("totalStores", storeRepository.getTotalStores());
                        }
                    });
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "A unexpected error happened while getting total stores", e.toString());
        }
    }

    /**
     * Retrieves the total number of items sold.
     *
     * @return An object containing the total number of items sold.
     */
    public CustomApiResponse getTotalItemsSold() {
        try {
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Successfully retrieved total items sold",
                    new HashMap<String, Integer>() {
                        {
                            put("totalItemsSold", saleRepository.findTotalItemsSold());
                        }
                    });
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "A unexpected error happened while getting total items sold", e.toString());
        }
    }

    /**
     * Retrieves the revenue per store.
     *
     * @return An object representing the revenue per store.
     */
    public CustomApiResponse getRevenueByStore() {
        try {
            List<Object> revenueByStore = new ArrayList<>();
            for (Object object : storeRepository.getRevenueByStore()) {
                revenueByStore.add(new HashMap<String, Object>() {
                    {
                        put("name", ((Object[]) object)[0]);
                        put("revenue", ((Object[]) object)[1]);
                    }
                });
            }
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Successfully retrieved revenue by store",
                    revenueByStore);
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "A unexpected error happened while getting revenue by store", e.toString());
        }
    }

    /**
     * Retrieves the last invoices based on the specified limit.
     *
     * @param limit the maximum number of invoices to retrieve (default: 50)
     * @return a list of objects representing the last invoices
     */
    public CustomApiResponse getLastInvoices(@NonNull final Integer limit) {
        try {
            List<Object> lastInvoices = new ArrayList<>();
            final int invoiceIdIndex = 0;
            final int productIdIndex = 1;
            final int quantityIndex = 2;
            final int saleIdIndex = 3;
            for (Object object : saleRepository.findLastInvoices(limit)) {
                Object[] invoice = (Object[]) object;
                lastInvoices.add(new HashMap<String, Object>() {
                    {
                        put("invoiceId", invoice[invoiceIdIndex]);
                        put("productId", invoice[productIdIndex]);
                        put("quantity", invoice[quantityIndex]);
                        put("saleId", invoice[saleIdIndex]);
                    }
                });
            }
            return new CustomApiResponse("success", HttpStatus.OK.value(),
                    String.format("Got last %d invoices successfully", limit),
                    lastInvoices);
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "A unexpected error happened while getting last invoices", e.toString());
        }
    }

    /**
     * Retrieves the total number of employees.
     *
     * @return An object containing the total number of employees.
     */
    public CustomApiResponse getTotalEmployees() {
        try {
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Successfully retrieved total employees",
                    new HashMap<String, Integer>() {
                        {
                            put("totalEmployees", employeeRepository.getTotalEmployees());
                        }
                    });
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "A unexpected error happened while getting total employees", e.toString());
        }
    }

}
