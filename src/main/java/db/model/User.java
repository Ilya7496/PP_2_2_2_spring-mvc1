package db.model;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message= "Поле не может быть пустым.")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Имя не может содержать цифры и символы.")
    @Column
    private String name;

    @NotBlank(message = "Поле не может пустым.")
    @Email(message = "Почта должна быть валидной.")
    @Column
    private String email;

    @NotBlank(message = "Поле дожно содержать цифры")
    @Pattern(regexp = "\\d{11}$", message = "Номер должен содержать 11 цифр.")
    @Column
    private String phone;

    public User() {}

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return name + " " + email;
    }
}