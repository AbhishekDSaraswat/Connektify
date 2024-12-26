package com.sitrc.connektify.connections_service.repository;

import com.sitrc.connektify.connections_service.entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends Neo4jRepository<Person,Long> {


    Optional<Person> getByName(String name);
//    @Query("MATCH (personA:Person) -[:CONNECTED_TO]- (personB:Person) " +
//            "WHERE personA.userId = $userId " +
//            "RETURN personB")
@Query("MATCH (p:Person)-[:CONNECTED_TO]-(connected) WHERE id(p) = $id RETURN connected")
    List<Person> getFirstDegreeConnections(Long id);

@Query("Match (p1:Person)-[r:REQUESTED_TO]->(p2:Person) Where id(p1) = $senderId And id(p2) = $receiverId Return count(r) > 0")
   boolean connectionRequestExists(Long senderId,Long receiverId);


@Query("Match (p1:Person)-[r:CONNECTED_TO]->(p2:Person) Where id(p1) = $senderId And id(p2) = $receiverId Return count(r) > 0")
  boolean alreadyConnected(Long senderId,Long receiverId);

@Query("Match (p1:Person),(p2:Person) Where id(p1) = $senderId And id(p2) = $receiverId Create (p1)-[r:REQUESTED_TO]->(p2)")
  void addConnectionRequests(Long senderId, Long receiverId);

@Query("Match (p1:Person)-[r:REQUESTED_TO]->(p2:Person) Where id(p1) = $senderId And id(p2) = $receiverId Delete r Create (p1)-[:CONNECTED_TO]->(p2)")
  void acceptConnectionRequest(Long senderId,Long receiverId);


@Query("Match (p1:Person)-[r:REQUESTED_TO]->(p2:Person) Where id(p1) = $senderId And id(p2) = $receiverId Delete r")
 void rejectConnectionRequest(Long senderId, Long receiverId);


}
