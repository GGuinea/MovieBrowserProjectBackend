package movie.movieShow.model;

import lombok.*;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String email;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(unique = true, nullable = false, length = 20)
    private String name;
}
