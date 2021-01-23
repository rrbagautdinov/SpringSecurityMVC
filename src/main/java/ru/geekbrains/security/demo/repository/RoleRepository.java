package ru.geekbrains.security.demo.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.security.demo.entity.Role;

@Repository
@Profile("dao")
public interface RoleRepository extends CrudRepository<Role, Integer> {
}
