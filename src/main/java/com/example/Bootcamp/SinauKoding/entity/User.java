package com.example.Bootcamp.SinauKoding.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "username")
    private String username;

    @Column(name = "profile_name")
    private String profileName;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date date;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_detail")
    private DetailUser detailUser;

    @OneToMany(mappedBy = "user")
    private List<DetailUser> detailUserList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserDetailUser> userDetailUsers = new ArrayList<>();
}
