package com.tree.gdhealth.headoffice.sportsEquipment;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tree.gdhealth.dto.AddSportsEquipmentDto;
import com.tree.gdhealth.dto.PageDto;
import com.tree.gdhealth.dto.UpdateSportsEquipmentDto;
import com.tree.gdhealth.employee.login.LoginEmployee;
import com.tree.gdhealth.utils.auth.Auth;
import com.tree.gdhealth.utils.auth.Authority;
import com.tree.gdhealth.utils.pagination.HeadofficePagination;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 진관호
 */
@Slf4j
@RequestMapping("/headoffice/equipment")
@RequiredArgsConstructor
@Controller
public class EquipmentController {

	private final EquipmentService equipmentService;

	/**
	 * 전체 물품 목록을 나타내는 페이지로 이동합니다.
	 * 
	 * @return 물품 목록 페이지
	 */
	@Auth(AUTHORITY = Authority.HEAD_EMP_ONLY)
	@GetMapping
	public String getEquipmentList() {
		return "headoffice/equipmentList";
	}

	/**
	 * 페이지네이션 후의 물품 목록 영역을 리턴합니다.
	 * 
	 * @param pageDto 페이지네이션과 관련한 데이터를 전송하기 위한 객체
	 * @return 페이지네이션 후의 물품 목록
	 * @apiNote 페이지 전체가 아닌 물품의 목록을 나타내는 영역만 리턴합니다.
	 */
	@GetMapping("/pagination")
	public String getPagination(Model model, @ModelAttribute PageDto pageDto) {

		HeadofficePagination pagination = equipmentService.getPagination(pageDto.getPageNum(),
				equipmentService.getEquipmentCnt());

		List<Map<String, Object>> equipmentList = equipmentService.getEquipmentList(pagination.getBeginRow(),
				pagination.getRowPerPage());

		model.addAttribute("lastPage", pagination.getLastPageNum());
		model.addAttribute("currentPage", pagination.getCurrentPageNum());
		model.addAttribute("startPageNum", pagination.getStartPageNum());
		model.addAttribute("endPageNum", pagination.getEndPageNum());
		model.addAttribute("prev", pagination.isPrev());
		model.addAttribute("next", pagination.isNext());
		
		model.addAttribute("equipmentList", equipmentList);

		return "headoffice/fragment/equipmentList";
	}

	/**
	 * 검색 결과가 반영된 페이지네이션 후의 물품 목록 영역을 리턴합니다.
	 * 
	 * @param pageDto 페이지네이션과 관련한 데이터를 전송하기 위한 객체
	 * @return 페이지네이션 후의 물품 목록
	 * @apiNote 페이지 전체가 아닌 물품의 목록을 나타내는 영역만 리턴합니다.
	 */
	@GetMapping("/searchPagination")
	public String getSearchPagination(Model model, @ModelAttribute PageDto pageDto) {

		HeadofficePagination pagination = equipmentService.getPagination(pageDto.getPageNum(),
				equipmentService.getEquipmentCnt(pageDto.getType(), pageDto.getKeyword()));

		List<Map<String, Object>> searchList = equipmentService.getEquipmentList(pagination.getBeginRow(),
				pagination.getRowPerPage(), pageDto.getType(), pageDto.getKeyword());

		model.addAttribute("lastPage", pagination.getLastPageNum());
		model.addAttribute("currentPage", pagination.getCurrentPageNum());
		model.addAttribute("startPageNum", pagination.getStartPageNum());
		model.addAttribute("endPageNum", pagination.getEndPageNum());
		model.addAttribute("prev", pagination.isPrev());
		model.addAttribute("next", pagination.isNext());
		
		model.addAttribute("equipmentList", searchList);
		model.addAttribute("type", pageDto.getType());
		model.addAttribute("keyword", pageDto.getKeyword());

		return "headoffice/fragment/searchEquipmentList";
	}

	/**
	 * 물품 추가 페이지로 이동합니다.
	 * 
	 * @return 물품 추가 페이지
	 */
	@Auth(AUTHORITY = Authority.HEAD_EMP_ONLY)
	@GetMapping("/add")
	public String addEquipment() {
		return "headoffice/addEquipment";
	}

