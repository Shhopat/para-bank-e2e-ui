package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferPayee {

    @Builder.Default
    private String payeeName = "John Doe";

    @Builder.Default
    private String address = "123 Main St";

    @Builder.Default
    private String city = "New York";

    @Builder.Default
    private String state = "NY";

    @Builder.Default
    private String zipCode = "10001";

    @Builder.Default
    private String phoneNumber = "123-456-7890";

    @Builder.Default
    private String accountNumber = "12121";

    @Builder.Default
    private String verifyAccountNumber = "12121";

    @Builder.Default
    private String amount = "1000";


    private String fromAccountNumber;
}
