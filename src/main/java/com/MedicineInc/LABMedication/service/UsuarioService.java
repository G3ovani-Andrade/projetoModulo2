package com.MedicineInc.LABMedication.service;

import com.MedicineInc.LABMedication.entity.UsuarioEntity;
import com.MedicineInc.LABMedication.enums.EstadoCivilEnum;
import com.MedicineInc.LABMedication.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;
    public UsuarioEntity cadastrarUsuario(UsuarioEntity novoUsuario){
        return this.repository.save(novoUsuario);
    }
}
