package com.tech.interview.siply.redbus.controller.assets;

import com.tech.interview.siply.redbus.entity.dto.BusDTO;
import com.tech.interview.siply.redbus.service.contract.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/assets/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @PostMapping
    public String addNewBus(@RequestBody BusDTO busDTO) {
        return busService.addNewBus(busDTO);
    }


    @GetMapping("/{busId}")
    public BusDTO getBusById(@PathVariable UUID busId) {
        return busService.getById(busId);
    }

//    @GetMapping("/{ownerId}")
//    public BusDTO getBusesByOwnerId(@PathVariable UUID ownerId) {
//        return busService.getBusesByOwnerId(ownerId);
//    }

    @DeleteMapping("/{busId}")
    public void deleteBusById(@PathVariable UUID busId) {
        busService.deleteById(busId);
    }
}
