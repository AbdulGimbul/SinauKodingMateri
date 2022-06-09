package com.example.Bootcamp.SinauKoding.service;

import com.example.Bootcamp.SinauKoding.entity.DetailUser;
import com.example.Bootcamp.SinauKoding.entity.User;
import com.example.Bootcamp.SinauKoding.entity.dto.UserDTO;
import com.example.Bootcamp.SinauKoding.entity.mapping.UserMapping;
import com.example.Bootcamp.SinauKoding.repository.DetailUserRepository;
import com.example.Bootcamp.SinauKoding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    DetailUserRepository detailUserRepository;

    public UserDTO save(UserDTO param){
        User user = repository.save(UserMapping.INSTANCE.toEntity(param));
        return UserMapping.INSTANCE.toDto(user);
    }


    public List<UserDTO> lihatSemuaData(){
        return UserMapping.INSTANCE.toUserDTOList(repository.findAll());
    }

    public List<UserDTO> findByProfileName(String param){
        return UserMapping.INSTANCE.toUserDTOList(repository.findByProfileNameContaining(param));
    }

    public UserDTO findById(Integer id){
        return UserMapping.INSTANCE.toDto(repository.findById(id).get());
    }

    public UserDTO updateData(UserDTO dto, Integer id){
        User referenceData = repository.findById(id).get();
        referenceData.setUsername(dto.getUsername() != null ? dto.getUsername() : referenceData.getUsername());
        referenceData.setProfileName(dto.getProfileName() != null ? dto.getProfileName() : referenceData.getProfileName());

        return UserMapping.INSTANCE.toDto(repository.save(referenceData));
    }

    public boolean deleteData(int id){
        User reference = repository.findById(id).orElse(null);

        if (reference != null){
            repository.delete(reference);
            return true;
        }

        return false;
    }

    public Integer countData(String nama){
        if (nama != null){
            return repository.countByProfileNameContaining(nama);
        }

        return (int) repository.count();
    }
}
