package com.deliveroo.rider.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 5)
    private String orderNo;

    @Column(nullable = false)
    @JsonFormat(pattern = "HH:mm",locale = "en")
    private LocalTime start;

    @Column(nullable = false)
    @JsonFormat(pattern = "HH:mm",locale = "en")
    private LocalTime complete;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", start=" + start +
                ", complete=" + complete +
                '}';
    }
}
