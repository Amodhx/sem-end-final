package lk.ijse.finalproject02.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentDTO {
    private int studentid;
    private String firstName;
    private String lastName;
    private String gender;
    private String NIC;
    private int classId;
    private String contactnumber;
    private String email;
    private int parentId;
}
