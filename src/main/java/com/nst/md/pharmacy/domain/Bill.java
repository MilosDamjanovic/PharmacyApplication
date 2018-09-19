package com.nst.md.pharmacy.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity(name = "Bill")
@Table(name = "bills")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Bill.findAll", query = "select b from Bill b")
})
public class Bill implements Serializable {

    private static final long serialVersionUID = 9L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;
    @Basic
    @Column(name = "issue_date")
    @Temporal(TemporalType.DATE)
    private Date issueDate;
    @Column(name = "issue_place")
    @NotNull
    @Size(max = 200)
    private String issuePlace;
    @Column(name = "value_added_tax")
    private double valueAddedTax;
    @Column(name = "suspected_without_tax")
    private double suspectedWithoutTax;
    @Column(name = "total_sum")
    private double totalSum;

    @OneToMany(targetEntity = BillItem.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bill")
    private List<BillItem> billItemList;

    public Bill(long billId, Date issueDate, String issuePlace, double valueAddedTax, double suspectedWithoutTax, double totalSum, List<BillItem> billItemList) {
        this.billId = billId;
        this.issueDate = issueDate;
        this.issuePlace = issuePlace;
        this.valueAddedTax = valueAddedTax;
        this.suspectedWithoutTax = suspectedWithoutTax;
        this.totalSum = totalSum;
        this.billItemList = new ArrayList<>();
    }

    public Bill() {
        billItemList = new ArrayList<>();
    }

    public List<BillItem> getBillItemList() {
        return billItemList;
    }

    public void setBillItemList(List<BillItem> billItemList) {
        this.billItemList = billItemList;
    }

    public Long getbillId() {
        return billId;
    }

    public void setbillId(long billId) {
        this.billId = billId;
    }


    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssuePlace() {
        return issuePlace;
    }

    public void setIssuePlace(String issuePlace) {
        this.issuePlace = issuePlace;
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

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", issueDate=" + issueDate +
                ", issuePlace='" + issuePlace + '\'' +
                ", valueAddedTax=" + valueAddedTax +
                ", suspectedWithoutTax=" + suspectedWithoutTax +
                ", totalSum=" + totalSum +
                ", billItemList=" + billItemList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return billId == bill.billId &&
                Objects.equals(issueDate, bill.issueDate) &&
                Objects.equals(issuePlace, bill.issuePlace) &&
                Objects.equals(valueAddedTax, bill.valueAddedTax) &&
                Objects.equals(suspectedWithoutTax, bill.suspectedWithoutTax) &&
                Objects.equals(totalSum, bill.totalSum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billId, issueDate, issuePlace, valueAddedTax, suspectedWithoutTax, totalSum);
    }
}
