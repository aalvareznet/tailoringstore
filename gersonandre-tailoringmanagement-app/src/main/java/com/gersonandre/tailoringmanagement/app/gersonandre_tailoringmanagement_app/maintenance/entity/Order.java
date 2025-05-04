package com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity;

import java.time.LocalDateTime;

import com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.maintenance.entity.enums.OrderStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "order_date")
    LocalDateTime oderDate;
    @Column(name = "delivery_date")
    LocalDateTime deliveryDate;
    @Column(name = "event_date")
    LocalDateTime eventDate;
    @Enumerated(EnumType.STRING)
    OrderStatus status;
    @OneToOne
    @JoinColumn(name = "suit_id", nullable = true)
    Suit suit;
    @OneToOne
    @JoinColumn(name = "shoe_id", nullable = true)
    Shoe shoe;
}
