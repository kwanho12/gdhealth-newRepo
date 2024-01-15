package com.tree.gdhealth.headoffice.sportsEquipment;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.tree.gdhealth.headoffice.Paging;
import com.tree.gdhealth.vo.SportsEquipment;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/headoffice/equipment")
@RequiredArgsConstructor
@Controller
public class EquipmentController {
	
	// DI
	private final EquipmentService equipmentService;
	
	@GetMapping
	public String equipment() {
		
		return "headoffice/equipmentList";
	}
	
	@GetMapping("/paging")
	public String paging(Model model, int page) {
		
		// 전체 물품 수
		int equipmentCnt = equipmentService.getEquipmentCnt();
		// 디버깅
		log.debug("전체 물품 수 : " + equipmentCnt);
		
		// 페이징
		Paging paging = Paging.builder()
				.pageNumCnt(10) // 한번에 표시할 페이징 번호의 갯수
				.rowPerPage(8) // 한 페이지에 나타낼 row 수
				.currentPage(page) // 현재 페이지
				.cnt(equipmentCnt) // 전체 row 수
				.build();
		paging.calculation();
		
		List<Map<String, Object>> equipmentList = equipmentService.getEquipmentList(paging.getBeginRow(), paging.getRowPerPage());
		model.addAttribute("equipmentList", equipmentList);
		
		// 페이징(model 추가)
		paging.pagingAttributes(model, paging, page);
		
		return "headoffice/fragment/equipment";
	}
	
	@GetMapping("/searchPaging")
	public String searchPaging(Model model, String type, String keyword, 
			int page) {
		
		// 검색 결과 개수
		int searchCnt = equipmentService.getSearchCnt(type, keyword);
		// 디버깅
		log.debug("검색 결과 개수(searchPaging) " + searchCnt);
		
		// 페이징
		Paging paging = Paging.builder()
				.pageNumCnt(10) // 한번에 표시할 페이징 번호의 갯수
				.rowPerPage(8) // 한 페이지에 나타낼 row 수
				.currentPage(page) // 현재 페이지
				.cnt(searchCnt) // 전체 row 수
				.build();
		paging.calculation();
		
		List<Map<String, Object>> searchList = equipmentService.getSearchList(paging.getBeginRow(), paging.getRowPerPage(), type, keyword);
		model.addAttribute("equipmentList", searchList);
		
		// 페이징(model 추가)
		paging.pagingAttributes(model, paging, page); 
		
		// search parameter 추가
		model.addAttribute("type", type);
		model.addAttribute("keyword", keyword);
		
		return "headoffice/fragment/searchEquipment";
		
	}
	
	@GetMapping("/addEquipment")
	public String addEquipment() {
		
		return "headoffice/addEquipment";
	}
	
	@PostMapping("/addEquipment")
	public String addEquipment(@Validated SportsEquipment sportsEquipment, BindingResult bindingResult,
								MultipartFile equipmentFile,
								HttpSession session) {
		
		// SportsEquipment의 유효성 검증 실패시 처리
		if(bindingResult.hasErrors()) {
			
			// 에러 메시지 출력
	        for (ObjectError error : bindingResult.getAllErrors()) {
	        	log.debug("SportsEquipment 객체 validation 실패 : " + error.getDefaultMessage());
	        }
			
			return "headoffice/addEquipment";
		}
		
		String path = session.getServletContext().getRealPath("/upload/program");
		// 디버깅
		log.debug("저장 경로 : " + path);
		
		
		return "redirect:/headoffice/equipment";
	}

}
