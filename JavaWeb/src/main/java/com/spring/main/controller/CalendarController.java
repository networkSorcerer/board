package com.spring.main.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalendarController {

@GetMapping("/calendar")
public String showCalendar(Model model) {
	LocalDate currentDate = LocalDate.now();
	
	int currentYear = currentDate.getYear();
	int currentMonth = currentDate.getMonthValue();
	
	LocalDate firstDayOfMonth = LocalDate.of(currentYear, currentMonth, 1);
	LocalDate lastDayOfMonth = firstDayOfMonth.withDayOfMonth(firstDayOfMonth.lengthOfMonth());
	
	List<String> monthSchedule = new ArrayList<>();
	for (int day = 1; day <= lastDayOfMonth.getDayOfMonth(); day++) {
		monthSchedule.add("");
	}
	
	model.addAttribute("currentYear", currentYear);
	model.addAttribute("currentMonth", currentMonth);
	model.addAttribute("monthSchedule", monthSchedule);
	return "/project/calendar";
	
}
}
