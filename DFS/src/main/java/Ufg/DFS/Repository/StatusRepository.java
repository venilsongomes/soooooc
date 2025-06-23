package Ufg.DFS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Ufg.DFS.Model.Status;

public interface StatusRepository extends JpaRepository <Status, Integer> {
    
}
