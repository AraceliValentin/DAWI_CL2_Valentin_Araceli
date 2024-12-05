package pe.edu.i202030295.cl2_valentin_araceli.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer filmId;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;
    private Integer releaseYear;
    private Integer rentalDuration;
    private Double rentalRate;
    private Integer length;
    private Double replacementCost;
    private String rating;

    @Column(columnDefinition = "SET('Trailers','Commentaries','Deleted Scenes','Behind the Scenes')")
    private String specialFeatures;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUpdate;


    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    @ManyToOne
    @JoinColumn(name = "original_language_id")
    private Language originalLanguage;

    @OneToMany(mappedBy = "film")
    private List<FilmActor> filmActors;

    @OneToMany(mappedBy = "film")
    private List<FilmCategory> filmCategories;

    @OneToMany(mappedBy = "film")
    private List<Inventory> inventories;

}
