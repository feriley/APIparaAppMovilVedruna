package es.vedruna.appVedruna.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Document(collection = "publicaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publicacion {
    @MongoId
    private String id;
    private String user_id;
    private String image_url;
    private String titulo;
    private String comentario;
    private List<String> like = new LinkedList<>();
    private LocalDateTime createdAt;

    // 🔹 Aseguramos que se genere `createdAt` al crear una instancia
    public Publicacion(String user_id, String image_url, String titulo, String comentario) {
        this.user_id = user_id;
        this.image_url = image_url;
        this.titulo = titulo;
        this.comentario = comentario;
        this.createdAt = LocalDateTime.now();
    }
}