package com.oreilly.ignition.maventoys.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.oreilly.ignition.maventoys.exception.EntityNotFoundException;
import com.oreilly.ignition.maventoys.model.CustomApiResponse;
import com.oreilly.ignition.maventoys.model.dto.ProductQuantity;
import com.oreilly.ignition.maventoys.model.dto.SaleDto;
import com.oreilly.ignition.maventoys.model.entity.Employee;
import com.oreilly.ignition.maventoys.model.entity.Invoice;
import com.oreilly.ignition.maventoys.model.entity.Product;
import com.oreilly.ignition.maventoys.model.entity.Sale;
import com.oreilly.ignition.maventoys.model.entity.Store;
import com.oreilly.ignition.maventoys.repository.EmployeeRepository;
import com.oreilly.ignition.maventoys.repository.InvoiceRepository;
import com.oreilly.ignition.maventoys.repository.ProductRepository;
import com.oreilly.ignition.maventoys.repository.SaleRepository;
import com.oreilly.ignition.maventoys.repository.StoreRepository;

import io.micrometer.common.lang.NonNull;

@Service
public class SaleService {
    /**
     * The repository for managing sales data.
     */
    private final SaleRepository saleRepository;
    /**
     * The repository for managing invoices data.
     */
    private final InvoiceRepository invoiceRepository;
    /**
     * The repository for managing products data.
     */
    private final ProductRepository productRepository;
    /**
     * The repository for managing employees data.
     */
    private final EmployeeRepository employeeRepository;
    /**
     * The repository for managing stores data.
     */
    private final StoreRepository storeRepository;

    /**
     * Constructs a new SaleService with the specified repositories.
     *
     * @param saleRepo     the SaleRepository
     * @param invoiceRepo  the InvoiceRepository
     * @param productRepo  the ProductRepository
     * @param employeeRepo the EmployeeRepository
     * @param storeRepo    the StoreRepository
     */
    @Autowired
    public SaleService(final SaleRepository saleRepo, final InvoiceRepository invoiceRepo,
            final ProductRepository productRepo, final EmployeeRepository employeeRepo,
            final StoreRepository storeRepo) {
        this.saleRepository = saleRepo;
        this.invoiceRepository = invoiceRepo;
        this.productRepository = productRepo;
        this.employeeRepository = employeeRepo;
        this.storeRepository = storeRepo;
    }

