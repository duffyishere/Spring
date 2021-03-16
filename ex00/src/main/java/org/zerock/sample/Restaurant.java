package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
//@AllArgsConstructor
public class Restaurant {
 
	@Setter(onMethod_ = {@Autowired})
	private Chef chef;
}
