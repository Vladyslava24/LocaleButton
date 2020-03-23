package ua.testing.locale.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDTO {
    private Long id;
    private String nameEng;
    private String nameUkr;
}
