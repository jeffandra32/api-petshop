package com.api.zoobook.restapizoobook.repositores;

import com.api.zoobook.restapizoobook.domain.socialNetwork.ProfileFornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileFornecedorRepository extends JpaRepository<ProfileFornecedor, Integer> {


}
