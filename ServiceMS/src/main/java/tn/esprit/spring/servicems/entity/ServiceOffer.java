package tn.esprit.spring.servicems.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ServiceOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    private String name;
    private String description;
    private Double price;
    private Integer duration; // en minutes

    private Long clientId;

    private Integer capacity;       // capacité maximale
    private Integer reservedSlots;  // places réservées

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getReservedSlots() {
        return reservedSlots;
    }

    public void setReservedSlots(Integer reservedSlots) {
        this.reservedSlots = reservedSlots;
    }

    public Long getClientId() {
        return this.clientId;
    }
}
