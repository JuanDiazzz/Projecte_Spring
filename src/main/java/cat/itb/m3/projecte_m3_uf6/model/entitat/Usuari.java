package cat.itb.m3.projecte_m3_uf6.model.entitat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuari {
    @GeneratedValue
    private Long id;
    @Id
    private String username;
    private String password;
    private String rol;


    public Usuari(String username, String password, String rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }
}
