package org.enventure.demobackend.controller;

import org.enventure.demobackend.domain.Unit;
import org.enventure.demobackend.repository.UnitRepository;
import org.enventure.demobackend.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Units")
public class UnitController {
    @Autowired
    private UnitService unitService;
    private UnitRepository unitRepository;

    @GetMapping
    public List<Unit> getAllUnits(){return unitService.getUnits();}

    @GetMapping("/{id}")
    public Unit getUnit(@PathVariable Long id){return unitService.getUnit(id);}

    @PostMapping
    public void createUnit (@RequestBody Unit unit){unitService.createUnit(unit);}

    //updateUnit
    @RequestMapping(value = "/Units/{id}", method = RequestMethod.PUT)
    public void updateUnit(@PathVariable Long id){
        Unit newUnit = unitRepository.findById(id).get();
        unitService.updateUnit(id, newUnit);
    }

    @DeleteMapping("/{id}")
    public void deleteUnit (@PathVariable("id") Long id){unitService.deleteUnit(id);}
}
