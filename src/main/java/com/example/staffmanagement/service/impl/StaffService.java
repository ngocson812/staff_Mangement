package com.example.staffmanagement.service.impl;

import com.example.staffmanagement.dto.Search;
import com.example.staffmanagement.dto.StaffDto;
import com.example.staffmanagement.model.Staff;
import com.example.staffmanagement.repository.IStaffRepo;
import com.example.staffmanagement.service.IStaffService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
@AllArgsConstructor
public class StaffService implements IStaffService {

   private IStaffRepo staffRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Staff save(StaffDto staff) {
        Staff s = Staff.build(0L, staff.getCode(), staff.getName(), staff.getDateOfBirth(),staff.getGender(),staff.getHomeTown(),staff.getDateStartWork(),staff.isDeleted());
        return staffRepo.save(s);
    }

    @Override
    public void deleteById(Long id) {
        staffRepo.deleteById(id);
    }

    @Override
    public Optional<Object> findById(Long id) {
        return staffRepo.findById(id);
    }

    @Override
    public Page<StaffDto> search(Search search, Pageable pageable) {
        StringBuilder builder = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
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
        Query query = entityManager.createQuery(builder.toString());
        for (String key : params.keySet()) {
            query.setParameter(key, params.get(key));
        }
        List<StaffDto> list = query.getResultList();
        Page<StaffDto> page = new PageImpl<StaffDto>(list, pageable, list.size());
        return page;
    }
}
