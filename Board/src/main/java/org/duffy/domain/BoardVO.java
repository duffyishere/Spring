package org.duffy.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.util.Date;

@ToString
@Data
public class BoardVO {

    private Long bno;
    private String title, writer, context;
    private Date regDate, updateDate;
}
