/*
 * This file is generated by jOOQ.
*/
package com.danoff.team.db;


import javax.annotation.Generated;

import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;


/**
 * Convenience access to all sequences in PUBLIC
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>PUBLIC.SYSTEM_SEQUENCE_25F642A2_85D7_4014_B796_1BDCFD3C4E70</code>
     */
    public static final Sequence<Long> SYSTEM_SEQUENCE_25F642A2_85D7_4014_B796_1BDCFD3C4E70 = new SequenceImpl<Long>("SYSTEM_SEQUENCE_25F642A2_85D7_4014_B796_1BDCFD3C4E70", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT);

    /**
     * The sequence <code>PUBLIC.SYSTEM_SEQUENCE_A16E933F_3E3A_4091_82D6_D7B2260AFB3B</code>
     */
    public static final Sequence<Long> SYSTEM_SEQUENCE_A16E933F_3E3A_4091_82D6_D7B2260AFB3B = new SequenceImpl<Long>("SYSTEM_SEQUENCE_A16E933F_3E3A_4091_82D6_D7B2260AFB3B", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT);
}
