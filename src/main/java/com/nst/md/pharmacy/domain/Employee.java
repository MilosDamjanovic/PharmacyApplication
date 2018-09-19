package com.nst.md.pharmacy.domain;

import com.nst.md.pharmacy.domain.enumtype.EmployeeRoleEnum;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="employee")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name="Employee.findALl", query = "SELECT e FROM Employee e"),
        @NamedQuery(name = "Employee.findByUsername", query = "SELECT e FROM Employee e WHERE e.username = :username"),
        @NamedQuery(name = "Employee.findByPassword", query = "SELECT e FROM Employee e WHERE e.password = :password"),
        @NamedQuery(name = "Employee.findByFirstName", query = "SELECT e FROM Employee e WHERE e.firstName = :firstName"),
        @NamedQuery(name = "Employee.findByLastName", query = "SELECT e FROM Employee e WHERE e.lastName = :lastName")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 2203994L;

    @Id
    @Basic(optional = false)
    @Column(name = "user_id", nullable = false)
    private Long userID;
    private String username;
    private String password;
    private String vocation;
    private String firstName;
    private String lastName;
    private String healthInstitution;
    //i ovde treba mapirati

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Perscription> perscriptions;

    //postoje i atributi size, max, videcu da li cu ih dodavati

    @ElementCollection(fetch = FetchType.EAGER, targetClass = EmployeeRoleEnum.class)
    @Enumerated(EnumType.STRING)
    private Set<EmployeeRoleEnum> roles;

    public Employee() {
        this.roles = new HashSet<>();
        this.perscriptions = new ArrayList<>();
    }

    public Employee(String username, String password, String vocation, String firstName, String lastName, String healthInstitution, Perscription perscription) {
        this.username = username;
        this.password = password;
        this.vocation = vocation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.healthInstitution = healthInstitution;
        perscriptions = new ArrayList<>();
        this.roles = new HashSet<>();
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    @NotNull
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull
    @Column(name = "password", unique = true)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "vocation")
    @Size()
    public String getVocation() {
        return vocation;
    }

    public void setVocation(String vocation) {
        this.vocation = vocation;
    }

    @Basic
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "healthInstitution")
    @Size(max = 200)
    public String getHealthInstitution() {
        return healthInstitution;
    }

    public void setHealthInstitution(String healthInstitution) {
        this.healthInstitution = healthInstitution;
    }

    public List<Perscription> getPerscription() {
     return new ArrayList<Perscription>();
    }

    public void setPerscription(List<Perscription> perscriptions) {
         this.perscriptions = perscriptions;
    }

    public Set<EmployeeRoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(Set<EmployeeRoleEnum> roles) {
        this.roles = roles;
    }

    public boolean hasRole(EmployeeRoleEnum role){
        return roles.contains(role);
    }

    @Override
    public String toString() {
        return "Employee: "+getUsername()+" "+getFirstName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return userID == employee.userID &&
                Objects.equals(username, employee.username) &&
                Objects.equals(password, employee.password) &&
                Objects.equals(vocation, employee.vocation) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(healthInstitution, employee.healthInstitution);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.username);
        hash = 97 * hash + Objects.hashCode(this.password);
        hash = 97 * hash + Objects.hashCode(this.healthInstitution);
        hash = 97 * hash + Objects.hashCode(this.vocation);
        hash = 97 * hash + Objects.hashCode(this.firstName);
        hash = 97 * hash + Objects.hashCode(this.lastName);
        return hash;
    }

}
