package uz.pdp.lesson10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.lesson10.entity.Hotel;

public interface HotelRepo extends JpaRepository<Hotel,Integer> {

}
