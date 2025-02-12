package es.vedruna.appVedruna.services;

import es.vedruna.appVedruna.model.Incidencia;
import es.vedruna.appVedruna.repository.IncidenciaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IncidenciaServiceImpl implements IncidenciaService {

    private final IncidenciaRepository incidenciaRepository;

    @Override
    public List<Incidencia> getAllIncidencias() {
        return incidenciaRepository.findAllByOrderByCreatedAtDesc();
    }

    @Override
    public Incidencia createIncidencia(Incidencia incidencia) {
        return incidenciaRepository.save(incidencia);
    }

    @Override
    public Incidencia updateEstado(String id, String nuevoEstado) {
        Optional<Incidencia> incidenciaOptional = incidenciaRepository.findById(id);

        if (incidenciaOptional.isPresent()) {
            Incidencia incidencia = incidenciaOptional.get();
            incidencia.setEstado(nuevoEstado); // Cambiar estado
            return incidenciaRepository.save(incidencia);
        } else {
            throw new RuntimeException("Incidencia no encontrada");
        }
    }
}
