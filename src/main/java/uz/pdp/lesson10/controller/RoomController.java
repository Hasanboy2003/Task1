package uz.pdp.lesson10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.lesson10.payload.RoomDto;
import uz.pdp.lesson10.service.RoomService;
import uz.pdp.lesson10.utills.AppConstants;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    RoomService service;

    @GetMapping("/all")
    public HttpEntity<?> getAll(){
        return ResponseEntity.status(200).body(service.getAll());
    }

    @GetMapping("/byId/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(service.getById(id));
    }

    @DeleteMapping("/byId/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.status(200).body(service.delete(id));
    }

    @PostMapping("/saveOrEdit")
    public HttpEntity<?> saveOrEdit(@RequestBody RoomDto dto){
        return ResponseEntity.status(200).body(service.saveOrEdit(dto));
    }
    @GetMapping("/pageable")
    public HttpEntity<?> getbyPageable( @RequestParam(value = "page",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER)Integer page,
                                        @RequestParam(value = "size",defaultValue = AppConstants.DEFAULT_PAGE_SIZE)Integer size,
                                        @RequestParam(value = "hotelId",defaultValue = "0") Integer hotelId){
        return ResponseEntity.status(200).body(service.getByPageable(page,size,hotelId));
    }
}
