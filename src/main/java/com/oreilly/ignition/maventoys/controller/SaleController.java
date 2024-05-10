package com.oreilly.ignition.maventoys.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.PageRequest;

import com.oreilly.ignition.maventoys.model.CustomApiResponse;
import com.oreilly.ignition.maventoys.model.dto.SaleDto;
import com.oreilly.ignition.maventoys.model.entity.Sale;
import com.oreilly.ignition.maventoys.service.SaleService;

@CrossOrigin
@RestController
@RequestMapping(value = "/sales", produces = MediaType.APPLICATION_JSON_VALUE)
public class SaleController {
    /**
     * The service to handle the sale operations.
     */
    private final SaleService saleService;

    /**
     * Creates a new instance of the controller.
     *
     * @param saleServiceParam the service to handle the sale operations.
     */
    public SaleController(final SaleService saleServiceParam) {
        this.saleService = saleServiceParam;
    }

    /**
     * Retrieves a list of sales based on the specified page and limit.
     *
     * @param page  the page number to retrieve (optional)
     * @param limit the maximum number of sales to retrieve per page (optional)
     * @return a list of Sale objects
     */
    @GetMapping
    public ResponseEntity<CustomApiResponse> find(
            @RequestParam(value = "page", required = false) final Integer page,
            @RequestParam(value = "limit", required = false) final Integer limit) {

        if (page != null && limit != null) {
            return ResponseEntity.status(HttpStatus.OK).body(saleService.find(PageRequest.of(page, limit)));
        }
        return ResponseEntity.status(HttpStatus.OK).body(saleService.find());
    }

    /**
     * Retrieves a Sale object by its ID.
     *
     * @param saleId the ID of the sale to retrieve
     * @return the Sale object with the specified ID
     */
    @GetMapping("/{saleId}")
    public ResponseEntity<CustomApiResponse> findById(@PathVariable("saleId") final Integer saleId) {
        return ResponseEntity.status(HttpStatus.OK).body(saleService.findById(saleId));
    }

    /**
     * Saves a sale by creating a new Sale object and associated invoices.
     * @param saleDto The SaleDto object containing the sale details.
     * @return A ResponseEntity containing the saved Sale object and associated
     *         invoices.
     */
    @PostMapping
    public ResponseEntity<CustomApiResponse> save(@RequestBody final SaleDto saleDto) {
        return ResponseEntity.status(HttpStatus.OK).body(saleService.saveSale(saleDto));
    }

    /**
     * Updates a Sale object.
     *
     * @param sale The Sale object to be updated.
     * @return The updated Sale object.
     */
    @PutMapping
    public Sale update(@RequestBody final Sale sale) {
        return saleService.save(sale);
    }
}
