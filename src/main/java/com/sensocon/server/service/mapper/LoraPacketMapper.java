package com.sensocon.server.service.mapper;

import com.sensocon.server.domain.*;
import com.sensocon.server.service.dto.LoraPacketDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity LoraPacket and its DTO LoraPacketDTO.
 */
@Mapper(componentModel = "spring", uses = {SensorDeviceMapper.class})
public interface LoraPacketMapper extends EntityMapper<LoraPacketDTO, LoraPacket> {

    @Mapping(source = "device.id", target = "deviceId")
    @Mapping(source = "device.deviceId", target = "deviceDeviceId")
    LoraPacketDTO toDto(LoraPacket loraPacket);

    @Mapping(source = "deviceId", target = "device")
    LoraPacket toEntity(LoraPacketDTO loraPacketDTO);

    default LoraPacket fromId(Long id) {
        if (id == null) {
            return null;
        }
        LoraPacket loraPacket = new LoraPacket();
        loraPacket.setId(id);
        return loraPacket;
    }
}
