package com.parth.projects.airBnbApp.repository;

import com.parth.projects.airBnbApp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
