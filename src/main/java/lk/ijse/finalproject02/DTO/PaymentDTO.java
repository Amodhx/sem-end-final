package lk.ijse.finalproject02.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private int paymentId;
    private int studentId;
    private String amount;
    private String month;
    private String clasid;

}
