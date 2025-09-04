package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transfer {
    private String amount;
    private String fromAccount = "14454";
    private String toAccount = "13344";
}
