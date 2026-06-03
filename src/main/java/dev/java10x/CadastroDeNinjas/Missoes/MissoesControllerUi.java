package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/missoes/ui")
public class MissoesControllerUi {

    private final MissoesService missoesService;

    public MissoesControllerUi(MissoesService missoesService){
        this.missoesService = missoesService;
        System.out.println("metodo carregado com sucesso");
    }

    @GetMapping("/listar")
    public String listar(Model model){
        List<MissoesDTO> missoes = missoesService.listarDTO();
        model.addAttribute("missoes", missoes);
        return "listarMissoes";
    }
    @GetMapping("/listar/{id}")
    public String listarPorId(@PathVariable Long id, Model model){
        model.addAttribute("missao", missoesService.listarPorIdDTO(id));
        return "detalhesDaMissao";
    }
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id){
        missoesService.deletarMissao(id);
        return "redirect:/missoes/ui/listar";
    }
    @PostMapping("/salvar")
    public String salvarMissao(@ModelAttribute MissoesDTO missoesDTO, RedirectAttributes redirectAttributes){
        missoesService.cadastra(missoesDTO);
        redirectAttributes.addFlashAttribute("mensagem", "nova missão cadastrada com sucesso");
        return "redirect:/missoes/ui/listar";
    }
    @GetMapping("/cadastra")
    public String adicina(Model model){
        model.addAttribute("missao", new MissoesDTO());
        return "adicionaMissao";
    }
    @GetMapping("/atualizar/{id}")
    public String atualizaMissao(@PathVariable Long id, Model model){
        MissoesDTO missao = missoesService.listarPorIdDTO(id);
        model.addAttribute("missao", missao);
        return "editarMissao";
    }
    @PostMapping("/atualizar")
    public String atualizaMissao(@ModelAttribute MissoesDTO missoesDTO, RedirectAttributes redirectAttributes) {
        missoesService.atualizaDTO(missoesDTO.getId(), missoesDTO);
        redirectAttributes.addFlashAttribute("mensagem", "missao atualizada com sucesso");
        return "redirect:/missoes/ui/listar";
    }

}
