package com.example.staffmanagement.service.impl;

import com.example.staffmanagement.dto.request.Search;
import com.example.staffmanagement.dto.response.StaffDto;
import com.example.staffmanagement.model.Staff;
import com.example.staffmanagement.repository.IStaffRepo;
import com.example.staffmanagement.service.IStaffService;
import lombok.AllArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@AllArgsConstructor
public class StaffService implements IStaffService {

   private IStaffRepo staffRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public StaffDto save(StaffDto staff) {
        Staff s = new Staff(staff);
        Staff staff1 = staffRepo.save(s);
        return new StaffDto(staff1);
    }

    @Override
    public void deleteById(Long id) {
        Staff staff = staffRepo.findByIdAndDeletedIsFalse(id).orElseThrow(() -> new ResourceNotFoundException("Invalid staff id : " + id));
        staff.setDeleted(true);
        staffRepo.save(staff);
    }

    @Override
    public Page<StaffDto> search(Search search, int page, int size) {
        StringBuilder builder = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        Pageable pageable =  PageRequest.of(page - 1, size);

        builder.append("select s ");
        builder.append("from Staff s ");
        builder.append("where 1=1 ");
        if (search.getCode() != null) {
            builder.append("and s.code like :code ");
            params.put("code", "%" + search.getCode() + "%");
        }
        if (search.getName() != null) {
            builder.append("and s.name like :name");
            params.put("name", "%" + search.getName() + "%");
        }
        Query query = entityManager.createQuery(builder.toString()).setMaxResults(size).setFirstResult((int)pageable.getOffset());
        for (String key : params.keySet()) {
            query.setParameter(key, params.get(key));
        }
        List<StaffDto> list = query.getResultList();
        Page<StaffDto> page2 = new PageImpl<>(list, pageable, list.size());
        return page2;
    }

    @Override
    public StaffDto findById(Long id) {
      return staffRepo.findByIdAndDeletedIsFalse(id).map(StaffDto::new).orElseThrow(() -> new ResourceNotFoundException("Invalid staff id : " + id));
    }

    @Override
    public StaffDto update(Long id, StaffDto staffDto) {
        Staff staff = staffRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid staff id : " + id));
        staff.setId(id);
        staff.update(staffDto);
        staffRepo.save(staff);
        return new StaffDto(staff);
    }

    @Override
    public long count(Search search) {
        StringBuilder hql = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        hql.append("select count(*)" );
        hql.append("from Staff s ");
        hql.append("where 1=1 ");
        hql.append("and deleted = 0 ");
        if (search.getCode() != null) {
            hql.append("and s.code like :code ");
            params.put("code", "%" + search.getCode() + "%");
        }
        if (search.getName() != null) {
            hql.append("and s.name like :name");
            params.put("name", "%" + search.getName() + "%");
        }
        Query query = entityManager.createQuery(hql.toString());
        for (String key : params.keySet()) {
            query.setParameter(key, params.get(key));
        }
        return (query.getSingleResult().hashCode());
    }
}
