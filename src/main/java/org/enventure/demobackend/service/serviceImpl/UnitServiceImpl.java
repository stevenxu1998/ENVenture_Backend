package org.enventure.demobackend.service.serviceImpl;

import org.enventure.demobackend.domain.Unit;
import org.enventure.demobackend.repository.UnitRepository;
import org.enventure.demobackend.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {
    @Autowired
    private UnitRepository unitRepository;

    @Override
    public Unit createUnit (Unit unit){ return unitRepository.save(unit);}

    @Override
    public List<Unit> getUnits() {
        return unitRepository.findAll();
    }

    @Override
    public Unit getUnit (Long id){
        return unitRepository.findById(id).get();
    }

    @Override
    public void updateUnit (Long id, Unit unit){
        Unit newUnit = unitRepository.findById(id).get();
        newUnit.setFileNames(newUnit.getFileNames());
        newUnit.setQuizList(newUnit.getQuizList());
        newUnit.setSection(newUnit.getSection());
        unitRepository.save(newUnit);
    }

    @Override
    public void deleteUnit (Long id){
        unitRepository.deleteById(id);
    }
}
