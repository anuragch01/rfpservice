package com.bettaway.rfp.service.impl;

import com.bettaway.rfp.modal.Group;
import com.bettaway.rfp.repository.GroupRepository;
import com.bettaway.rfp.response.ResponseBean;
import com.bettaway.rfp.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;


    @Override
    public Group save(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public ResponseEntity<ResponseBean> findAll() {
        List<Group> all = groupRepository.findAll();
        return ResponseEntity.ok(ResponseBean.success(all, "Group List"));
    }

    @Override
    public ResponseEntity<ResponseBean> findByAuthId(String authId) {
        List<Group> all = groupRepository.findByAuthId(authId);
        return ResponseEntity.ok(ResponseBean.success(all, "Group List"));
    }


}
