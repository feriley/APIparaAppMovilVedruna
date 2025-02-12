package es.vedruna.appVedruna.repository;

import es.vedruna.appVedruna.model.Incidencia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidenciaRepository extends MongoRepository<Incidencia, String> {
    List<Incidencia> findAllByOrderByCreatedAtDesc(); // Obtener incidencias ordenadas por fecha
}
