package com.cts.osp.kt.fsd.fsdservice.auth.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
