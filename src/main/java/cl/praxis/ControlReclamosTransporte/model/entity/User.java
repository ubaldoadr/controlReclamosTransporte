package cl.praxis.ControlReclamosTransporte.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.*;

import java.util.List;

@Entity
@Table(name="t_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name="t_user_role",

            joinColumns = @JoinColumn(name="user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName = "role_id"))
    List<Role> roles;

}