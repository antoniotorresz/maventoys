package com.oreilly.ignition.maventoys.model.entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
@Entity
@Table(name = "stores")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Store {
    /**
     * The unique identifier for the store.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * The name of the store.
     */
    private String name;

    /**
     * The city where the store is located.
     */
    private String city;

    /**
     * The location of the store.
     */
    private String location;

    /**
     * The date the store was opened.
     */
    private Date openDate;

    /**
     * The status of the store (active or inactive).
     */
    private Boolean active;

    /**
     * The employees who work at the store.
     */
    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Employee> employees;

    /**
     * The sales made at the store.
     */
    public Store() {
    }

    /**
     * Constructs a new Store object with the given parameters.
     *
     * @param idParam       the unique identifier of the store
     * @param nameParam     the name of the store
     * @param cityParam     the city where the store is located
     * @param locationParam the specific location of the store within the city
     * @param openDateParam the date when the store was opened
     * @param activeParam   a boolean indicating whether the store is currently
     *                      active
     */
    public Store(final Integer idParam, final String nameParam, final String cityParam, final String locationParam,
            final Date openDateParam, final Boolean activeParam) {
        this.id = idParam;
        this.name = nameParam;
        this.city = cityParam;
        this.location = locationParam;
        this.openDate = openDateParam;
        this.active = activeParam;
    }

}
