package es.vedruna.appVedruna.services;

import es.vedruna.appVedruna.model.Comentario;
import es.vedruna.appVedruna.repository.ComentariosRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ComentarioServiceImpl implements ComentarioService {

    private final ComentariosRepository comentariosRepository;

    // Guardar nuevo comentario
    @Override
    public Comentario crearComentario(Comentario comentario) {
        return comentariosRepository.save(comentario);
    }

    // Obtener todos los comentarios
    @Override
    public List<Comentario> getAllComentarios() {
        return comentariosRepository.findAll();
    }

    // Obtener comentarios de una publicación
    @Override
    public List<Comentario> getComentariosByIdPublicacion(String id_publicacion) {
        return comentariosRepository.findAllByIdPublicacion(id_publicacion);
    }
}