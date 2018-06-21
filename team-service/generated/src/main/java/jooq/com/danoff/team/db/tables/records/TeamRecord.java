/*
 * This file is generated by jOOQ.
*/
package com.danoff.team.db.tables.records;


import com.danoff.team.db.tables.Team;

import java.time.LocalDate;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TeamRecord extends UpdatableRecordImpl<TeamRecord> implements Record4<Long, String, String, LocalDate> {

    private static final long serialVersionUID = 430320652;

    /**
     * Setter for <code>PUBLIC.TEAM.ID</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>PUBLIC.TEAM.ID</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>PUBLIC.TEAM.NAME</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>PUBLIC.TEAM.NAME</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>PUBLIC.TEAM.PROJECT_NAME</code>.
     */
    public void setProjectName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>PUBLIC.TEAM.PROJECT_NAME</code>.
     */
    public String getProjectName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>PUBLIC.TEAM.ESTABLISHED_DATE</code>.
     */
    public void setEstablishedDate(LocalDate value) {
        set(3, value);
    }

    /**
     * Getter for <code>PUBLIC.TEAM.ESTABLISHED_DATE</code>.
     */
    public LocalDate getEstablishedDate() {
        return (LocalDate) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Long, String, String, LocalDate> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Long, String, String, LocalDate> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Team.TEAM.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Team.TEAM.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Team.TEAM.PROJECT_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDate> field4() {
        return Team.TEAM.ESTABLISHED_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getProjectName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDate value4() {
        return getEstablishedDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TeamRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TeamRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TeamRecord value3(String value) {
        setProjectName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TeamRecord value4(LocalDate value) {
        setEstablishedDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TeamRecord values(Long value1, String value2, String value3, LocalDate value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TeamRecord
     */
    public TeamRecord() {
        super(Team.TEAM);
    }

    /**
     * Create a detached, initialised TeamRecord
     */
    public TeamRecord(Long id, String name, String projectName, LocalDate establishedDate) {
        super(Team.TEAM);

        set(0, id);
        set(1, name);
        set(2, projectName);
        set(3, establishedDate);
    }
}
