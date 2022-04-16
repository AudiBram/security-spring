package com.practice.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.practice.security.AppUserPermission.*;

public enum AppUserRole {

    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(STUDENT_WRITE, STUDENT_READ, COURSE_WRITE, COURSE_READ));

    private final Set<AppUserPermission> permissions;

    AppUserRole(Set<AppUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<AppUserPermission> getPermissions() {
        return permissions;
    }
}
