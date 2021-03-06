/*
 * This file is generated by jOOQ.
*/
package com.danoff.team.db;


import com.danoff.team.db.tables.ContactType;
import com.danoff.team.db.tables.Databasechangelog;
import com.danoff.team.db.tables.Databasechangeloglock;
import com.danoff.team.db.tables.Member;
import com.danoff.team.db.tables.MemberContact;
import com.danoff.team.db.tables.Title;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in PUBLIC
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>PUBLIC.CONTACT_TYPE</code>.
     */
    public static final ContactType CONTACT_TYPE = com.danoff.team.db.tables.ContactType.CONTACT_TYPE;

    /**
     * The table <code>PUBLIC.DATABASECHANGELOG</code>.
     */
    public static final Databasechangelog DATABASECHANGELOG = com.danoff.team.db.tables.Databasechangelog.DATABASECHANGELOG;

    /**
     * The table <code>PUBLIC.DATABASECHANGELOGLOCK</code>.
     */
    public static final Databasechangeloglock DATABASECHANGELOGLOCK = com.danoff.team.db.tables.Databasechangeloglock.DATABASECHANGELOGLOCK;

    /**
     * The table <code>PUBLIC.MEMBER</code>.
     */
    public static final Member MEMBER = com.danoff.team.db.tables.Member.MEMBER;

    /**
     * The table <code>PUBLIC.MEMBER_CONTACT</code>.
     */
    public static final MemberContact MEMBER_CONTACT = com.danoff.team.db.tables.MemberContact.MEMBER_CONTACT;

    /**
     * The table <code>PUBLIC.TITLE</code>.
     */
    public static final Title TITLE = com.danoff.team.db.tables.Title.TITLE;
}
