package com.example.digital.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.digital.entity.Role;
@Repository
public interface RoleRepository{
	List<Role> findAllRoles();
	//Set<Role> findRoleByName(String rolename);
	/*void deleteRole(int roleid);
    boolean roleExists(String role_name, String role_desc);*/
	//Role findByRoleName(String rolename);
	//Set<Role> findByRole(String string);
	Set<Role> findRoleById(int roleid);
	List<String> findByRolename(long userId);
}
