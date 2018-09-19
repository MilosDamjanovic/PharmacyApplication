package com.nst.md.pharmacy.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "perscription")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Perscription.findAll", query = "select p from Perscription p"),
})
public class Perscription implements Serializable {

    private static final long serialVersionUID = 5L;

    @Id
    @Column(name = "perscription_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long perscriptionId;
    @Basic
    @Column(name = "issue_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date issueDate;

    @Basic
    @Size(max = 200)
    @Column(name = "diagnosis")
    private String diagnosis;
    @Basic
    @Column(name = "health_institution")
    @Size(max = 200)
    private String healthInstitution;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    public Perscription() {
    }

    public Perscription(Long perscriptionId, Date issueDate, String diagnosis, String healthInstitution, Employee employee) {
        this.perscriptionId = perscriptionId;
        this.issueDate = issueDate;
        this.diagnosis = diagnosis;
        this.healthInstitution = healthInstitution;
        this.employee = employee;
    }

    public Long getPerscriptionId() {
        return perscriptionId;
    }

    public void setPerscriptionId(Long perscriptionId) {
        this.perscriptionId = perscriptionId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getHealthInstitution() {
        return healthInstitution;
    }

    public void setHealthInstitution(String healthInstitution) {
        this.healthInstitution = healthInstitution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perscription that = (Perscription) o;
        return perscriptionId == that.perscriptionId &&
                Objects.equals(issueDate, that.issueDate) &&
                Objects.equals(diagnosis, that.diagnosis) &&
                Objects.equals(healthInstitution, that.healthInstitution);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.healthInstitution);
        hash = 97 * hash + Objects.hashCode(this.diagnosis);
        return hash;
    }

    public Employee getEmployeeByDoctorId() {
        return employee;
    }

    public void setEmployeeByDoctorId(Employee employeeByDoctorId) {
        this.employee = employeeByDoctorId;
    }
}
