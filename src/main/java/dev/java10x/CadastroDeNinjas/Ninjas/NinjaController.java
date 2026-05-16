package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public List<NinjaDTO> listar() {
        return ninjaService.listarDTO();
    }

    @GetMapping("/listar/{id}")
    public NinjaDTO procuraPorId(@PathVariable Long id) {
        return ninjaService.listarPorId(id);
    }

    @PostMapping("/criar")
    public NinjaDTO cadastraNinja(@RequestBody NinjaDTO ninjaDTO){
        return ninjaService.cadastroDTO(ninjaDTO);
    }

    @PostMapping("/criarcomresponse")
    public ResponseEntity<String> cadastraNinjaResponse(@RequestBody NinjaDTO ninjaDTO){
         ninjaService.cadastroDTO(ninjaDTO);

         return ResponseEntity.status(HttpStatus.CREATED)
                 .body("ninja: " + ninjaDTO.getNome() + " cadastrado com sucesso");
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id){
        ninjaService.deleta(id);
    }
    // rota de deleção com Response Entity

    @DeleteMapping("/deletacomresponse/{id}")
    public ResponseEntity<String> deletaResponse(@PathVariable Long id){
        //ninjaService.deleta(id);
        if(ninjaService.listarPorId(id) != null){
            ninjaService.deleta(id);
            return ResponseEntity.ok("ninja deletado do banco com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("id: " + id + " não encontrado");
    }

    @PutMapping("/atualiza/{id}")
    public NinjaDTO atualizar(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.atualiza(id, ninjaAtualizado);
        //ninjaService.atualiza(id, ninjaModelAtualizado);
    }

    @PutMapping("/atualizacomresponse/{id}")
    public ResponseEntity<String> atualizarResponse(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){

        if (ninjaService.listarPorId(id) != null){
            ninjaService.atualiza(id, ninjaAtualizado);
            return ResponseEntity.ok("id: " + ninjaAtualizado.getId() + " atualizado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("id: " + id +  " não foi encontrado na base de dados");



        //ninjaService.atualiza(id, ninjaModelAtualizado);
    }
}
