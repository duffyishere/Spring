package org.duffy.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class BoardVO {
    private Long bno;
    private String title, writer, context;
    private Date regDate, updateDate;

}
