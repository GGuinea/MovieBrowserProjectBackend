package movie.movieShow.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private boolean isBanned;

    private boolean isAdmin;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String email;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(unique = true, nullable = false, length = 20)
    private String name;

    @OneToMany
    private List<Movie> favoriteMovies;

    @ManyToMany
    private List<Role> roles;
}
