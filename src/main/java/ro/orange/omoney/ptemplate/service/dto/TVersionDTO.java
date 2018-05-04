package ro.orange.omoney.ptemplate.service.dto;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the TVersion entity.
 */
public class TVersionDTO implements Serializable {

    private Long id;

    private Long version;

    private String createdBy;

    private String createdDate;

    private Long templateId;

    private Long uiId;

    private Long backendId;

    private Long parentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Long getUiId() {
        return uiId;
    }

    public void setUiId(Long tUiId) {
        this.uiId = tUiId;
    }

    public Long getBackendId() {
        return backendId;
    }

    public void setBackendId(Long tBackendId) {
        this.backendId = tBackendId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long tVersionId) {
        this.parentId = tVersionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TVersionDTO tVersionDTO = (TVersionDTO) o;
        if(tVersionDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tVersionDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TVersionDTO{" +
            "id=" + getId() +
            ", version=" + getVersion() +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            "}";
    }
}
