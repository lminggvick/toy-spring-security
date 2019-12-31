package toy.spring.ssl.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {
    private String userId;
    private String password;
    private String email;
    private String role;
}
