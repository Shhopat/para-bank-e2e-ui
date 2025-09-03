package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegistration {

    @Builder.Default
    private String firstName = "John";

    @Builder.Default
    private String lastName = "Doe";

    @Builder.Default
    private String address = "123 Main St";

    @Builder.Default
    private String city = "New York";

    @Builder.Default
    private String state = "NY";

    @Builder.Default
    private String zipCode = "10001";

    @Builder.Default
    private String phone = "123-456-7890";

    @Builder.Default
    private String ssn = "123-45-6789";

    @Builder.Default
    private String username = "johndoe123";

    @Builder.Default
    private String password = "12121997";

    @Builder.Default
    private String confirmPassword = "12121997";
}

