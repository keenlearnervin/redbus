package com.tech.interview.siply.redbus.service.implementation;

import com.tech.interview.siply.redbus.entity.dao.assets.Bus;
import com.tech.interview.siply.redbus.entity.dto.BusDTO;
import com.tech.interview.siply.redbus.repository.contract.assets.BusRepository;
import com.tech.interview.siply.redbus.service.contract.BusService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class BusServiceImpl implements BusService {
    final ModelMapper modelMapper = new ModelMapper();

    BusRepository busRepository;

    @Override
    public String addNewBus(BusDTO busDTO) {
        Bus bus = new Bus(busDTO);
        busRepository.save(bus);
        return "Saved Bus";
    }

    @Override
    public void deleteById(UUID busId) {
        busRepository.deleteById(busId);
    }

    @Override
    public BusDTO getById(UUID ownerId) {
        BusDTO busDTO = modelMapper.map(busRepository.findById(ownerId).get(), BusDTO.class);
        return busDTO;
    }
}
