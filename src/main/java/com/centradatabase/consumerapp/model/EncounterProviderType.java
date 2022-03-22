//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.06 at 02:19:42 AM WAT 
//


package com.centradatabase.consumerapp.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;

//import javax.xml.datatype.Date;


/**
 * <p>Java class for EncounterProviderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EncounterProviderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="encounter_provider_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="encounter_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="provider_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="location_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="encounter_role_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creator" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="date_created" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="changed_by" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="date_changed" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="voided" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="date_voided" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="voided_by" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="voided_reason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="encounter_provider_uuid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datim_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="patient_uuid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="encounter_uuid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="visit_uuid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EncounterProviderType", propOrder = {
    "encounterProviderId",
    "encounterId",
    "providerId",
    "locationId",
    "encounterRoleId",
    "creator",
    "dateCreated",
    "changedBy",
    "dateChanged",
    "voided",
    "dateVoided",
    "voidedBy",
    "voidedReason",
    "encounterProviderUuid",
    "datimId",
    "patientUuid",
    "encounterUuid",
    "visitUuid"
})
public class EncounterProviderType implements Serializable {

    @XmlElement(name = "encounter_provider_id")
    protected int encounterProviderId;
    @XmlElement(name = "encounter_id")
    protected int encounterId;
    @XmlElement(name = "provider_id")
    protected int providerId;
    @XmlElement(name = "location_id")
    protected int locationId;
    @XmlElement(name = "encounter_role_id")
    protected int encounterRoleId;
    protected int creator;
    @XmlElement(name = "date_created", required = true)
    @XmlSchemaType(name = "dateTime")
    protected Date dateCreated;
    @XmlElement(name = "changed_by")
    protected int changedBy;
    @XmlElement(name = "date_changed", required = true)
    @XmlSchemaType(name = "dateTime")
    protected Date dateChanged;
    protected int voided;
    @XmlElement(name = "date_voided", required = true)
    @XmlSchemaType(name = "dateTime")
    protected Date dateVoided;
    @XmlElement(name = "voided_by")
    protected int voidedBy;
    @XmlElement(name = "voided_reason", required = true)
    protected String voidedReason;
    @XmlElement(name = "encounter_provider_uuid", required = true)
    protected String encounterProviderUuid;
    @XmlElement(name = "datim_id", required = true)
    protected String datimId;
    @XmlElement(name = "patient_uuid", required = true)
    protected String patientUuid;
    @XmlElement(name = "encounter_uuid", required = true)
    protected String encounterUuid;
    @XmlElement(name = "visit_uuid", required = true)
    protected String visitUuid;

    /**
     * Gets the value of the encounterProviderId property.
     * 
     */
    public int getEncounterProviderId() {
        return encounterProviderId;
    }

    /**
     * Sets the value of the encounterProviderId property.
     * 
     */
    public void setEncounterProviderId(int value) {
        this.encounterProviderId = value;
    }

    /**
     * Gets the value of the encounterId property.
     * 
     */
    public int getEncounterId() {
        return encounterId;
    }

    /**
     * Sets the value of the encounterId property.
     * 
     */
    public void setEncounterId(int value) {
        this.encounterId = value;
    }

    /**
     * Gets the value of the providerId property.
     * 
     */
    public int getProviderId() {
        return providerId;
    }

    /**
     * Sets the value of the providerId property.
     * 
     */
    public void setProviderId(int value) {
        this.providerId = value;
    }

    /**
     * Gets the value of the locationId property.
     * 
     */
    public int getLocationId() {
        return locationId;
    }

    /**
     * Sets the value of the locationId property.
     * 
     */
    public void setLocationId(int value) {
        this.locationId = value;
    }

    /**
     * Gets the value of the encounterRoleId property.
     * 
     */
    public int getEncounterRoleId() {
        return encounterRoleId;
    }

    /**
     * Sets the value of the encounterRoleId property.
     * 
     */
    public void setEncounterRoleId(int value) {
        this.encounterRoleId = value;
    }

    /**
     * Gets the value of the creator property.
     * 
     */
    public int getCreator() {
        return creator;
    }

    /**
     * Sets the value of the creator property.
     * 
     */
    public void setCreator(int value) {
        this.creator = value;
    }

    /**
     * Gets the value of the dateCreated property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Sets the value of the dateCreated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setDateCreated(Date value) {
        this.dateCreated = value;
    }

    /**
     * Gets the value of the changedBy property.
     * 
     */
    public int getChangedBy() {
        return changedBy;
    }

    /**
     * Sets the value of the changedBy property.
     * 
     */
    public void setChangedBy(int value) {
        this.changedBy = value;
    }

    /**
     * Gets the value of the dateChanged property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getDateChanged() {
        return dateChanged;
    }

    /**
     * Sets the value of the dateChanged property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setDateChanged(Date value) {
        this.dateChanged = value;
    }

    /**
     * Gets the value of the voided property.
     * 
     */
    public int getVoided() {
        return voided;
    }

    /**
     * Sets the value of the voided property.
     * 
     */
    public void setVoided(int value) {
        this.voided = value;
    }

    /**
     * Gets the value of the dateVoided property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getDateVoided() {
        return dateVoided;
    }

    /**
     * Sets the value of the dateVoided property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setDateVoided(Date value) {
        this.dateVoided = value;
    }

    /**
     * Gets the value of the voidedBy property.
     * 
     */
    public int getVoidedBy() {
        return voidedBy;
    }

    /**
     * Sets the value of the voidedBy property.
     * 
     */
    public void setVoidedBy(int value) {
        this.voidedBy = value;
    }

    /**
     * Gets the value of the voidedReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoidedReason() {
        return voidedReason;
    }

    /**
     * Sets the value of the voidedReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoidedReason(String value) {
        this.voidedReason = value;
    }

    /**
     * Gets the value of the encounterProviderUuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncounterProviderUuid() {
        return encounterProviderUuid;
    }

    /**
     * Sets the value of the encounterProviderUuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncounterProviderUuid(String value) {
        this.encounterProviderUuid = value;
    }

    /**
     * Gets the value of the datimId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatimId() {
        return datimId;
    }

    /**
     * Sets the value of the datimId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatimId(String value) {
        this.datimId = value;
    }

    /**
     * Gets the value of the patientUuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatientUuid() {
        return patientUuid;
    }

    /**
     * Sets the value of the patientUuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatientUuid(String value) {
        this.patientUuid = value;
    }

    /**
     * Gets the value of the encounterUuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncounterUuid() {
        return encounterUuid;
    }

    /**
     * Sets the value of the encounterUuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncounterUuid(String value) {
        this.encounterUuid = value;
    }

    /**
     * Gets the value of the visitUuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVisitUuid() {
        return visitUuid;
    }

    /**
     * Sets the value of the visitUuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVisitUuid(String value) {
        this.visitUuid = value;
    }

}
