package com.sensocon.server.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the NotificationGroup entity.
 */
public class NotificationGroupDTO implements Serializable {

    private Long id;

    private String name;

    private Long contactId;

    private String contactEmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        NotificationGroupDTO notificationGroupDTO = (NotificationGroupDTO) o;
        if (notificationGroupDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), notificationGroupDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "NotificationGroupDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", contact=" + getContactId() +
            ", contact='" + getContactEmail() + "'" +
            "}";
    }
}
