package com.iris.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iris.service.RepleService;

@Controller
public class RepleAddEditController {

	@Autowired
	RepleService repleService;

	
    @RequestMapping(value = "/reple/save", method = RequestMethod.GET)
    @ResponseBody
    public Object save(@RequestParam(value = "boardId") int boardId,
    					@RequestParam(value = "userName") String userName,
    					@RequestParam(value = "content") String content) throws ParseException {
    	
    	return repleService.save(boardId,userName,content);
    }
	
}
