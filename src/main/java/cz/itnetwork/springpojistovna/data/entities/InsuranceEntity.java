package cz.itnetwork.springpojistovna.data.entities;

import jakarta.persistence.*;

@Entity
public class InsuranceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long insuranceID;

    @Column(nullable = false)
    private String typeOfInsurance;

    public String getTypeOfInsurance() {
        return typeOfInsurance;
    }


    public void setTypeOfInsurance(String typeOfInsurance) {
        this.typeOfInsurance = typeOfInsurance;
    }

    public long getInsuranceID() {
        return insuranceID;
    }

    public void setInsuranceID(long insuranceID) {
        this.insuranceID = insuranceID;
    }
}
