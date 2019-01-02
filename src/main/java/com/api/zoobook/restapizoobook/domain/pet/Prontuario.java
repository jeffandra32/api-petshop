package com.api.zoobook.restapizoobook.domain.pet;

import com.api.zoobook.restapizoobook.domain.DBFile;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Prontuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    /*
     *  veterinário
     *  endereço
     *  número
     *  complemento
     *  bairro
     *  cep
     * */
    private String vet;
    private String address;
    private String number;
    private String complement;
    private String neighborhood;
    private String cep;

    @OneToOne
    private DBFile dbFile;

    @ElementCollection
    @CollectionTable(name="TELEFONE_PRONTUARIO")
    private Set<String> telefones = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy="prontuario")
    private List<Vacina> vacinas = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="pet_id")
    private Pet pet;

    public Prontuario() {
    }

    public Prontuario(Integer id, String vet, String address, String number, String complement, String neighborhood, String cep, DBFile dbFile, Pet pet) {
        this.id = id;
        this.vet = vet;
        this.address = address;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.cep = cep;
        this.dbFile = dbFile;
        this.pet = pet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prontuario that = (Prontuario) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVet() {
        return vet;
    }

    public void setVet(String vet) {
        this.vet = vet;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public DBFile getDbFile() {
        return dbFile;
    }

    public void setDbFile(DBFile dbFile) {
        this.dbFile = dbFile;
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }

    public void setVacinas(List<Vacina> vacinas) {
        this.vacinas = vacinas;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
