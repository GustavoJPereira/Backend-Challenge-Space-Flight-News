package com.testes.desafiocoodesh.repository;

import com.testes.desafiocoodesh.entity.UltimoIdSpacefly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RepositoryUltimoIdSpacefly extends JpaRepository<UltimoIdSpacefly, Long> {

    //Query usada para achar o último id da space fly que foi copiado para o banco
    @Query(value = "SELECT * FROM ultimo_id_spacefly WHERE id = 1", nativeQuery = true)
    public UltimoIdSpacefly findUltimo();

    //Query usada para atualizar qual foi o ultimo id copiado para o banco
    @Transactional
    @Modifying
    @Query(value = "UPDATE ultimo_id_spacefly SET ultimo = ? where id = 1", nativeQuery = true)
    public void atualizarUltimo(Long valor);

    //Query usara quando o banco é criado pela primeira vez. Ela faz o valor de ultimo se tornar zero para que o
    // servidor comece pelo primeiro id e só é executada uma vez.
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO ultimo_id_spacefly values ('1', '0'); ", nativeQuery = true)
    public void iniciarBanco();
}
