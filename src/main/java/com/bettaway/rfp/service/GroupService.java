package com.bettaway.rfp.service;

import com.bettaway.rfp.modal.Group;
import com.bettaway.rfp.response.ResponseBean;
import org.springframework.http.ResponseEntity;

public interface GroupService {
    public Group save(Group group);

    public ResponseEntity<ResponseBean> findAll();

    public ResponseEntity<ResponseBean> findByAuthId(String authId);
}
