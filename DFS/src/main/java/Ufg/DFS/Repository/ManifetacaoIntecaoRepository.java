package Ufg.DFS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Ufg.DFS.Model.ManifestacaoIntencao;

public interface ManifetacaoIntecaoRepository  extends JpaRepository<ManifestacaoIntencao, Integer>{
     List<ManifestacaoIntencao> findByDocenteId(Integer docenteId);
}

