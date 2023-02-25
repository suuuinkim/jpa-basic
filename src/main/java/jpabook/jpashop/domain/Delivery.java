package jpabook.jpashop.domain;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Delivery extends BaseEntity{
    @Id @GeneratedValue
    @Column(name="DELIVERY_ID")
    private Long id;

    private String city;

    private String street;

    private String zipcode;

    @Enumerated
    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;
    public Delivery(){
    }
}