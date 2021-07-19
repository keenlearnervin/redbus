package com.tech.interview.siply.redbus.service.implementation;

import com.tech.interview.siply.redbus.entity.dao.assets.Bus;
import com.tech.interview.siply.redbus.entity.dto.BusDTO;
import com.tech.interview.siply.redbus.repository.contract.assets.BusRepository;
import com.tech.interview.siply.redbus.service.contract.BusService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public BusDTO getById(UUID busId) {
        return modelMapper.map(busRepository.findById(busId).get(), BusDTO.class);
    }

    @Override
    public List<BusDTO> getByOwnerId(UUID ownerId) {
        Pageable pageable = PageRequest.of(0, 10);
        return busRepository.findAllByOwnerId(ownerId, pageable).stream().map(bus ->
                modelMapper.map(bus, BusDTO.class)
        ).collect(Collectors.toList());
    }
}
