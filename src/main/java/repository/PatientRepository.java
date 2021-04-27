package repository;

import domain.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>, CrudRepository<Patient, Long> {

    public List<Patient> findAll();
}
