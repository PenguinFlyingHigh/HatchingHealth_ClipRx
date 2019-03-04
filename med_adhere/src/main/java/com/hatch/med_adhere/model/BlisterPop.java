package com.hatch.med_adhere.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "blisterpack")
public class BlisterPop
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blisterpackId;

    @Column(name = "timeReceived")
    private String timeReceived;

    @Column(name = "packRow")
    private Integer packRow;

    @Column(name = "packColumn")
    private Integer packColumn;

    public BlisterPop() {

    }

    public BlisterPop (String timeReceived, Integer packRow, Integer packColumn) {
        this.timeReceived = timeReceived;
        this.packRow = packRow;
        this.packColumn = packColumn;
    }

    public Integer getBlisterpackIdId() {
        return blisterpackId;
    }

    public String gettimeReceived() {
        return timeReceived;
    }

    public Integer getpackRow() {
        return packRow;
    }

    public Integer getpackColumn() {
        return packColumn;
    }
}
