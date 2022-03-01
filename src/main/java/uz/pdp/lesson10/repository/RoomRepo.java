package uz.pdp.lesson10.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.lesson10.entity.Room;

public interface RoomRepo extends JpaRepository<Room,Integer> {
    Page<Room> getAllByHotelId(Integer hotel_id, Pageable pageable);
}
