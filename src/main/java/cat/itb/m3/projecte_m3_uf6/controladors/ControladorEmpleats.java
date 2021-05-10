package cat.itb.m3.projecte_m3_uf6.controladors;

import cat.itb.m3.projecte_m3_uf6.model.entitat.Empleat;
import cat.itb.m3.projecte_m3_uf6.model.serveis.ServeiEmpleat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorEmpleats {
    @Autowired
    private ServeiEmpleat serveiEmpleat;

    @GetMapping("/empleats/list")
    public String llistar(Model model) {
        model.addAttribute("llistaEmpleats", serveiEmpleat.getEmpleats());
        return "llistat";
    }

    @GetMapping("/empleats/list/orderbyname")
    public String llistarOrderByNom(Model model) {
        model.addAttribute("llistaEmpleats", serveiEmpleat.listOrderPerNom());
        return "llistat";
    }

    @GetMapping("/empleats/new")
    public String afegirEmpleat(Model model) {
        model.addAttribute("empleatForm", new Empleat());
        return "afegir";
    }

    @PostMapping("empleats/new/submit")
    public String submitEmpleat(@ModelAttribute("empleatForm") Empleat e) {
        serveiEmpleat.addEmpleat(e);
        return "redirect:/empleats/list";
    }

    @GetMapping("/empleats/edit/{id}")
    public String editar(Model model, @PathVariable(value="id") int id) {
        Empleat e = serveiEmpleat.getEmpleatById(id);
        model.addAttribute("empleatForm", e);
        return "afegir";
    }

    @PostMapping("empleats/edit/submit")
    public String submitEditEmpleat(@ModelAttribute("empleatForm") Empleat e) {
        serveiEmpleat.editarEmpleat(e);
        return "redirect:/empleats/list";
    }

    @GetMapping("/empleats/eliminar")
    public String eliminar(@RequestParam(value="id") int id) {
        serveiEmpleat.deteleEmpleat(id);
        return "redirect:/empleats/list";
    }

}

