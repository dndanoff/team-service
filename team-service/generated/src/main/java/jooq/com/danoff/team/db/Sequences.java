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
     * The sequence <code>PUBLIC.SYSTEM_SEQUENCE_BEF8557A_BB54_466D_8597_C4F0199D491D</code>
     */
    public static final Sequence<Long> SYSTEM_SEQUENCE_BEF8557A_BB54_466D_8597_C4F0199D491D = new SequenceImpl<Long>("SYSTEM_SEQUENCE_BEF8557A_BB54_466D_8597_C4F0199D491D", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT);
}
