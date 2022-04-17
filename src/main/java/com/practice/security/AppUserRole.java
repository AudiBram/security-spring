package com.practice.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.practice.security.AppUserPermission.*;

public enum AppUserRole {

    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(STUDENT_WRITE, STUDENT_READ, COURSE_WRITE, COURSE_READ)),
    ADMINTRAINEE(Sets.newHashSet(STUDENT_READ, COURSE_READ));

    private final Set<AppUserPermission> permissions;

    AppUserRole(Set<AppUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<AppUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthor() {
        Set<SimpleGrantedAuthority> permission = getPermissions().stream()
                .map(permissions -> new SimpleGrantedAuthority(permissions.getPermission()))
                .collect(Collectors.toSet());
        permission.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permission;
    }
}
