package com.gfg.demo.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Builder
public class ItemAllocation {
    private int itemAllocationId;
    private int userId;
    private int itemId;
    private Date allocationDate;
    private Date expectedReturnedDate;
    private Date returnedOn;
    private int dueByDays;
    private int librarianId;
    private String dueStatus;

}
