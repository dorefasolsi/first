package com.mira.first.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {

	private int bno;
	private String btitle;
	private String bcontent;
	private Date bdate;
	private String mid;


}
