package es.vedruna.appVedruna.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "comentarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {

    @MongoId
    private String id;
    private String user_id; // Usuario que hizo el comentario
    private String idPublicacion; // ID de la publicación asociada
    private String comentario;
    private LocalDateTime createdAt = LocalDateTime.now(); // Agregamos fecha de creación
}