    /**
     * Retrieves a list of sales with associated invoices.
     * @param pageable the pagination information
     * @return a list of sales with associated invoices
     */
    public CustomApiResponse find(final Pageable pageable) {
        try {
            List<Sale> sales = saleRepository.findAll(pageable).toList();
            final int quantityIndex = 2;
            final int subtotalIndex = 3;
            final int discountIndex = 4;
            final int statusIndex = 5;
            final int idIndex = 6;
            for (Sale sale : sales) {
                List<Object[]> invoices = invoiceRepository.findBySaleId(sale.getId());
                Invoice i;
                Product p;
                for (Object[] invoiceRecord : invoices) {
                    p = productRepository.findById((Integer) invoiceRecord[1]).get();
                    i = new Invoice();
                    i.setProduct(p);
                    i.setQuantity((Integer) invoiceRecord[quantityIndex]);
                    i.setSubtotal((Double) invoiceRecord[subtotalIndex]);
                    i.setDiscount((Integer) invoiceRecord[discountIndex]);
                    i.setStatus((Boolean) invoiceRecord[statusIndex]);
                    i.setId((Long) invoiceRecord[idIndex]);
                    sale.getInvoices().add(i);
                }
            }
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Stores fetched successfully",
                    sales);

        } catch (Exception e) {
            return new CustomApiResponse("failure", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "An error occurred while fetching stores", null);
        }
    }

    /**
     * Retrieves sales data and associated invoices from the database.
     * @return A CustomApiResponse object containing the fetched sales data.
     */
    public CustomApiResponse find() {
        try {
            List<Sale> sales = saleRepository.findAll();
            final int quantityIndex = 2;
            final int subtotalIndex = 3;
            final int discountIndex = 4;
            final int statusIndex = 5;
            final int idIndex = 6;
            for (Sale sale : sales) {
                List<Object[]> invoices = invoiceRepository.findBySaleId(sale.getId());
                Invoice i;
                Product p;
                for (Object[] invoiceRecord : invoices) {
                    p = (Product) productRepository.findById((Integer) invoiceRecord[1]).orElseThrow(
                            () -> new EntityNotFoundException("Product with ID " + invoiceRecord[1] + " not found"));
                    i = new Invoice();
                    i.setProduct(p);
                    i.setQuantity((Integer) invoiceRecord[quantityIndex]);
                    i.setSubtotal((Double) invoiceRecord[subtotalIndex]);
                    i.setDiscount((Integer) invoiceRecord[discountIndex]);
                    i.setStatus((Boolean) invoiceRecord[statusIndex]);
                    i.setId((Long) invoiceRecord[idIndex]);
                    sale.getInvoices().add(i);
                }
            }
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Sales fetched successfully",
                    sales);
        } catch (Exception e) {
            return new CustomApiResponse("failure", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "An error occurred while fetching sales", null);
        }
    }

    /**
     * Saves a Sale object.
     *
     * @param sale the Sale object to be saved
     * @return the saved Sale object
     */
    public Sale save(final Sale sale) {
        return saleRepository.save(sale);
    }

    /**
     * Finds a sale by its ID.
     *
     * @param saleId the ID of the sale to find
     * @return the sale with the specified ID, or null if not found
     */
    public CustomApiResponse findById(@NonNull final Integer saleId) {
        try {
            Sale sale = saleRepository.findById(saleId).orElseThrow(
                    () -> new EntityNotFoundException("Sale with ID " + saleId + " not found"));
            List<Object[]> invoices = invoiceRepository.findBySaleId(saleId);
            Invoice i;
            Product p;
            final int quantityIndex = 2;
            final int subtotalIndex = 3;
            final int discountIndex = 4;
            final int statusIndex = 5;
            final int idIndex = 6;
            for (Object[] invoiceRecord : invoices) {
                p = productRepository.findById((Integer) invoiceRecord[1]).orElseThrow(
                        () -> new EntityNotFoundException("Product with ID " + invoiceRecord[1] + " not found"));
                i = new Invoice();
                i.setId((Long) invoiceRecord[idIndex]);
                i.setQuantity((Integer) invoiceRecord[quantityIndex]);
                i.setSubtotal((Double) invoiceRecord[subtotalIndex]);
                i.setDiscount((Integer) invoiceRecord[discountIndex]);
                i.setStatus((Boolean) invoiceRecord[statusIndex]);
                i.setProduct(p);
                sale.getInvoices().add(i);
            }
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Sale fetched successfully",
                    Collections.singletonMap("sale", sale));
        } catch (EntityNotFoundException e) {
            return new CustomApiResponse("failure", HttpStatus.NOT_FOUND.value(), e.getMessage(), e.toString());
        } catch (Exception e) {
            return new CustomApiResponse("failure", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "An error occurred while fetching sale", null);
        }
    }

    /**
     * Saves a sale based on the provided SaleDto.
     *
     * @param saleDto The SaleDto containing the sale information.
     *                * Iterates over each ProductQuantity in the provided SaleDto.
     *                For each ProductQuantity:
     *                - Retrieves the corresponding Product from the repository
     *                (throws EntityNotFoundException if not found).
     *                - Creates a new Invoice for the Product.
     *                - Calculates the subtotal for the Product based on its price,
     *                quantity, and any applied discount.
     *                - Sets the Product, quantity, subtotal, discount, and status
     *                on the Invoice.
     *                - Adds the Invoice to a collection of invoices.
     *                - Maps the Product to its quantity in a productQuantity map.
     *                - Adds the subtotal to a running total.
     * @return A CustomApiResponse indicating the result of the operation.
     */
    public CustomApiResponse saveSale(@NonNull final SaleDto saleDto) {
        try {

            Sale sale = new Sale();
            HashMap<Product, Integer> productQuantity = new HashMap<Product, Integer>();
            Double total = 0.0;
            Double subtotal = 0.0;
            final Double hundredPercent = 100.0;
            List<Invoice> invoices = new ArrayList<Invoice>();

            Product product;
            Invoice invoice;

            Employee employee = employeeRepository.findById(saleDto.getEmployeeId()).orElseThrow(
                    () -> new EntityNotFoundException("Employee with ID " + saleDto.getEmployeeId() + " not found"));
            Store store = storeRepository.findById(saleDto.getStoreId()).orElseThrow(
                    () -> new EntityNotFoundException("Store with ID " + saleDto.getStoreId() + " not found"));

            sale.setDate(new Date());
            sale.setStore(store);
            sale.setEmployee(employee);

            for (ProductQuantity productRecord : saleDto.getProductQuantity()) {
                product = productRepository.findById(productRecord.getProductId()).orElseThrow(
                        () -> new EntityNotFoundException(
                                "Product with ID " + productRecord.getProductId() + " not found"));
                invoice = new Invoice();
                subtotal = (product.getPrice() * productRecord.getQuantity())
                        - ((productRecord.getDiscount() / hundredPercent)
                                * (product.getPrice() * productRecord.getQuantity()));
                invoice.setProduct(product);
                invoice.setQuantity(productRecord.getQuantity());
                invoice.setSubtotal(subtotal);
                invoice.setDiscount(productRecord.getDiscount());
                invoice.setStatus(true);
                invoices.add(invoice);
                productQuantity.put(product, productRecord.getQuantity());
                total += subtotal;
            }

            sale.setTotal(total);
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Sale saved successfully",
                    saleRepository.save(sale));
        } catch (EntityNotFoundException e) {
            return new CustomApiResponse("failure", HttpStatus.NOT_FOUND.value(), e.getMessage(), e.toString());
        } catch (Exception e) {
            return new CustomApiResponse("failure", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "An error occurred while saving sale", null);
        }
    }

    /**
     * Returns the total sales as an Integer.
     *
     * @return the total sales as an Integer
     */
    public Integer findTotalSales() {
        return saleRepository.findTotalSales();
    }

    /**
     * Returns the total revenue.
     *
     * @return the total revenue as a Double value
     */
    public Double getTotalRevenue() {
        return saleRepository.getTotalRevenue();
    }

    /**
     * Retrieves a list of the most sold categories.
     *
     * @return a list of Object arrays representing the most sold categories.
     */
    public List<Object[]> findMostSoldCategories() {
        return saleRepository.findMostSoldCategories();
    }

    /**
     * Returns the total number of items sold.
     *
     * @return the total number of items sold
     */
    public Integer findTotalItemsSold() {
        return saleRepository.findTotalItemsSold();
    }

    /**
     * Retrieves the last invoices based on the specified limit.
     *
     * @param limit the maximum number of invoices to retrieve
     * @return a list of object arrays representing the last invoices
     */
    public List<Object[]> findLastInvoices(final Integer limit) {
        return saleRepository.findLastInvoices(limit);
    }
}
