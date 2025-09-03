package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLogin {
    @Builder.Default
    private String username = "shhopat";
    @Builder.Default
    private String password = "12121997";
}
