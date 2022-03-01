package uz.pdp.lesson10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.lesson10.payload.HotelDto;
import uz.pdp.lesson10.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelService service;

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
    public HttpEntity<?> saveOrEdit(@RequestBody HotelDto hotelDto){
        return ResponseEntity.status(200).body(service.saveOrEdit(hotelDto));
    }
}
