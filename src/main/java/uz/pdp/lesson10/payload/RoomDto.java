package uz.pdp.lesson10.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    private Integer id;
    private String number;
    private Integer floor;
    private Double size;
    private HotelDto hotelDto;
}
