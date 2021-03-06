package com.sensocon.server.service.impl;

import com.sensocon.server.service.NotificationGroupService;
import com.sensocon.server.domain.NotificationGroup;
import com.sensocon.server.repository.NotificationGroupRepository;
import com.sensocon.server.service.dto.NotificationGroupDTO;
import com.sensocon.server.service.mapper.NotificationGroupMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
/**
 * Service Implementation for managing NotificationGroup.
 */
@Service
@Transactional
public class NotificationGroupServiceImpl implements NotificationGroupService {

    private final Logger log = LoggerFactory.getLogger(NotificationGroupServiceImpl.class);

    private final NotificationGroupRepository notificationGroupRepository;

    private final NotificationGroupMapper notificationGroupMapper;

    public NotificationGroupServiceImpl(NotificationGroupRepository notificationGroupRepository, NotificationGroupMapper notificationGroupMapper) {
        this.notificationGroupRepository = notificationGroupRepository;
        this.notificationGroupMapper = notificationGroupMapper;
    }

    /**
     * Save a notificationGroup.
     *
     * @param notificationGroupDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public NotificationGroupDTO save(NotificationGroupDTO notificationGroupDTO) {
        log.debug("Request to save NotificationGroup : {}", notificationGroupDTO);
        NotificationGroup notificationGroup = notificationGroupMapper.toEntity(notificationGroupDTO);
        notificationGroup = notificationGroupRepository.save(notificationGroup);
        return notificationGroupMapper.toDto(notificationGroup);
    }

    /**
     * Get all the notificationGroups.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<NotificationGroupDTO> findAll() {
        log.debug("Request to get all NotificationGroups");
        return notificationGroupRepository.findAll().stream()
            .map(notificationGroupMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }



    /**
     *  get all the notificationGroups where SensorDevice is null.
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public List<NotificationGroupDTO> findAllWhereSensorDeviceIsNull() {
        log.debug("Request to get all notificationGroups where SensorDevice is null");
        return StreamSupport
            .stream(notificationGroupRepository.findAll().spliterator(), false)
            .filter(notificationGroup -> notificationGroup.getSensorDevice() == null)
            .map(notificationGroupMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one notificationGroup by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<NotificationGroupDTO> findOne(Long id) {
        log.debug("Request to get NotificationGroup : {}", id);
        return notificationGroupRepository.findById(id)
            .map(notificationGroupMapper::toDto);
    }

    /**
     * Delete the notificationGroup by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete NotificationGroup : {}", id);
        notificationGroupRepository.deleteById(id);
    }
}
