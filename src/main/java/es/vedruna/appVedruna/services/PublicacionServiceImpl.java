package es.vedruna.appVedruna.services;

import es.vedruna.appVedruna.model.Comentario;
import es.vedruna.appVedruna.model.Publicacion;
import es.vedruna.appVedruna.repository.PuplicacionesRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class PublicacionServiceImpl implements PublicacionService {
    private final PuplicacionesRepository puplicacionesRepository;

    // 🔹 Obtener todas las publicaciones ordenadas por fecha
    public List<Publicacion> getAllPublicaciones() {
        return puplicacionesRepository.findAllByOrderByCreatedAtDesc();
    }

    // 🔹 Obtener publicación por ID
    @Override
    public Optional<Publicacion> getById(String id_publicacion) {
        return puplicacionesRepository.findById(id_publicacion);
    }

    // 🔹 Crear una nueva publicación con `createdAt`
    @Override
    public Publicacion createPublicacion(Publicacion publicacion) {
        publicacion.setCreatedAt(LocalDateTime.now()); // Generar la fecha al crear
        return puplicacionesRepository.save(publicacion);
    }

    // 🔹 Actualizar título y comentario de una publicación
    @Override
    public Optional<Publicacion> updatePublicacion(String id, Publicacion updatedData) {
        Optional<Publicacion> existingPublicacion = puplicacionesRepository.findById(id);
        if (existingPublicacion.isPresent()) {
            Publicacion publicacion = existingPublicacion.get();
            publicacion.setTitulo(updatedData.getTitulo());
            publicacion.setComentario(updatedData.getComentario());
            return Optional.of(puplicacionesRepository.save(publicacion));
        }
        return Optional.empty();
    }

    // 🔹 Dar/Quitar like a una publicación
    @Override
    public Publicacion updateLike(String id_publicacion, String id_user) {
        Optional<Publicacion> publicacionOptional = puplicacionesRepository.findById(id_publicacion);
        if(publicacionOptional.isPresent()) {
            Publicacion publicacion = publicacionOptional.get();
            List<String> likes = publicacion.getLike();
            if (!likes.contains(id_user)) {
                likes.add(id_user);
            } else {
                likes.remove(id_user);
            }
            publicacion.setLike(likes);
            return puplicacionesRepository.save(publicacion);
        } else {
            throw new RuntimeException("Publicación no encontrada");
        }
    }

    // 🔹 Eliminar publicación (solo el creador puede eliminarla)
    @Override
    public boolean deletePublicacion(String id, String userId) {
        Optional<Publicacion> publicacion = puplicacionesRepository.findById(id);
        if (publicacion.isPresent() && publicacion.get().getUser_id().equals(userId)) {
            puplicacionesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}