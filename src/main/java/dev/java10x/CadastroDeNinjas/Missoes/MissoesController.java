package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/missoes")
@RestController
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService){
        this.missoesService = missoesService;
    }
    @GetMapping("/listar")
    public List<MissoesDTO> listarTodos() {
        return missoesService.listarDTO();
    }

    @PutMapping("/atualiza/{id}")
    public MissoesDTO atualizar(@PathVariable Long id, @RequestBody MissoesDTO missoesDTO){
        return missoesService.atualizaDTO(id,missoesDTO);
    }

    @GetMapping("/listar/{id}")
    public MissoesDTO listarId(@PathVariable Long id){
        return missoesService.listarPorIdDTO(id);
    }

    @PostMapping("/cadastrar")
    public MissoesModel cadastarMissao(@RequestBody MissoesModel missoesModel){
        return missoesService.cadastraMissao(missoesModel);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id){
        missoesService.deletarMissao(id);
    }

    // falta criar/refatorar metodos usados ResponseEntity para configurar respostas do servidor
    @DeleteMapping("/deleteresponse/{id}")
    public ResponseEntity<String> deletaResponse(@PathVariable Long id){
        if(missoesService.listarPorIdDTO(id) != null){
            missoesService.deletarMissao(id);
            return ResponseEntity.ok("missão de id: "+id+" deletada do banco de dados");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Missão de id: " + id+ " não encontrada no banco");
    }

    @PostMapping("/criaresponse")
    public ResponseEntity<String> criaResponse(@RequestBody MissoesDTO missoesDTO){
        missoesService.cadastra(missoesDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("missao: " +missoesDTO.getNomeDaMissao()+ " criada");
    }

    @PutMapping("atualizaresponse/{id}")
    public ResponseEntity<String> atualizaResponse(@PathVariable Long id, @RequestBody MissoesDTO missoesDTO){
        if (missoesService.listarPorIdDTO(id) != null){
            missoesDTO.setId(id);
            missoesService.atualizaDTO(id, missoesDTO);
            return ResponseEntity.ok("missao: "+id+" atualizada com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("missão não encontrada no banco");
    }
    /*@GetMapping("/listaidresponse/{id}")
    public ResponseEntity<String> listarIdResponse(@PathVariable Long id){
        if(missoesService.listarPorIdDTO(id) != null){
            missoesService.listarPorIdDTO(id);
           return ResponseEntity.ok(id + " listado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(id + " não encontrado");
    }*/
    @GetMapping("listaridresponse/{id}")
    public ResponseEntity<Object> missoesIdResponse(@PathVariable Long id){
        MissoesDTO missoesDTO = missoesService.listarPorIdDTO(id);

        if (missoesService.listarPorIdDTO(id) != null){
            return ResponseEntity.ok(missoesDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("não encontrado");
    }
}
