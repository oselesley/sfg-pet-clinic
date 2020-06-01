package lesley.springframework.sfgpetclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity {
    private LocalDate birthDate;
    private PetType petType;
    private Person Owner;

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Person getOwner() {
        return Owner;
    }

    public void setOwner(Person owner) {
        Owner = owner;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "birthDate=" + birthDate +
                ", petType='" + petType + '\'' +
                ", Owner=" + Owner +
                '}';
    }
}
