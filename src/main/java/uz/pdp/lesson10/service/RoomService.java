package uz.pdp.lesson10.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.lesson10.entity.Hotel;
import uz.pdp.lesson10.entity.Room;
import uz.pdp.lesson10.payload.RoomDto;
import uz.pdp.lesson10.repository.HotelRepo;
import uz.pdp.lesson10.repository.RoomRepo;
import uz.pdp.lesson10.utills.CommandUtills;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {
    @Autowired
    RoomRepo roomRepo;

    @Autowired
    HotelRepo hotelRepo;

    @Autowired
    HotelService hotelService;

    public List<RoomDto> getAll() {
      return roomRepo.findAll().stream().map(this::generateRoomDto).collect(Collectors.toList());
    }

    public RoomDto generateRoomDto(Room room){
        return new RoomDto(room.getId(),room.getName(),room.getFloor(),room.getSize(),hotelService.generateHotelDto(room.getHotel()));
    }

    public RoomDto getById(Integer id) {
        return generateRoomDto(roomRepo.getById(id));
    }

    public String delete(Integer id) {
      roomRepo.deleteById(id);
      return "Room has been deleted!";
    }

    public String saveOrEdit(RoomDto dto) {
        Integer id = dto.getId();
         Room room = new Room();
         if(id!=null){
             room = roomRepo.getById(id);
         }
         room.setName(dto.getNumber());
         room.setFloor(dto.getFloor());
         room.setSize(dto.getSize());
         room.setHotel(hotelRepo.getById(dto.getHotelDto().getId()));
         roomRepo.save(room);
         return id!=null?"Room has been edited!":"Room has been saved!";
    }

    @SneakyThrows
    public List<RoomDto> getByPageable(Integer page, Integer size, Integer hotelId) {
       return roomRepo.getAllByHotelId(hotelId,CommandUtills.simplePageable(page,size)).getContent().stream().map(this::generateRoomDto).collect(Collectors.toList());
    }
}
