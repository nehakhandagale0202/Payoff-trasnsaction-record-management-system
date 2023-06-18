package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="TBL_user_6")
public class userRegister {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="first_name", nullable=false)
    private String firstName;
    

    @Column(name="buisness_name", nullable=false)
    private String buisnessName;

    @Column(name="email", nullable=false, length=200)
    private String email;

    @Column(name="mobile_number", nullable=false,unique=true)
    private String mobileNumber;

    @Column(name="customer_pass", nullable=false,unique=true)
    private String password;

    public userRegister() {
    }

    public userRegister(Long id, String firstName, String buisnessName, String email, String mobileNumber,
            String password) {
        this.id = id;
        this.firstName = firstName;
        this.buisnessName = buisnessName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBuisnessName() {
        return buisnessName;
    }

    public void setBuisnessName(String buisnessName) {
        this.buisnessName = buisnessName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "userRegister [id=" + id + ", firstName=" + firstName + ", buisnessName=" + buisnessName + ", email="
                + email + ", mobileNumber=" + mobileNumber + ", password=" + password + "]";
    }


    
}
