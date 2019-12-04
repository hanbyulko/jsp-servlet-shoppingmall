package nmm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nmm.dto.ModelAndView;
import nmm.dto.ProductDTO;
import nmm.dto.ReviewDTO;
import nmm.service.ReviewService;
import nmm.service.UserService;

public class ReviewController implements Controller {
   int userNo;
   int reviewNo = 1;

   @Override
   public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
      userNo = 1;// �׽�Ʈll�� �ӽð�;;
      return new ModelAndView("myPage/review.jsp", false);

   }

   public ModelAndView select(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
	  int productNo = Integer.parseInt(request.getParameter("productNo"));
      List<ReviewDTO> list = ReviewService.selectAll(productNo);
      request.setAttribute("list", list);
      return new ModelAndView("product/productDetail.jsp", false);
   }

   public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
      int productNo = 1;
      // int productNo = Integer.parseInt(request.getParameter("productNo"));
      String reviewTitle = request.getParameter("reviewTitle");
      String reviewContent = request.getParameter("reviewContent");
      String reviewStar = request.getParameter("reviewStar");
      System.out.println(reviewTitle);

      ReviewService.insert(userNo, productNo, new ReviewDTO(reviewNo, reviewTitle, reviewContent, reviewStar));
      return new ModelAndView("myPage/review.jsp", false);
   }

   public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
      int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
      ReviewService.delete(reviewNo);
      return new ModelAndView("myPage/review.jsp", false);
   }

   public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
      int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
      String reviewTitle = request.getParameter("reviewTitle");
      String reviewContent = request.getParameter("reviewContent");
      String reviewStar = request.getParameter("reviewStar");

      ReviewService.update(new ReviewDTO(reviewNo, reviewTitle, reviewContent, reviewStar));
      return new ModelAndView("myPage/review.jsp", false);
   }

   public ModelAndView productList(HttpServletRequest request, HttpServletResponse response) throws Exception {
      List<ProductDTO> list = ReviewService.selectTop();
      request.setAttribute("listPopular", list);
      return new ModelAndView("view/main.jsp", false);
   }
}