package com.FalaPraEle.domain.repository;

import com.FalaPraEle.domain.entity.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatRepository extends MongoRepository<Chat, String> {

}
