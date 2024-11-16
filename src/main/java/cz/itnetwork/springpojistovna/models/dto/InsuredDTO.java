package cz.itnetwork.springpojistovna.models.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class InsuredDTO {
    @NotBlank(message = "Vyplňte jmeno")
    private String firstName;

    @NotBlank(message = "Vyplňte příjmení")
    private String surname;

    @NotBlank(message = "vypln")
    private String typeOfInsurance;

    @Min(value = 0, message = "Částka musí být kladná")
    private int amount;

    private long insuredId;

    public String getTypeOfInsurance() {
        return typeOfInsurance;
    }

    public void setTypeOfInsurance(String typeOfInsurance) {
        this.typeOfInsurance = typeOfInsurance;
    }

    public long getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(long insuredId) {
        this.insuredId = insuredId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String lastName) {
        this.surname = lastName;
    }
}
