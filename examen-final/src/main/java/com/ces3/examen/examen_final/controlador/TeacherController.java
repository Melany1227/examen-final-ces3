package com.ces3.examen.examen_final.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ces3.examen.examen_final.modelo.Teacher;
import com.ces3.examen.examen_final.repositorio.TeacherRepository;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @PostMapping
    public Teacher crearProfesor(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @GetMapping
    public List<Teacher> obtenerTodos() {
        return teacherRepository.findAll();
    }

    @GetMapping("/salarios-anuales")
    public List<Map<String, Object>> obtenerSalariosAnuales() {
        List<Map<String, Object>> resultado = new ArrayList<>();
        for (Teacher t : teacherRepository.findAll()) {
            Map<String, Object> mapa = new HashMap<>();
            mapa.put("nombre", t.getName() + " " + t.getLastName());
            mapa.put("salarioAnual", t.calcularSalarioAnual());
            resultado.add(mapa);
        }
        return resultado;
    }
}
