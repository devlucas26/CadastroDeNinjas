package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaModel> listar(){
        return ninjaRepository.findAll();
    }

    public List<NinjaDTO> listarDTO(){

        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .toList();
    }

    public NinjaModel listarPorId(Long id){
        return ninjaRepository.findById(id).orElse(null);
    }

    //TODO entender com isso funciona e replicar para as missões
    public NinjaModel cadastra(NinjaModel ninjaModel){
        return ninjaRepository.save(ninjaModel);
    }
    // cadastrar usando DTO
    public NinjaDTO cadastroDTO(NinjaDTO ninjaDTO){

        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
        ninjaModel = ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
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

