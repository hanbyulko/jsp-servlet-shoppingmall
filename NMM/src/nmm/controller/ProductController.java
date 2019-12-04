package nmm.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import nmm.dto.ModelAndView;
import nmm.dto.ProductDTO;
import nmm.service.ProductService;

public class ProductController implements Controller {

	@Override
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}

	public ModelAndView productList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<ProductDTO> list = ProductService.selectLatest();
		request.setAttribute("listLastest", list);
		return new ModelAndView("view/main.jsp", false);
	}
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		ProductService.delete(productNo);
		
		return new ModelAndView("manager/productManage.jsp", false);
	}

	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {
		Integer.parseInt(request.getParameter("productNo"));
		return null;
	}

	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String savePath = request.getServletContext().getRealPath("/01.imgs");

		MultipartRequest m = new MultipartRequest(request, savePath, "utf-8");

		String fileName = m.getFilesystemName(savePath);
		String newFileName = "";

		if (!fileName.equals("")) {
			String fullFileName = savePath + "/" + fileName;
			java.io.File f1 = new java.io.File(fullFileName);
			if (f1.exists()) {
				File newFile = new File(savePath + "/" + newFileName);
				f1.renameTo(newFile);
			}
		}

		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductCategory(m.getParameter("category"));
		productDTO.setProductStock(Integer.parseInt(request.getParameter("stock")));
		productDTO.setProductName(request.getParameter("name"));
		productDTO.setProductColor(request.getParameter("color"));
		productDTO.setProductSize(request.getParameter("size"));
		productDTO.setProductPrice(Integer.parseInt(request.getParameter("price")));
		ProductService.insert(productDTO);
		return new ModelAndView("manager/managerUserHandle.jsp", false);
	}

	public ModelAndView searchProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductDTO product = ProductService.selectProduct(Integer.parseInt(request.getParameter("productNo")));
		request.setAttribute("product", product);
		return new ModelAndView("product/productDetail.jsp", false);
	}

	public ModelAndView searchJacket(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<ProductDTO> list = ProductService.selectJacket();
		request.setAttribute("list", list);
		return new ModelAndView("product/productList.jsp", false);
	}

	public ModelAndView searchCoat(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<ProductDTO> list = ProductService.selectCoat();
		request.setAttribute("list", list);
		return new ModelAndView("product/productList.jsp", false);
	}

	public ModelAndView searchPadding(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<ProductDTO> list = ProductService.selectPadding();
		request.setAttribute("list", list);
		return new ModelAndView("product/productList.jsp", false);
	}

}
