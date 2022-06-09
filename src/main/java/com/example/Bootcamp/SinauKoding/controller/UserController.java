package com.example.Bootcamp.SinauKoding.controller;

import com.example.Bootcamp.SinauKoding.common.Response;
import com.example.Bootcamp.SinauKoding.entity.User;
import com.example.Bootcamp.SinauKoding.entity.dto.UserDTO;
import com.example.Bootcamp.SinauKoding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping
    public com.example.Bootcamp.SinauKoding.common.Response saveUser(@RequestBody UserDTO param){
        return new com.example.Bootcamp.SinauKoding.common.Response(service.save(param), "Data berhasil disimpan", HttpStatus.OK);
    }

    @GetMapping
    public Response findAll(){
        return new com.example.Bootcamp.SinauKoding.common.Response(service.lihatSemuaData(), "Data berhasil ditampilkan", service.countData(null), HttpStatus.OK);
    }

    @GetMapping(value = "/find-by-profile-name")
    public Response findByProfileName(@RequestParam(value = "profile-name") String profileName,
                                        @RequestParam(value = "username", required = false) String userName){
        List<UserDTO> data = service.findByProfileName(profileName);
        return new Response(data, data.isEmpty() ? "Data tidak ditemukan" : "Data ditemukan", service.countData(profileName), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public Response findById(@PathVariable int id){
        UserDTO data = service.findById(id);
        return new Response(data, data != null ? "Data dengan id tersebut tidak ditemukan" : "Data ditemukan", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public Response updateData(@RequestBody UserDTO param, @PathVariable int id){
        return new Response(service.updateData(param, id), "Data berhasil disimpan", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public Response deleteData(@PathVariable int id) {
        if (service.deleteData(id)) {
            return new Response("Data berhasil dihapus", HttpStatus.OK);
        } else {
            return new Response("Data gagal dihapus", HttpStatus.OK);
        }
    }
}
