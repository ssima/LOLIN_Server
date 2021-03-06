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
public class RepleController {

	@Autowired
	RepleService repleService;

	@RequestMapping(value = "/reple/selectAll", method = RequestMethod.GET)
	@ResponseBody
	public Object selectAll() throws ParseException{
		return repleService.findAll();
	}
	
	@RequestMapping(value = "/reple/findOne", method = RequestMethod.GET)
	@ResponseBody
	public Object findOne(@RequestParam(value = "boardId") int boardId,
							@RequestParam(value = "hash") String hash) throws ParseException{
		return repleService.findById(boardId,hash);
	}
}
