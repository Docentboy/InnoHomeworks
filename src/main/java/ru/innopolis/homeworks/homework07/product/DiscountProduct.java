package ru.innopolis.homeworks.homework07.product;

import java.time.LocalDate;
import java.util.Objects;

public class DiscountProduct extends Product {

    private Integer discount;
    private LocalDate discountDate;

    public DiscountProduct(String name, int price, Integer discount, LocalDate discountDate) {
        super(name, price);
        this.setDiscount(discount);
        this.setDiscountDate(discountDate);

    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        if (discount == null || discount < 0) {
            throw new IllegalArgumentException("Скидка не должна быть отрицательной");
        }
        this.discount = discount;
    }

    public LocalDate getDiscountDate() {
        return discountDate;
    }

    public void setDiscountDate(LocalDate discountDate) {
        this.discountDate = discountDate;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountProduct that = (DiscountProduct) o;
        return Objects.equals(discount, that.discount) && Objects.equals(discountDate, that.discountDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount, discountDate);
    }

    @Override
    public String toString() {
        return "DiscountProduct{" +
                "name=" + super.getName() +
                ", price=" + super.getPrice() +
                ", discount=" + discount +
                ", discountDate=" + discountDate +
                '}';
    }
}
