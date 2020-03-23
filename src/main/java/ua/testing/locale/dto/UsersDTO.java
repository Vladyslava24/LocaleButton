package ua.testing.locale.dto;

import lombok.*;
import ua.testing.locale.entity.User;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UsersDTO {
    private List<User> users;
}
