package cat.itb.m3.projecte_m3_uf6.model.serveis;

import cat.itb.m3.projecte_m3_uf6.model.entitat.Empleat;
import cat.itb.m3.projecte_m3_uf6.model.repositori.RepositoriEmpleats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class ServeiEmpleat {

    @Autowired
    private RepositoriEmpleats repositori;

    public void addEmpleat(Empleat e) { repositori.save(e); }

    public void deteleEmpleat (int id) {
        repositori.deleteById(id);
    }

    public void editarEmpleat(Empleat e) {
        repositori.save(e);
    }

    public Empleat getEmpleatById(int id) {
        return repositori.findById(id).orElse(null);
    }

    public Iterable<Empleat> getEmpleats() {
        return repositori.findAll();
    }

    public List<Empleat> listOrderPerNom() {
        List<Empleat> empleats = repositori.findAll();
        Collections.sort(empleats, (e1, e2) -> e1.getNom().compareTo(e2.getNom()));

        return empleats;
    }

    @PostConstruct
    public void init() {
        repositori.saveAll(
                Arrays.asList(
                        new Empleat(1, "Hermenegildo", "hermenegildo@garcia.com", "987234152", true),
                        new Empleat(2, "Eustaquio", "eusta@quio.com", "154323456", false),
                        new Empleat(3, "Carmen", "carmen@gmail.com", "983456234", false),
                        new Empleat(4, "Emilio", "emilio@emilio.com", "763542653", true),
                        new Empleat(4, "Paquito", "paco@mermela.com", "987234153", false)
                        )
        );
    }

}
