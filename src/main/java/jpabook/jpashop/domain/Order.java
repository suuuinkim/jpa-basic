package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

//@Entity
@Table(name = "ORDERS")
public class Order {
    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId; // 객체지향스럽지 않음

    @ManyToMany
    @JoinColumn(name="MEMBER_ID")
    private Member member;
    private LocalDateTime orderDate; // ORDER_DATE, order_date(스프링부트는 이 형식을 기본으로)

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Order(){
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
