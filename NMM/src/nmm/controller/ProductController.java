package nmm.controller;

import java.io.File;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import nmm.dto.ModelAndView;
import nmm.dto.ProductDTO;
import nmm.service.ProductService;

public class ProductController implements Controller {

	@Override
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}
	
	public ModelAndView productSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String keyword = request.getParameter("keyword");
		System.out.println(keyword);
		List<ProductDTO> list = ProductService.searchByKeyword(request.getParameter("keyword"));
		request.setAttribute("list", list);
		return new ModelAndView("view/search.jsp", false);
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

	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductDTO dto = new ProductDTO();
		
		dto.setProductNo(Integer.parseInt(request.getParameter("productNo")));
		dto.setProductCategory(request.getParameter("productCategory"));
		dto.setProductStock(Integer.parseInt(request.getParameter("productStock")));
		dto.setProductName(request.getParameter("productName"));
		dto.setProductColor(request.getParameter("productColor"));
		dto.setProductSize(request.getParameter("productSize"));
		dto.setProductPrice(Integer.parseInt(request.getParameter("productPrice")));
		ProductService.update(dto);
		return new ModelAndView("manager/productSelect.jsp", false);
	}

	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String savePath = request.getServletContext().getRealPath("images");
		System.out.println(savePath);
		// 파일 크기 15MB로 제한
		int sizeLimit = 1024 * 1024 * 15;
		MultipartRequest m = new MultipartRequest(request, savePath, sizeLimit, "UTF-8");
		Enumeration<String> files = m.getFileNames();
		String productName = m.getParameter("name");
		String[] rNames = { "D_1", "L_1", "D_2" };
		int ri = 0;
		while (files.hasMoreElements()) {
			String filename = files.nextElement();
			String rfile = m.getFilesystemName(filename);
			if (rfile != null) {
				File file_copy = new File(savePath + "/" + rfile);
				if (file_copy.exists()) {
					String f_ext = rfile.substring(rfile.length() - 3, rfile.length());
					java.io.File file2 = new java.io.File(savePath + "/" + productName + rNames[ri++] + "." + f_ext);
					file_copy.renameTo(file2);
				}
			}
		}

		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductCategory(m.getParameter("category"));
		productDTO.setProductStock(Integer.parseInt(request.getParameter("stock")));
		productDTO.setProductName(m.getParameter("name"));
		productDTO.setProductColor(m.getParameter("color"));
		productDTO.setProductSize(m.getParameter("size"));
		productDTO.setProductPrice(Integer.parseInt(m.getParameter("price")));
		ProductService.insert(productDTO);
		return new ModelAndView("manager/productInsert.jsp", false);
	}

	public ModelAndView searchProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductDTO product = ProductService.selectProduct(Integer.parseInt(request.getParameter("productNo")));
		request.setAttribute("product", product);
		return new ModelAndView("product/productDetail.jsp", false);
	}

	public ModelAndView searchByCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		String category = request.getParameter("category");
		System.out.println(pageNo + category);
		List<ProductDTO> list = ProductService.selectByCategory(pageNo, category);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("category", list.get(0).getProductCategory());
		request.setAttribute("list", list);
		return new ModelAndView("product/productList.jsp", false);
	}

	
	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		List<ProductDTO> list = ProductService.selectAll(pageNo);
		request.setAttribute("list", list);
		return new ModelAndView("manager/productSelect.jsp", false);
	}
}
