package com.nst.md.pharmacy.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "bill_item")
@XmlRootElement
@NamedQueries({})
public class BillItem  implements Serializable {

    private static final long serialVersionUID = 8L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billItemId;

    @Column(name = "quantity")
    private int quantity;
    @Column(name = "value_added_tax")
    private double valueAddedTax;
    @Column(name = "suspected_without_tax")
    private double suspectedWithoutTax;
    @Column(name = "total_sum")
    private double totalSum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id", nullable = false)
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;

    public BillItem() {
    }

    public BillItem(Long billItemId, int quantity, double valueAddedTax, double suspectedWithoutTax, double totalSum, Medicine medicine) {
        this.billItemId = billItemId;
        this.quantity = quantity;
        this.valueAddedTax = valueAddedTax;
        this.suspectedWithoutTax = suspectedWithoutTax;
        this.totalSum = totalSum;
        this.medicine = medicine;
    }

    public Long getBillItemId() {
        return billItemId;
    }

    public void setBillItemId(Long billItemId) {
        this.billItemId = billItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getValueAddedTax() {
        return valueAddedTax;
    }

    public void setValueAddedTax(double valueAddedTax) {
        this.valueAddedTax = valueAddedTax;
    }

    public double getSuspectedWithoutTax() {
        return suspectedWithoutTax;
    }

    public void setSuspectedWithoutTax(double suspectedWithoutTax) {
        this.suspectedWithoutTax = suspectedWithoutTax;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillItem billItem = (BillItem) o;
        return  Objects.equals(quantity, billItem.quantity) &&
                Objects.equals(valueAddedTax, billItem.valueAddedTax) &&
                Objects.equals(suspectedWithoutTax, billItem.suspectedWithoutTax) &&
                Objects.equals(totalSum, billItem.totalSum);
    }

    @Override
    public String toString() {
        return "BillItem{" +
                ", quantity=" + quantity +
                ", valueAddedTax=" + valueAddedTax +
                ", suspectedWithoutTax=" + suspectedWithoutTax +
                ", totalSum=" + totalSum +
                ", medicine=" + medicine +
                '}';
    }
}
