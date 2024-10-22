package com.krutika.springbootproject.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    private String name;
    private String email;
    private String password;

    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "adress_id")

    //@OneToMany (cascade = CascadeType.ALL)
    //@JoinColumn(name = "adress_id", referencedColumnName = "id")
     //private List<Adress> adress;
  @ManyToMany
  @JoinTable(name = "emp_adress" ,
             joinColumns = @JoinColumn(name = "emp_id"),
              inverseJoinColumns = @JoinColumn(name = "adress_id")
  )
  private Set<Adress> adress= new HashSet<>();
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Adress> getAdress() {
        return adress;
    }

    public void setAdress(Set<Adress> adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", adress=" + adress +
                '}';
    }
}
