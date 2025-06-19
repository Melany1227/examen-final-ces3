package com.ces3.examen.examen_final.controlador;

import com.ces3.examen.examen_final.modelo.Teacher;
import com.ces3.examen.examen_final.repositorio.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @GetMapping("/{id}/salario-anual")
    public Map<String, Object> obtenerSalarioAnualPorId(@PathVariable Long id) {
        Map<String, Object> respuesta = new HashMap<>();
        try {
            Teacher t = teacherRepository.findById(id).orElseThrow();
            respuesta.put("nombre", t.getName() + " " + t.getLastName());
            respuesta.put("salarioAnual", t.calcularSalarioAnual());
        } catch (NoSuchElementException e) {
            respuesta.put("error", "Profesor no encontrado");
        }
        return respuesta;
    }
}
