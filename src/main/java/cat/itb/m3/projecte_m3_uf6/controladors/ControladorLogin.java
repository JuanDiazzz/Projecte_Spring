package cat.itb.m3.projecte_m3_uf6.controladors;

import cat.itb.m3.projecte_m3_uf6.model.repositori.RepositoriUsuaris;
import cat.itb.m3.projecte_m3_uf6.model.serveis.ServeiUsuari;
import cat.itb.m3.projecte_m3_uf6.model.entitat.Usuari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ControladorLogin {
    @Autowired
    private ServeiUsuari serveiUsuari;

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/registre")
    public String registre(Model model) {
        model.addAttribute("userForm", new Usuari());
        return "registre";
    }

    @PostMapping("/registre")
    public String submitUser(@ModelAttribute("userForm") Usuari user) {
        String pass = passwordEncoder().encode(user.getPassword());
        user.setPassword(pass);
        user.setRol("USER");
        serveiUsuari.add(user);
        return "redirect:/empleats/list";
    }

    @Autowired
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
