package es.vedruna.appVedruna.controller;


import es.vedruna.appVedruna.model.Comentario;
import es.vedruna.appVedruna.model.Publicacion;
import es.vedruna.appVedruna.services.PublicacionServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proyecto01/publicaciones")
@AllArgsConstructor
public class PublicacionesController {
    private final PublicacionServiceImpl publicacionServiceImpl;

    // 🔹 Obtener una publicación por ID
    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> getPublicacionById(@PathVariable String id) {
        Optional<Publicacion> publicacion = publicacionServiceImpl.getById(id);
        return publicacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 🔹 Crear publicación
    @PostMapping()
    public Publicacion createPublicacion(@RequestBody Publicacion publicacion) {
        return publicacionServiceImpl.createPublicacion(publicacion);
    }

    // 🔹 Actualizar publicación (solo título y comentario)
    @PutMapping("/{id}")
    public ResponseEntity<Publicacion> updatePublicacion(@PathVariable String id, @RequestBody Publicacion updatedData) {
        Optional<Publicacion> updatedPublicacion = publicacionServiceImpl.updatePublicacion(id, updatedData);
        return updatedPublicacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 🔹 Dar/Quitar like a una publicación
    @PutMapping("/put/{id}/{id_user}")
    public Publicacion updateLike(@PathVariable String id, @PathVariable String id_user){
        return publicacionServiceImpl.updateLike(id, id_user);
    }

    // 🔹 Eliminar una publicación (solo el creador puede hacerlo)
    @DeleteMapping("/{id}/{userId}")
    public ResponseEntity<Void> deletePublicacion(@PathVariable String id, @PathVariable String userId) {
        boolean deleted = publicacionServiceImpl.deletePublicacion(id, userId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    // 🔹 Obtener todas las publicaciones ordenadas por fecha
    @GetMapping()
    public List<Publicacion> getAllPublicaciones() {
        return publicacionServiceImpl.getAllPublicaciones();
    }
}
