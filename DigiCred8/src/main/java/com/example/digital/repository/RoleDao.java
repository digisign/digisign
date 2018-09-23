package com.example.digital.repository;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.digital.entity.Role;



@Repository
public  class RoleDao  {

/*	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Set<Role> findRoleById(int roleid) {
		String hql = "FROM Role as atcl where atcl.roleid= ? ";
		return (Set<Role>) entityManager.createQuery(hql).setParameter(0, roleid).getSingleResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findAllRoles() {
		String hql = "FROM Role as rle ORDER BY rle.role_id DESC";
		return (List<Role>) entityManager.createQuery(hql).getResultList();
	}
	@Override
	public List<String> findByRolename(long userId) {
		// TODO Auto-generated method stub
		String hql = "Select r.role_name from user_role ur, role r where ur.role_id=r.role_id and ur.user_id" ;
		return    entityManager.createQuery(hql).getResultList();
	}	
	
	*//*@Override
	public void deleteRole(int roleid) {
		entityManager.remove(getRoleByid(roleid));
	}
	@Override
	public boolean roleExists(String role_name, String role_desc) {
		String hql = "FROM Role as rle WHERE rle.role_name = ? and rle.role_desc = ?";
		int count = entityManager.createQuery(hql).setParameter(1, role_name)
		              .setParameter(2, role_name).getResultList().size();
		return count > 0 ? true : false;
	}

*/

}
