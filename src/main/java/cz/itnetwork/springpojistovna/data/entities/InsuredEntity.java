package cz.itnetwork.springpojistovna.data.entities;

import jakarta.persistence.*;

@Entity
public class InsuredEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "insured_id") // Explicitní mapování na "insured_id" v tabulce
    private long insuredId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String surname;

    @Column(name = "type_of_insurance", nullable = false)
    private String typeOfInsurance;

    @Column(nullable = false)
    private int amount;

    public long getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(long insuredId) {
        this.insuredId = insuredId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTypeOfInsurance() {
        return typeOfInsurance;
    }

    public void setTypeOfInsurance(String typeOfInsurance) {
        this.typeOfInsurance = typeOfInsurance;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
