package nmm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nmm.dto.ModelAndView;
import nmm.dto.QnaDTO;
import nmm.service.QnaService;

public class QnaController implements Controller{
	private String userId;
	private int userNo;
	
	@Override
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getSession().getAttribute("userNo")!=null) {
			userId = (String)request.getSession().getAttribute("userId");
			userNo = (int)request.getSession().getAttribute("userNo");
		}
		List<QnaDTO> list = QnaService.selectByUserId(Integer.parseInt(request.getParameter("pageNo")), userId);
		request.setAttribute("pageCnt", list.get(list.size()-1>0?list.size()-1:list.size()).getPageCnt());
		SendPageInfo.sendInfo(request, response);
		request.setAttribute("list", list);
		return new ModelAndView("myPage/qna.jsp", false);
	}
	
	public ModelAndView selectByQnaNo(HttpServletRequest request, HttpServletResponse response) throws Exception{
		QnaDTO qnaDTO = QnaService.selectByQnaNo(Integer.parseInt(request.getParameter("qnaNo")));
		request.setAttribute("qnaDTO", qnaDTO);
		return new ModelAndView("myPage/qna.jsp", false);
	}

	public ModelAndView select(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<QnaDTO> list = QnaService.selectAll(Integer.parseInt(request.getParameter("pageNo"))); 
		request.setAttribute("list" , list);
		SendPageInfo.sendInfo(request, response);
		return new ModelAndView("myPage/qna.jsp", false);
	}

	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		QnaService.delete(qnaNo);
		return new ModelAndView("myPage/qna.jsp", false);
	}

	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("insert »£√‚");
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		String qnaTitle = request.getParameter("qnaTitle");
		String qnaContent = request.getParameter("qnaContent");
		QnaService.insert(userNo, productNo, new QnaDTO(qnaTitle, qnaContent));
		return new ModelAndView("myPage/qna.jsp", false);
	}
	
	
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		String qnaTitle = request.getParameter("qnaTitle");
		String qnaContent = request.getParameter("qnaContent");
		
		QnaService.update(new QnaDTO(qnaNo, qnaTitle, qnaContent));
		return new ModelAndView("myPage/qna.jsp", false);
	}
	
}
