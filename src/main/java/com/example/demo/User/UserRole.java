package com.example.demo.User;

import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.demo.User.UserPermission.*;

@Getter
@RequiredArgsConstructor
public enum UserRole {

    PATIENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ,COURSE_WRITE,PATIENT_READ,PATIENT_WRITE)), //should read n write
    ADMIN_TRAINEE(Sets.newHashSet(COURSE_READ,PATIENT_READ)); //should only read

    private final Set<UserPermission> permission;

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
       Set<SimpleGrantedAuthority> permissions= getPermission().stream()
                .map(permission-> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

       permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));

       return permissions;
    }
}
