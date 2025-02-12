package es.vedruna.appVedruna.services;

import es.vedruna.appVedruna.model.Incidencia;

import java.util.List;

public interface IncidenciaService {
    List<Incidencia> getAllIncidencias();
    Incidencia createIncidencia(Incidencia incidencia);
    Incidencia updateEstado(String id, String nuevoEstado);
}
