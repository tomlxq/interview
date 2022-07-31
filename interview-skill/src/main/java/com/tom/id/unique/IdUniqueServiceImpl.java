package com.tom.id.unique;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("uuidService")
public class IdUniqueServiceImpl implements IdUniqueService {
    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
