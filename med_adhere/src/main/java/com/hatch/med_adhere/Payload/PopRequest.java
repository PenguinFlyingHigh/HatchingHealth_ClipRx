package com.hatch.med_adhere.Payload;

public class PopRequest
{
    private String timeReceived;

    private Integer row;

    private Integer column;

    public PopRequest(String timeReceived, Integer row, Integer column) {
        this.timeReceived = timeReceived;
        this.row = row;
        this.column = column;
    }

    public PopRequest() {

    }

    public String getTimeReceived() {
        return timeReceived;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getColumn() {
        return column;
    }
}
