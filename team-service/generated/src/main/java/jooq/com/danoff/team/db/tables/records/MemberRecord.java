/*
 * This file is generated by jOOQ.
*/
package com.danoff.team.db.tables.records;


import com.danoff.team.db.tables.Member;

import java.time.LocalDate;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
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
public class MemberRecord extends UpdatableRecordImpl<MemberRecord> implements Record6<Long, String, String, String, Long, LocalDate> {

    private static final long serialVersionUID = 1709119620;

    /**
     * Setter for <code>PUBLIC.MEMBER.ID</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>PUBLIC.MEMBER.ID</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>PUBLIC.MEMBER.FIRST_NAME</code>.
     */
    public void setFirstName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>PUBLIC.MEMBER.FIRST_NAME</code>.
     */
    public String getFirstName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>PUBLIC.MEMBER.LAST_NAME</code>.
     */
    public void setLastName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>PUBLIC.MEMBER.LAST_NAME</code>.
     */
    public String getLastName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>PUBLIC.MEMBER.PHOTO_URL</code>.
     */
    public void setPhotoUrl(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>PUBLIC.MEMBER.PHOTO_URL</code>.
     */
    public String getPhotoUrl() {
        return (String) get(3);
    }

    /**
     * Setter for <code>PUBLIC.MEMBER.TITLE_ID</code>.
     */
    public void setTitleId(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>PUBLIC.MEMBER.TITLE_ID</code>.
     */
    public Long getTitleId() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>PUBLIC.MEMBER.HIRE_DATE</code>.
     */
    public void setHireDate(LocalDate value) {
        set(5, value);
    }

    /**
     * Getter for <code>PUBLIC.MEMBER.HIRE_DATE</code>.
     */
    public LocalDate getHireDate() {
        return (LocalDate) get(5);
    }

    /**
     * Setter for <code>PUBLIC.MEMBER.TEAM_ID</code>.
     */
    public void setTeamId(Long value) {
        set(6, value);
    }

    /**
     * Getter for <code>PUBLIC.MEMBER.TEAM_ID</code>.
     */
    public Long getTeamId() {
        return (Long) get(6);
    }

    /**
     * Setter for <code>PUBLIC.MEMBER.PHONE_NUMBER</code>.
     */
    public void setPhoneNumber(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>PUBLIC.MEMBER.PHONE_NUMBER</code>.
     */
    public String getPhoneNumber() {
        return (String) get(7);
    }

    /**
     * Setter for <code>PUBLIC.MEMBER.SKYPE</code>.
     */
    public void setSkype(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>PUBLIC.MEMBER.SKYPE</code>.
     */
    public String getSkype() {
        return (String) get(8);
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
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Long, String, String, String, Long, LocalDate> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Long, String, String, String, Long, LocalDate> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Member.MEMBER.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Member.MEMBER.FIRST_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Member.MEMBER.LAST_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Member.MEMBER.PHOTO_URL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field5() {
        return Member.MEMBER.TITLE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDate> field6() {
        return Member.MEMBER.HIRE_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field7() {
        return Member.MEMBER.TEAM_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Member.MEMBER.PHONE_NUMBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return Member.MEMBER.SKYPE;
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
        return getFirstName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getLastName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getPhotoUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value5() {
        return getTitleId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDate value6() {
        return getHireDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value7() {
        return getTeamId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getPhoneNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getSkype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MemberRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MemberRecord value2(String value) {
        setFirstName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MemberRecord value3(String value) {
        setLastName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MemberRecord value4(String value) {
        setPhotoUrl(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MemberRecord value5(Long value) {
        setTitleId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MemberRecord value6(LocalDate value) {
        setHireDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MemberRecord values(Long value1, String value2, String value3, String value4, Long value5, LocalDate value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MemberRecord
     */
    public MemberRecord() {
        super(Member.MEMBER);
    }

    /**
     * Create a detached, initialised MemberRecord
     */
    public MemberRecord(Long id, String firstName, String lastName, String photoUrl, Long titleId, LocalDate hireDate) {
        super(Member.MEMBER);

        set(0, id);
        set(1, firstName);
        set(2, lastName);
        set(3, photoUrl);
        set(4, titleId);
        set(5, hireDate);
        set(6, teamId);
        set(7, phoneNumber);
        set(8, skype);
    }
}
