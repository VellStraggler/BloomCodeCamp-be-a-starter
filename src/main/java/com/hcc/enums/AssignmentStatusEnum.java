package com.hcc.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT) // I have no clue what this does
public enum AssignmentStatusEnum {
    IN_REVIEW, SUBMITTED, REJECTED, COMPLETED;
}
