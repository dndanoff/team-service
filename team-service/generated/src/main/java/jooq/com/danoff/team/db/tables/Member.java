/*
 * This file is generated by jOOQ.
*/
package com.danoff.team.db.tables;


import com.danoff.team.db.Keys;
import com.danoff.team.db.Public;
import com.danoff.team.db.tables.records.MemberRecord;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


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
public class Member extends TableImpl<MemberRecord> {

    private static final long serialVersionUID = 724002514;

    /**
     * The reference instance of <code>PUBLIC.MEMBER</code>
     */
    public static final Member MEMBER = new Member();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MemberRecord> getRecordType() {
        return MemberRecord.class;
    }

    /**
     * The column <code>PUBLIC.MEMBER.ID</code>.
     */
    public final TableField<MemberRecord, Long> ID = createField("ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>PUBLIC.MEMBER.FIRST_NAME</code>.
     */
    public final TableField<MemberRecord, String> FIRST_NAME = createField("FIRST_NAME", org.jooq.impl.SQLDataType.VARCHAR.length(100).nullable(false), this, "");

    /**
     * The column <code>PUBLIC.MEMBER.LAST_NAME</code>.
     */
    public final TableField<MemberRecord, String> LAST_NAME = createField("LAST_NAME", org.jooq.impl.SQLDataType.VARCHAR.length(100).nullable(false), this, "");

    /**
     * The column <code>PUBLIC.MEMBER.PHOTO_URL</code>.
     */
    public final TableField<MemberRecord, String> PHOTO_URL = createField("PHOTO_URL", org.jooq.impl.SQLDataType.VARCHAR.length(1000), this, "");

    /**
     * The column <code>PUBLIC.MEMBER.TITLE_ID</code>.
     */
    public final TableField<MemberRecord, Long> TITLE_ID = createField("TITLE_ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>PUBLIC.MEMBER.HIRE_DATE</code>.
     */
    public final TableField<MemberRecord, LocalDate> HIRE_DATE = createField("HIRE_DATE", org.jooq.impl.SQLDataType.LOCALDATE.nullable(false), this, "");

    /**
     * Create a <code>PUBLIC.MEMBER</code> table reference
     */
    public Member() {
        this("MEMBER", null);
    }

    /**
     * Create an aliased <code>PUBLIC.MEMBER</code> table reference
     */
    public Member(String alias) {
        this(alias, MEMBER);
    }

    private Member(String alias, Table<MemberRecord> aliased) {
        this(alias, aliased, null);
    }

    private Member(String alias, Table<MemberRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<MemberRecord, Long> getIdentity() {
        return Keys.IDENTITY_MEMBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<MemberRecord> getPrimaryKey() {
        return Keys.MEMBER_PK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<MemberRecord>> getKeys() {
        return Arrays.<UniqueKey<MemberRecord>>asList(Keys.MEMBER_PK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<MemberRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<MemberRecord, ?>>asList(Keys.FK_TITLE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Member as(String alias) {
        return new Member(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Member rename(String name) {
        return new Member(name, null);
    }
}
