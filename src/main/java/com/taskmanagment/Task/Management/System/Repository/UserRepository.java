package com.taskmanagment.Task.Management.System.Repository;

import com.taskmanagment.Task.Management.System.Model.User;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
