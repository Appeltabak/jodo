package com.appeltabak.jodo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoResource, Long> {

}
