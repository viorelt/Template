package ro.orange.omoney.ptemplate.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * Entitatea reprezinta un sablon static pe baza caruia se vor genera sabloane
 * in platile mele
 */
@ApiModel(description = "Entitatea reprezinta un sablon static pe baza caruia se vor genera sabloane in platile mele")
@Entity
@Table(name = "template")
public class Template implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    /**
     * The code that uniquely identifies a template
     */
    @ApiModelProperty(value = "The code that uniquely identifies a template")
    @Column(name = "code")
    private String code;

    /**
     * Who created the version
     */
    @ApiModelProperty(value = "Who created the version")
    @Column(name = "created_by")
    private String createdBy;

    /**
     * When the version was created
     */
    @ApiModelProperty(value = "When the version was created")
    @Column(name = "created_date")
    private Instant createdDate;

    /**
     * Flag to indicate if a particular template has been deleted
     */
    @ApiModelProperty(value = "Flag to indicate if a particular template has been deleted")
    @Column(name = "deleted")
    private Boolean deleted;

    @OneToOne
    @JoinColumn(unique = true)
    private TVersion lastVersion;

    @OneToMany(mappedBy = "template")
    @JsonIgnore
    private Set<TVersion> versions = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public Template code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Template createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public Template createdDate(Instant createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Boolean isDeleted() {
        return deleted;
    }

    public Template deleted(Boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public TVersion getLastVersion() {
        return lastVersion;
    }

    public Template lastVersion(TVersion tVersion) {
        this.lastVersion = tVersion;
        return this;
    }

    public void setLastVersion(TVersion tVersion) {
        this.lastVersion = tVersion;
    }

    public Set<TVersion> getVersions() {
        return versions;
    }

    public Template versions(Set<TVersion> tVersions) {
        this.versions = tVersions;
        return this;
    }

    public Template addVersions(TVersion tVersion) {
        this.versions.add(tVersion);
        tVersion.setTemplate(this);
        return this;
    }

    public Template removeVersions(TVersion tVersion) {
        this.versions.remove(tVersion);
        tVersion.setTemplate(null);
        return this;
    }

    public void setVersions(Set<TVersion> tVersions) {
        this.versions = tVersions;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Template template = (Template) o;
        if (template.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), template.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Template{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            ", deleted='" + isDeleted() + "'" +
            "}";
    }
}
