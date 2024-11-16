package cz.itnetwork.springpojistovna.models.dto;


import jakarta.validation.constraints.NotBlank;

public class InsuranceDTO {

    @NotBlank(message = "Vyplňte typ pojišteni")
    private String typeOfInsurance;

    private long insuranceID;

    public long getInsuranceID() {
        return insuranceID;
    }

    public void setInsuranceID(long insuranceID) {
        this.insuranceID = insuranceID;
    }

    public String getTypeOfInsurance() {
        return typeOfInsurance;
    }

    public void setTypeOfInsurance(String typeOfInsurance) {
        this.typeOfInsurance = typeOfInsurance;
    }
}
