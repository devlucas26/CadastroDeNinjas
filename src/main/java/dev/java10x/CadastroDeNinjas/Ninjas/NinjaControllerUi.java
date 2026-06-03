package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ninja/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService){
        this.ninjaService = ninjaService;
    }
    @GetMapping("/listar")
    public String listar(Model model){
        List<NinjaDTO> ninjas = ninjaService.listarDTO();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id){
        ninjaService.deleta(id);
        return "redirect:/ninja/ui/listar";
    }
    @GetMapping("/detalhes/{id}")
    public String detalhes(@PathVariable Long id, Model model){
        NinjaDTO ninja = ninjaService.listarPorId(id);
        model.addAttribute("ninja", ninja);
        return "detalhesNinja";
    }
    @GetMapping("/adicionar")
    public String formularioAdicionaNinja(Model model){
        model.addAttribute("ninja", new NinjaDTO());
        return "adicionaNinja";
    }
    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute NinjaDTO ninjaDTO, RedirectAttributes redirectAttributes){
        ninjaService.cadastroDTO(ninjaDTO);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja cadastrado com sucesso!");
        return "redirect:/ninja/ui/listar";
    }
    @GetMapping("/atualizar/{id}")
    public String editarNinja(@PathVariable Long id, Model model){
        model.addAttribute("ninja", ninjaService.listarPorId(id));
        return "editaNinja";
    }
    @PostMapping("/atualizar")
    public String salvar(@ModelAttribute NinjaDTO ninjaDTO, RedirectAttributes redirectAttributes){
        ninjaService.atualiza(ninjaDTO.getId(), ninjaDTO);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja atualizado com sucesso!");
        return "redirect:/ninja/ui/listar";
    }
}
