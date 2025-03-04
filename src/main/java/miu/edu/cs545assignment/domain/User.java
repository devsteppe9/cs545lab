package miu.edu.cs545assignment.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany()
    @JoinColumn(name = "user_id")
    @Cascade(CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    List<Post> posts;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable()
    List<Role> roles;
}
