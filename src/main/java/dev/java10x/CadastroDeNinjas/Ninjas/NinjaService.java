package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository){
        this.ninjaRepository = ninjaRepository;
    }
    public List<NinjaModel> listar(){
        return ninjaRepository.findAll();
    }
    public NinjaModel listarPorId(Long id){
        return ninjaRepository.findById(id).orElse(null);
    }

    //TODO entender com isso funciona e replicar para as missões
    public NinjaModel cadastra(NinjaModel ninjaModel){
        return ninjaRepository.save(ninjaModel);
    }
    // DELETAR
    public void deleta(Long id){
        ninjaRepository.deleteById(id);
    }
    // UPDATE
    public NinjaModel atualiza(Long id, NinjaModel ninjaModelAtualizado){
        if (ninjaRepository.existsById(id)){
            ninjaModelAtualizado.setId(id);
            return ninjaRepository.save(ninjaModelAtualizado);
        }
        return null;
    }
}

