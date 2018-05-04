package ro.orange.omoney.ptemplate.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import ro.orange.omoney.ptemplate.domain.enumeration.EUiType;

/**
 * The ElementUi entity
 */
@ApiModel(description = "The ElementUi entity")
@Entity
@Table(name = "e_ui")
public class EUi implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    /**
     * The element type.
     */
    @ApiModelProperty(value = "The element type.")
    @Enumerated(EnumType.STRING)
    @Column(name = "jhi_type")
    private EUiType type;

    /**
     * The position of the element inside the view.
     */
    @ApiModelProperty(value = "The position of the element inside the view.")
    @Column(name = "jhi_index")
    private Integer index;

    /**
     * The icon name assigned to the element.
     */
    @ApiModelProperty(value = "The icon name assigned to the element.")
    @Column(name = "icon")
    private String icon;

    /**
     * The element's label key required for internationalization.
     */
    @ApiModelProperty(value = "The element's label key required for internationalization.")
    @Column(name = "label_key")
    private String labelKey;

    /**
     * The element's description key required for internationalization.
     */
    @ApiModelProperty(value = "The element's description key required for internationalization.")
    @Column(name = "description_key")
    private String descriptionKey;

    /**
     * The element's hint key required for internationalization.
     */
    @ApiModelProperty(value = "The element's hint key required for internationalization.")
    @Column(name = "hint_key")
    private String hintKey;

    /**
     * True if the element is read-only.
     */
    @ApiModelProperty(value = "True if the element is read-only.")
    @Column(name = "read_only")
    private Boolean readOnly;

    /**
     * True if the element's completion is mandatory.
     */
    @ApiModelProperty(value = "True if the element's completion is mandatory.")
    @Column(name = "required")
    private Boolean required;

    /**
     * True if the element is visible.
     */
    @ApiModelProperty(value = "True if the element is visible.")
    @Column(name = "visible")
    private Boolean visible;

    /**
     * The required format for the element.
     */
    @ApiModelProperty(value = "The required format for the element.")
    @Column(name = "format")
    private String format;

    /**
     * The validator for the element.
     */
    @ApiModelProperty(value = "The validator for the element.")
    @Column(name = "validator")
    private String validator;

    @OneToMany(mappedBy = "eUi")
    @JsonIgnore
    private Set<ValueOption> options = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EUiType getType() {
        return type;
    }

    public EUi type(EUiType type) {
        this.type = type;
        return this;
    }

    public void setType(EUiType type) {
        this.type = type;
    }

    public Integer getIndex() {
        return index;
    }

    public EUi index(Integer index) {
        this.index = index;
        return this;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getIcon() {
        return icon;
    }

    public EUi icon(String icon) {
        this.icon = icon;
        return this;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLabelKey() {
        return labelKey;
    }

    public EUi labelKey(String labelKey) {
        this.labelKey = labelKey;
        return this;
    }

    public void setLabelKey(String labelKey) {
        this.labelKey = labelKey;
    }

    public String getDescriptionKey() {
        return descriptionKey;
    }

    public EUi descriptionKey(String descriptionKey) {
        this.descriptionKey = descriptionKey;
        return this;
    }

    public void setDescriptionKey(String descriptionKey) {
        this.descriptionKey = descriptionKey;
    }

    public String getHintKey() {
        return hintKey;
    }

    public EUi hintKey(String hintKey) {
        this.hintKey = hintKey;
        return this;
    }

    public void setHintKey(String hintKey) {
        this.hintKey = hintKey;
    }

    public Boolean isReadOnly() {
        return readOnly;
    }

    public EUi readOnly(Boolean readOnly) {
        this.readOnly = readOnly;
        return this;
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    public Boolean isRequired() {
        return required;
    }

    public EUi required(Boolean required) {
        this.required = required;
        return this;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Boolean isVisible() {
        return visible;
    }

    public EUi visible(Boolean visible) {
        this.visible = visible;
        return this;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getFormat() {
        return format;
    }

    public EUi format(String format) {
        this.format = format;
        return this;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getValidator() {
        return validator;
    }

    public EUi validator(String validator) {
        this.validator = validator;
        return this;
    }

    public void setValidator(String validator) {
        this.validator = validator;
    }

    public Set<ValueOption> getOptions() {
        return options;
    }

    public EUi options(Set<ValueOption> valueOptions) {
        this.options = valueOptions;
        return this;
    }

    public EUi addOptions(ValueOption valueOption) {
        this.options.add(valueOption);
        valueOption.setEUi(this);
        return this;
    }

    public EUi removeOptions(ValueOption valueOption) {
        this.options.remove(valueOption);
        valueOption.setEUi(null);
        return this;
    }

    public void setOptions(Set<ValueOption> valueOptions) {
        this.options = valueOptions;
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
        EUi eUi = (EUi) o;
        if (eUi.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), eUi.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EUi{" +
            "id=" + getId() +
            ", type='" + getType() + "'" +
            ", index=" + getIndex() +
            ", icon='" + getIcon() + "'" +
            ", labelKey='" + getLabelKey() + "'" +
            ", descriptionKey='" + getDescriptionKey() + "'" +
            ", hintKey='" + getHintKey() + "'" +
            ", readOnly='" + isReadOnly() + "'" +
            ", required='" + isRequired() + "'" +
            ", visible='" + isVisible() + "'" +
            ", format='" + getFormat() + "'" +
            ", validator='" + getValidator() + "'" +
            "}";
    }
}