	/**
	 * 물품을 성공적으로 추가했을 경우 물품 목록 페이지로 이동합니다. 유효성 검사 실패로 인해 추가가 중단된 경우 다시 물품 추가 페이지로
	 * 이동합니다.
	 * 
	 * @param addSportsEquipmentDto 물품을 추가하기 위해 필요한 데이터를 전송하기 위한 객체
	 * @param empInfo               로그인한 직원의 정보를 담은 LoginEmployee 객체
	 * @return 물품 목록 페이지로 리다이렉트
	 */
	@Auth(AUTHORITY = Authority.HEAD_EMP_ONLY)
	@PostMapping("/add")
	public String addEquipment(@Validated @ModelAttribute AddSportsEquipmentDto addSportsEquipmentDto,
			BindingResult bindingResult, HttpSession session,
			@SessionAttribute(name = "loginEmployee") LoginEmployee empInfo) {

		if (bindingResult.hasErrors()) {
			log.error("errors = {}", bindingResult);
			return "headoffice/addEquipment";
		}

		addSportsEquipmentDto.setEmployeeNo(empInfo.getEmployeeNo());
		String path = session.getServletContext().getRealPath("/upload/equipment");
		
		equipmentService.addEquipment(addSportsEquipmentDto, path);

		return "redirect:/headoffice/equipment";
	}

	/**
	 * 특정 물품의 업데이트 페이지로 이동합니다.
	 * 
	 * @param equipmentNo 업데이트할 물품의 번호
	 * @return 물품 업데이트 페이지
	 */
	@Auth(AUTHORITY = Authority.HEAD_EMP_ONLY)
	@GetMapping("/update/{equipmentNo}")
	public String modifyEquipment(Model model, @PathVariable Integer equipmentNo) {
		model.addAttribute("equipmentOne", equipmentService.getEquipmentOne(equipmentNo));
		return "headoffice/updateEquipment";
	}

	/**
	 * 물품 업데이트를 성공했을 경우 물품 목록 페이지로 리다이렉트합니다. 유효성 검사 실패로 인해 업데이트가 중단된 경우 다시 물품 업데이트
	 * 페이지로 리다이렉트합니다.
	 * 
	 * @param updateSportsEquipmentDto 물품을 추가하기 위해 필요한 데이터를 전송하기 위한 객체
	 * @return 물품 목록 페이지로 리다이렉트
	 */
	@Auth(AUTHORITY = Authority.HEAD_EMP_ONLY)
	@PostMapping("/update")
	public String modifyEquipment(@Validated @ModelAttribute UpdateSportsEquipmentDto updateSportsEquipmentDto,
			BindingResult bindingResult, HttpSession session, RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			log.error("errors = {}", bindingResult);
			redirectAttributes.addAttribute("equipmentNo", updateSportsEquipmentDto.getSportsEquipmentNo());
			return "redirect:/headoffice/equipment/update/{equipmentNo}";
		}

		String oldPath = session.getServletContext()
				.getRealPath("/upload/equipment/" + updateSportsEquipmentDto.getSportsEquipmentImgFileName());
		String newPath = session.getServletContext().getRealPath("/upload/equipment");

		equipmentService.modifyEquipment(updateSportsEquipmentDto, newPath, oldPath);

		return "redirect:/headoffice/equipment";
	}

	/**
	 * 물품을 성공적으로 비활성화하면 1을 리턴합니다.
	 * 
	 * @param equipmentNo 비활성화할 물품 번호
	 * @return 비활성화 상태로 정상적으로 변경되었다면 1
	 */
	@Auth(AUTHORITY = Authority.HEAD_EMP_ONLY)
	@ResponseBody
	@PostMapping("/deactivate")
	public int deactivateEquipment(@RequestParam Integer equipmentNo) {
		return equipmentService.modifyDeactivation(equipmentNo);
	}

	/**
	 * 물품을 성공적으로 활성화하면 1을 리턴합니다.
	 * 
	 * @param equipmentNo 활성화할 물품 번호
	 * @return 활성화 상태로 정상적으로 변경되었다면 1
	 */
	@ResponseBody
	@PostMapping("/activate")
	public int activateEquipment(@RequestParam Integer equipmentNo) {
		return equipmentService.modifyActivation(equipmentNo);
	}
	
}
