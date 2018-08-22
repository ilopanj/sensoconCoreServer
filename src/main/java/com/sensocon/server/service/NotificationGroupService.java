package com.sensocon.server.service;

import com.sensocon.server.service.dto.NotificationGroupDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing NotificationGroup.
 */
public interface NotificationGroupService {

    /**
     * Save a notificationGroup.
     *
     * @param notificationGroupDTO the entity to save
     * @return the persisted entity
     */
    NotificationGroupDTO save(NotificationGroupDTO notificationGroupDTO);

    /**
     * Get all the notificationGroups.
     *
     * @return the list of entities
     */
    List<NotificationGroupDTO> findAll();
    /**
     * Get all the NotificationGroupDTO where SensorDevice is null.
     *
     * @return the list of entities
     */
    List<NotificationGroupDTO> findAllWhereSensorDeviceIsNull();


    /**
     * Get the "id" notificationGroup.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<NotificationGroupDTO> findOne(Long id);

    /**
     * Delete the "id" notificationGroup.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
