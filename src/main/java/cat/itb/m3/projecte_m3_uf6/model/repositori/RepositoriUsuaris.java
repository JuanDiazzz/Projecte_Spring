package cat.itb.m3.projecte_m3_uf6.model.repositori;

import cat.itb.m3.projecte_m3_uf6.model.entitat.Usuari;
import org.springframework.data.repository.CrudRepository;

public interface RepositoriUsuaris extends CrudRepository<Usuari, String> {
}
