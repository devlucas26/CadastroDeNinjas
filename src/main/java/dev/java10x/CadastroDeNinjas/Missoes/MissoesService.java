package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }
    public List<MissoesModel> listar(){
        return missoesRepository.findAll();
    }
    public MissoesModel listarPorId(Long id){
        return missoesRepository.findById(id).orElse(null);
    }
    public MissoesModel cadastraMissao(MissoesModel missoesModel){
        return missoesRepository.save(missoesModel);
    }
    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }
}
