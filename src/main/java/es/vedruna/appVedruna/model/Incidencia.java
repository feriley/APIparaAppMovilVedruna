package es.vedruna.appVedruna.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Document(collection = "incidencias") // Se guardará en la colección "incidencias"
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Incidencia {

    @MongoId
    private String id;
    private String user_id; // Usuario que reportó la incidencia
    private String equipo; // Nº del equipo o clase
    private String titulo; // Máx 40 caracteres
    private String descripcion; // Máx 250 caracteres
    private String estado = "En trámite"; // "En trámite", "Solucionado", "Denegado"
    private LocalDateTime createdAt = LocalDateTime.now(); // Fecha de creación
}
