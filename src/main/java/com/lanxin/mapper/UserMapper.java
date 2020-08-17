package com.lanxin.mapper;

import java.util.Set;

public interface UserMapper {
    String doGetPasswordByUsername(String username);
    Set<String> doGetRoleByUsername(String username);
    Set<String> doGetPermissionsByUsername(String username);
}
