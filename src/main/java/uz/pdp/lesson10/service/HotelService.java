package uz.pdp.lesson10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.lesson10.entity.Hotel;
import uz.pdp.lesson10.payload.HotelDto;
import uz.pdp.lesson10.repository.HotelRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {
    @Autowired
    HotelRepo hotelRepo;


    public List<HotelDto> getAll() {
        return hotelRepo.findAll().stream().map(this::generateHotelDto).collect(Collectors.toList());
    }

    public HotelDto generateHotelDto(Hotel hotel){
        return new HotelDto(hotel.getId(),hotel.getName());
    }

    public HotelDto getById(Integer id) {
       return generateHotelDto(hotelRepo.getById(id));
    }

    public String delete(Integer id) {
        hotelRepo.deleteById(id);
        return "Hotel has been deleted!";
    }

    public String saveOrEdit(HotelDto dto) {
        Integer id = dto.getId();
        Hotel hotel = new Hotel();
        if(id!=null){
            hotel = hotelRepo.getById(id);
        }
        hotel.setName(dto.getName());
        hotelRepo.save(hotel);
        return id!=null?"Hotel has been edited!":"Hotel has been saved!";
    }
}
