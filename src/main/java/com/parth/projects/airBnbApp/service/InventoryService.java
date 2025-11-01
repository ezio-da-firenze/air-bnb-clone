package com.parth.projects.airBnbApp.service;

import com.parth.projects.airBnbApp.dto.*;
import com.parth.projects.airBnbApp.dto.HotelPriceResponseDto;
import com.parth.projects.airBnbApp.dto.HotelSearchRequest;
import com.parth.projects.airBnbApp.dto.InventoryDto;
import com.parth.projects.airBnbApp.dto.UpdateInventoryRequestDto;
import com.parth.projects.airBnbApp.entity.Room;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelPriceResponseDto> searchHotels(HotelSearchRequest hotelSearchRequest);

    List<InventoryDto> getAllInventoryByRoom(Long roomId);

    void updateInventory(Long roomId, UpdateInventoryRequestDto updateInventoryRequestDto);
}
