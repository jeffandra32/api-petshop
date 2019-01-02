package com.api.zoobook.restapizoobook.domain;

import com.api.zoobook.restapizoobook.domain.enums.Perfil;
import com.api.zoobook.restapizoobook.domain.enums.TipoUsuario;
import com.api.zoobook.restapizoobook.domain.pet.Pet;
import com.api.zoobook.restapizoobook.domain.servico.Servico;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Column(unique=true)
    private String email;
    @JsonIgnore
    private String password;

    private String cpfOuCnpj;
    private Date birthDate;
    private Integer type;
    private String imageUrl;
    private Date createAt;


    @OneToMany(mappedBy="usuario", cascade=CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(mappedBy="usuario", cascade=CascadeType.ALL)
    private List<Localizacao> localizacao = new ArrayList<>();


    @ElementCollection
    @CollectionTable(name="TELEFONE")
    private Set<String> telefones = new HashSet<>();

    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name="PERFIS")
    private Set<Integer> perfis = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy="usuario")
    private List<Servico> servicos = new ArrayList<>();


    @OneToMany(mappedBy="usuario")
    private List<Pet> pets = new ArrayList<>();

    public Usuario() {
        addPerfil(Perfil.USUARIO);
    }

    public Usuario(Integer id, String name, String email,  String cpfOuCnpj, Date birthDate, Date createAt ,TipoUsuario type, String password) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.type = (type==null) ? null : type.getCod();
        this.password = password;
        this.birthDate = birthDate;
        this.createAt = createAt;
        addPerfil(Perfil.USUARIO);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        perfis.add(perfil.getCod());
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public List<Localizacao> getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacaos(List<Localizacao> localizacao) {
        this.localizacao = localizacao;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}