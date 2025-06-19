package com.ces3.examen.examen_final.repositorio;

import com.ces3.examen.examen_final.modelo.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
