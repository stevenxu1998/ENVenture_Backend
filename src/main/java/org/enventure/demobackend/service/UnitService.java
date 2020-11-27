package org.enventure.demobackend.service;

import org.enventure.demobackend.domain.Unit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitService {
    public Unit createUnit (Unit unit);
    public List<Unit> getUnits();
    public Unit getUnit(Long id);
    public void updateUnit(Long id, Unit unit);
    public void deleteUnit(Long id);

}
