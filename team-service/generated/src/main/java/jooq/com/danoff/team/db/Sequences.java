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
     * The sequence <code>PUBLIC.SYSTEM_SEQUENCE_4F79E254_AE34_4BC9_BB45_89EBC6F638F1</code>
     */
    public static final Sequence<Long> SYSTEM_SEQUENCE_4F79E254_AE34_4BC9_BB45_89EBC6F638F1 = new SequenceImpl<Long>("SYSTEM_SEQUENCE_4F79E254_AE34_4BC9_BB45_89EBC6F638F1", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT);

    /**
     * The sequence <code>PUBLIC.SYSTEM_SEQUENCE_65BBADC3_53C2_40A1_BD2D_4DC18008BDF4</code>
     */
    public static final Sequence<Long> SYSTEM_SEQUENCE_65BBADC3_53C2_40A1_BD2D_4DC18008BDF4 = new SequenceImpl<Long>("SYSTEM_SEQUENCE_65BBADC3_53C2_40A1_BD2D_4DC18008BDF4", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT);
}
