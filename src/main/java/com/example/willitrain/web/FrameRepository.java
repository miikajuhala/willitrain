package com.example.willitrain.web;


import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.willitrain.web.Frame;

public interface FrameRepository extends CrudRepository<Frame, Long> {

	ArrayList<Frame> findByName(String string);
	
}