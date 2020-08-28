package com.DnD.HappyFool.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DnD.HappyFool.Domain.Entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
