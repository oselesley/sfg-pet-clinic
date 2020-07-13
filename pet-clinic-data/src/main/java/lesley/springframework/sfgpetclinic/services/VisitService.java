package lesley.springframework.sfgpetclinic.services;

import lesley.springframework.sfgpetclinic.model.Visit;
import org.springframework.stereotype.Service;

@Service
public interface VisitService extends CrudService<Long, Visit> {
}
