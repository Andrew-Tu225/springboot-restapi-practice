package com.andrew.demo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepo softwareEngineerRepo;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public SoftwareEngineerService(SoftwareEngineerRepo softwareEngineerRepo) {
        this.softwareEngineerRepo = softwareEngineerRepo;
    }

    public List<SoftwareEngineerDTO> getSoftwareEngineer(){
        List<SoftwareEngineer> softwareEngineerList = softwareEngineerRepo.findAll();
        return softwareEngineerList
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private SoftwareEngineerDTO convertToDTO(SoftwareEngineer softwareEngineer) {
        return modelMapper.map(softwareEngineer, SoftwareEngineerDTO.class);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id){
        return softwareEngineerRepo.findById(id)
                .orElseThrow(()-> new IllegalStateException("id not found"));
    }

    public void insertSoftwareEngineer(SoftwareEngineerDTO softwareEngineerDTO) {
        SoftwareEngineer newSoftwareEngineer = new SoftwareEngineer();
        newSoftwareEngineer.setName(softwareEngineerDTO.getName());
        newSoftwareEngineer.setTechStack(softwareEngineerDTO.getTechStack());
        softwareEngineerRepo.save(newSoftwareEngineer);
    }

    public void updateSoftwareEngineer(Integer id, SoftwareEngineer updatedSoftwareEngineer){
        SoftwareEngineer softwareEngineer = getSoftwareEngineerById(id);
        if (Objects.nonNull(updatedSoftwareEngineer.getName())
                && !"".equalsIgnoreCase(
                updatedSoftwareEngineer.getName())) {
            softwareEngineer.setName(
                    updatedSoftwareEngineer.getName());
        }

        if (Objects.nonNull(updatedSoftwareEngineer.getTechStack())
                && !"".equalsIgnoreCase(
                updatedSoftwareEngineer.getTechStack())) {
            softwareEngineer.setTechStack(
                    updatedSoftwareEngineer.getTechStack());
        }

        softwareEngineerRepo.save(softwareEngineer);
    }

    public void deleteSoftwareEngineer(Integer id) {
        softwareEngineerRepo.deleteById(id);
    }
}
