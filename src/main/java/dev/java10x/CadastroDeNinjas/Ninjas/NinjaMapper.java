package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO){

        NinjaModel ninjaModel = new NinjaModel();

        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setImgUrl(ninjaDTO.getUrl_img());
        ninjaModel.setMissoes(ninjaDTO.getMissoes());
        ninjaModel.setNinja_rank(ninjaDTO.getNinja_rank());

        return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjaModel){

        NinjaDTO ninjaDTO = new NinjaDTO();

        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setUrl_img(ninjaModel.getImgUrl());
        ninjaDTO.setMissoes(ninjaModel.getMissoes());
        ninjaDTO.setNinja_rank(ninjaModel.getNinja_rank());

        return ninjaDTO;

    }

}
