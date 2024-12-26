package com.sitrc.connektify.connections_service.service;

import com.sitrc.connektify.connections_service.entity.Person;

import java.util.List;

public interface ConnectionsService {

    public List<Person> getFirstDegreeConnections();

    Boolean sendConnectionRequest(Long userId);

    Boolean acceptConnectionRequest(Long userId);

    Boolean rejectConnectionRequest(Long userId);
}
