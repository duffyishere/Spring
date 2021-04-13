package org.duffy.controller;

import org.duffy.domain.SampleVO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/sample")
public class SampleController {

	@RequestMapping(value="/getSample", method=RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE})
	public SampleVO getData() {
		
		return new SampleVO(112, "Star", "Road");
	}
}
