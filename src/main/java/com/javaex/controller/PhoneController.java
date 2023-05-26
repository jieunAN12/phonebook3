package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PersonDAO;
import com.javaex.vo.PersonVO;

@Controller
// @RequestMapping("/phone")
public class PhoneController {
	
	@Autowired
	private PersonDAO dao;
	
	// @Controller : 이 어노테이션으로 인해 내부적으로 컨트롤러의 역할을 할 수 있다.
	// LoggerFactory.getLogger() : 로그 정보를 출력하는 객체
	// @RequestMapping() :  요정 주소와 실제주소를 매핑하는 어노테이션. 마치 if문 하고 같다. 
	// @GetMapping() : @RequestMapping()과 같은 역할을 하고, 요즘엔 이 어노테이션을 더 많이 쓴다. 
	
	//전체 리스트
	@RequestMapping(value="/list",method={RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {//model은 데이터 view는 화면
		System.out.println("list() 실행 확인!");
		//PersonDAO dao = new PersonDAO(); //@Autowired 때문에 없어도 사용가능
		List<PersonVO> list = dao.getPersonlist();
		System.out.println("db에 있는거 들어왔나 콘솔 확인!"+list);
		model.addAttribute("plist", list);//plist는 list.jsp에서 사용
		return "/views/list.jsp";
	}
	
	//등록
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PersonVO vo) {//묶어서 뽑기
	//public String write(@requestParam("name") String name, 
	//					  @requestParam("hp") String hp, 
	//					  @requestParam("company") String company) { 하나씩 뽑아주기
		System.out.println("write() 실행 확인!");
		System.out.println("write() 실행 확인!");
		System.out.println(vo);
		//dao에 있는거 가져오기
		//PersonDAO dao = new PersonDAO();
		dao.personinsert(vo);
		//리스트로 redirect 코딩 입력!
		return "redirect:/list";
	}
	
	//전화번호 등록
	@RequestMapping(value="/write2", method= {RequestMethod.GET, RequestMethod.POST})
	public String write2(@RequestParam("name") String name, @RequestParam("hp") String hp
					   , @RequestParam("company") String company) {
		System.out.println("write2()");
		System.out.println(name + hp + company);
		
		dao.personinsert(name, hp, company);
		return "redirect:/list";
	}
	
	//등록 폼
	@RequestMapping(value="/writeForm", method=RequestMethod.GET)
	public String writeForm() {
		System.out.println("writeForm() 실행 확인!");
		return "/views/writeForm.jsp";
	}

	//수정
	@RequestMapping(value="/update", method= {RequestMethod.GET, RequestMethod.POST})
	public String update(@ModelAttribute PersonVO vo) {//묶어서 뽑기
		System.out.println("update() 실행 확인!");
		System.out.println(vo);
		//dao에 있는거 가져오기
		//PersonDAO dao = new PersonDAO();
		dao.personupdate(vo);
		//int count = dao.personupdate(vo);
		//리스트로 redirect 코딩 입력!
		return "redirect:/list";
	}

	//패스델리어블
	@RequestMapping(value="/updateForm/{no1}/{no2}", method=RequestMethod.GET)
	public String updateForm2(@PathVariable("no1") int no1, @PathVariable("no2") int no2) {
		System.out.println("updateForm2() 실행 확인!");//확
		System.out.println(no1);
		System.out.println(no2);
		return "";
	}

	//수정 폼
	@RequestMapping(value="/updateForm", method=RequestMethod.GET)
	public String updateForm(@RequestParam("person_id") int person_id, Model model) {
		System.out.println("updateForm() 실행 확인!");//확인
		System.out.println(person_id);//확인
		
		//PersonDAO dao = new PersonDAO();
		PersonVO vo = dao.getPerson(person_id);
		System.out.println(vo);//확인
		
		model.addAttribute("vo", vo);//plist는 list.jsp에서 사용
		
		return "/views/updatelist.jsp";
	}
	
	//삭제 폼
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	//public String delete(int person_id) {
	public String delete(@RequestParam("person_id") int person_id) {
		System.out.println("delete() 실행 확인!");
		//PersonDAO dao = new PersonDAO();
		dao.persondelect(person_id);
		return "redirect:/list";
	}
	
	@RequestMapping("/hello")//밑에있는 hello 호출
	public String hello() {
		System.out.println("hello찍을거야");
		return "/views/index.jsp";
	}

}
