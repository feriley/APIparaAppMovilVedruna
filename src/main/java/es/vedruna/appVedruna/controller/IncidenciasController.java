package es.vedruna.appVedruna.controller;

import es.vedruna.appVedruna.model.Incidencia;
import es.vedruna.appVedruna.services.IncidenciaServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecto01/incidencias")
@AllArgsConstructor
public class IncidenciasController {

    private final IncidenciaServiceImpl incidenciaServiceImpl;

    // Obtener todas las incidencias
    @GetMapping()
    public List<Incidencia> getAllIncidencias() {
        return incidenciaServiceImpl.getAllIncidencias();
    }

    // Crear una nueva incidencia
    @PostMapping()
    public Incidencia createIncidencia(@RequestBody Incidencia incidencia) {
        return incidenciaServiceImpl.createIncidencia(incidencia);
    }

    // Actualizar estado de una incidencia
    @PutMapping("/{id}/{estado}")
    public Incidencia updateEstado(@PathVariable String id, @PathVariable String estado) {
        return incidenciaServiceImpl.updateEstado(id, estado);
    }
}
