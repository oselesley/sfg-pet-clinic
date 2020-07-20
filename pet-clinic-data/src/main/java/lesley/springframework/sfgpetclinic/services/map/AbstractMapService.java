package lesley.springframework.sfgpetclinic.services.map;


import lesley.springframework.sfgpetclinic.model.BaseEntity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<ID, T extends BaseEntity> {
    private Map<ID, T> abstMap = new HashMap<>();
    private Long objID = 1L;

    public Map<ID, T> getAbstMap() {
        return abstMap;
    }

    public void setAbstMap(Map<ID, T> abstMap) {
        this.abstMap = abstMap;
    }

    public T findById(ID id) {
        return abstMap.get(id);
    }

    public T save(T object) {
        if (object.getId() == null) {
            object.setId(objID);
            getNextID();
        }

        abstMap.put((ID) object.getId(), object);
        return object;
    }

    public Set<T> findAll() {
        return new HashSet<>(abstMap.values());
    }

    public void delete(ID id) {
        abstMap.remove(id);
    }

    public void deleteByObject(T object) {
        abstMap.entrySet().removeIf(idtEntry -> idtEntry.getValue().equals(object));
    }

    private void getNextID () {
        this.objID++;
    }
}
