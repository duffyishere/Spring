package org.duffy.controller;

import org.duffy.domain.Criteria;
import org.duffy.domain.ReplyPageDTO;
import org.duffy.domain.ReplyVO;
import org.duffy.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping(value="/replies/")
public class ReplyController {

	@Setter(onMethod_ = {@Autowired})
	private ReplyService replyService;

	//consumes와 produces를 이용해 json방식의 데이터만 처리
	@PostMapping(value="/new", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO replyvo){
		
		log.info("ReplyVO :"+replyvo);
		
		int insertCount = replyService.register(replyvo);
		
		return insertCount == 1
				? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value="/pages/{bno}/{page}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ReplyPageDTO> getList(@PathVariable("bno") Long bno, @PathVariable("page") int page){
		
		log.info("get List"+bno);
		
		Criteria cri = new Criteria(page, 10);
		log.info("cri :"+cri);
		
		return new ResponseEntity<ReplyPageDTO>(replyService.getListPage(cri, bno), HttpStatus.OK);
	}
	
	
	@GetMapping(value="/{rno}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno){
		
		log.info("get......"+rno);
		
		return new ResponseEntity<ReplyVO>(replyService.get(rno), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{rno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno){
		
		log.info("remove........"+rno);
		
		int count = replyService.remove(rno);
		
		return count==1
				? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value = "/{rno}", method= {RequestMethod.PUT, RequestMethod.PATCH}, 
			consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody ReplyVO replyVO, @PathVariable("rno") Long rno){
		
		replyVO.setRno(rno);

		log.info("rno...."+rno);
		
		log.info("repltVO......."+replyVO);
		
		return replyService.modify(replyVO)==1
				? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
