package cat.itb.m3.projecte_m3_uf6.model.serveis;

import cat.itb.m3.projecte_m3_uf6.model.entitat.Usuari;
import cat.itb.m3.projecte_m3_uf6.model.repositori.RepositoriUsuaris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ServeiUsuari  {

    @Autowired
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private RepositoriUsuaris repositori;

    public Usuari findById(String username) {
        return repositori.findById(username).orElse(null);
    }

    public void add(Usuari u) {
        repositori.save(u);
    }

    @PostConstruct
    public void init() {
        repositori.saveAll(
                Arrays.asList(
                        new Usuari("admin", passwordEncoder().encode("admin"), "ADMIN"),
                        new Usuari("user", passwordEncoder().encode("user"), "USER")
                )
        );
    }

}
