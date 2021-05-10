package cat.itb.m3.projecte_m3_uf6.seguretat;

import cat.itb.m3.projecte_m3_uf6.model.entitat.Usuari;
import cat.itb.m3.projecte_m3_uf6.model.serveis.ServeiUsuari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private ServeiUsuari serveiUsuari;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuari u = serveiUsuari.findById(username);
        User.UserBuilder builder = null;
        if (u != null) {
            builder = User.withUsername(username);
            builder.disabled(false);
            builder.password(u.getPassword());
            builder.roles(u.getRol());
        } else {
            throw new UsernameNotFoundException("Usuari no trobat");
        }
        return builder.build();
    }




}
