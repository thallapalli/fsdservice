package com.cts.osp.kt.fsd.fsdservice.auth.service;

import com.cts.osp.kt.fsd.fsdservice.entity.FsdUser;

public interface UserService {
    void save(FsdUser user);

    FsdUser findByUsername(String username);
}
