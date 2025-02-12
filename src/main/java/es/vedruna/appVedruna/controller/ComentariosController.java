package es.vedruna.appVedruna.controller;

import es.vedruna.appVedruna.model.Comentario;
import es.vedruna.appVedruna.services.ComentarioServiceImpl;
import es.vedruna.appVedruna.services.PublicacionServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecto01/comentarios")
@AllArgsConstructor
public class ComentariosController {
    
    private final ComentarioServiceImpl comentarioServiceImpl;

    // Obtener todos los comentarios (nuevo endpoint)
    @GetMapping()
    public List<Comentario> getAllComentarios() {
        return comentarioServiceImpl.getAllComentarios();
    }

    // Obtener comentarios por ID de publicación
    @GetMapping("/{id_publicacion}")
    public List<Comentario> getComentariosByIdPublicacion(@PathVariable String id_publicacion) {
        return comentarioServiceImpl.getComentariosByIdPublicacion(id_publicacion);
    }

    // Crear un nuevo comentario (mejoramos la ruta)
    @PostMapping()
    public Comentario createComentario(@RequestBody Comentario comentario) {
        return comentarioServiceImpl.crearComentario(comentario);
    }
}