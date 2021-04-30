package org.duffy.service;

import org.duffy.mapper.Sample1Mapper;
import org.duffy.mapper.Sample2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class SampleTxServiceImpl implements SampleTxService{

	@Setter(onMethod_ = @Autowired)
	private Sample1Mapper sample1Mapper;
	
	@Setter(onMethod_ = @Autowired)
	private Sample2Mapper sample2Mapper;
	
	@Transactional
	@Override
	public void addData(String data) {
		log.info("Insert Sample1.....");
		sample1Mapper.insertCol1(data);
		
		log.info("Insert Sample2.....");
		sample2Mapper.insertCol2(data);
		
		log.info("end......");
		
	}

}
