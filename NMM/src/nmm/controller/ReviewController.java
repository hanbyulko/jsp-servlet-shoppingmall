package nmm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nmm.dto.ModelAndView;
import nmm.dto.ProductDTO;
import nmm.dto.ReviewDTO;
import nmm.service.ProductService;
import nmm.service.ReviewService;
import nmm.service.UserService;

public class ReviewController implements Controller {
	int userNo;
	int reviewNo = 1;

	@Override
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("myPage/review.jsp", false);
	}

	public ModelAndView select(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		List<ReviewDTO> list = ReviewService.selectAll(Integer.parseInt(request.getParameter("pageNo")));
		request.setAttribute("pageCnt", list.get(list.size() > 0 ? list.size() - 1 : 0).getPageCnt());
		SendPageInfo.sendInfo(request, response);
		request.setAttribute("list", list);
		
		return new ModelAndView("product/productDetail.jsp", false);
	}

	public ModelAndView selectUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		String productName = request.getParameter("productName");
		
		List<ProductDTO> listName = ProductService.selectByName(productName);
		request.setAttribute("listName", listName);
		
		List<ReviewDTO> list = ReviewService.selectUser(Integer.parseInt(request.getParameter("pageNo")), productNo);
		ReviewDTO reviewDTO = list.get(list.size() > 0 ? list.size() - 1 : 0);
		request.setAttribute("pageCnt", reviewDTO.getPageCnt());
		SendPageInfo.sendInfo(request, response);
		request.setAttribute("product", reviewDTO.getProductDTO());
		request.setAttribute("list", list);
		return new ModelAndView("product/productDetail.jsp", false);
	}

	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		String reviewTitle = request.getParameter("reviewTitle");
		String reviewContent = request.getParameter("reviewContent");
		String reviewStar = request.getParameter("reviewStar");
		ReviewService.insert(userNo, productNo, new ReviewDTO(reviewNo, reviewTitle, reviewContent, reviewStar));
		//System.out.println(result);
		return new ModelAndView("user/purchase/purchaseHistoryTest.jsp", false);
	}

	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		ReviewService.delete(reviewNo);
		return new ModelAndView("user/purchase/purchaseHistoryTest.jsp", false);
	}

	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		//int reviewNo=350;
		String reviewTitle = request.getParameter("reviewTitle");
		String reviewContent = request.getParameter("reviewContent");
		String reviewStar = request.getParameter("reviewStar");
		int result = ReviewService.update(new ReviewDTO(reviewNo, reviewTitle, reviewContent, reviewStar));
		return new ModelAndView("user/purchase/purchaseHistoryTest.jsp", false);
	}

	public ModelAndView productList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<ProductDTO> list = ReviewService.selectTop();
		request.setAttribute("listPopular", list);
		return new ModelAndView("view/main.jsp", false);
	}
}