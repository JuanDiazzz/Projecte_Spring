package cat.itb.m3.projecte_m3_uf6.model.repositori;

import cat.itb.m3.projecte_m3_uf6.model.entitat.Empleat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RepositoriEmpleats extends JpaRepository<Empleat, Integer> {
}
