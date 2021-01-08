package com.lcomputerstudy.testmvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lcomputerstudy.testmvc.service.BoardService;
import com.lcomputerstudy.testmvc.service.CommentService;
import com.lcomputerstudy.testmvc.service.ImageService;
import com.lcomputerstudy.testmvc.service.UserService;
import com.lcomputerstudy.testmvc.vo.Board;
import com.lcomputerstudy.testmvc.vo.BoardPagination;
import com.lcomputerstudy.testmvc.vo.Comment;
import com.lcomputerstudy.testmvc.vo.Image;
import com.lcomputerstudy.testmvc.vo.User;
import com.lcomputerstudy.testmvc.vo.UserPagination;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String contextPath = request.getContextPath();
		String requestURI = request.getRequestURI();
		String command = requestURI.substring(contextPath.length());
		String view = null;
		
		// int usercount = 0;
		String idx = null;
		String pw = null;
		int u_page = 1;
		int b_page = 1;
		
		ImageService imageService = null;
		Image image = null;
		
		CommentService commentService = null;
		Comment comment = null;
		ArrayList<Comment> c_list = null;
		
		Gson gson = null;
		String jsonStr = null;
		PrintWriter p_writer = null;
		
		command = checkSession(request, response, command);
		
		switch (command) {
			case "/user-list.do":
				String reqUPage = request.getParameter("page");
				if (reqUPage != null) {
					u_page = Integer.parseInt(reqUPage);
					// page = (page-1)*3;
				}
				UserService userService = UserService.getInstance();
				ArrayList<User> list = userService.getUsers(u_page);
				UserPagination u_pagination = new UserPagination(u_page);
				// usercount = userService.getUsersCount();
				
				request.setAttribute("list", list);
				request.setAttribute("pagination", u_pagination);

				view = "user/list";
				break;
				
			case "/user-insert.do":
				view = "user/insert";
				break;
				
			case "/user-insert-process.do":
				User user = new User();
				user.setU_id(request.getParameter("id"));
				user.setU_pw(request.getParameter("password"));
				user.setU_name(request.getParameter("name"));
				user.setU_tel(request.getParameter("tel1") + "-" + request.getParameter("tel2") + "-" + request.getParameter("tel3"));
				user.setU_age(request.getParameter("age"));
				
				userService = UserService.getInstance();
				userService.insertUser(user);
				
				view = "user/insert-result";
				break;
				
			case "/user-login.do":
				view = "user/login";
				break;
				
			case "/user-login-process.do":
				idx = request.getParameter("login_id");
				pw = request.getParameter("login_password");
				
				userService = UserService.getInstance();
				user = userService.loginUser(idx, pw);
				
				if(user != null) {
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					// session.setAttribute("id", idx);
					
					view = "user/login-result";
				} else {
					view = "user/login-fail";
				}
				break;
				
			case "/logout.do":
				HttpSession session = request.getSession();
				session.invalidate();
				view = "user/login";
				break;
				
			case "/access-denied.do":
				view = "user/access-denied";
				break;
				
			case "/board-list.do":
				String reqBPage = request.getParameter("page");
				if(reqBPage != null) {
					b_page = Integer.parseInt(reqBPage);
				}
				BoardService boardService = BoardService.getInstance();
				ArrayList<Board> b_list = boardService.getBoards(b_page);
				BoardPagination b_pagination = new BoardPagination(b_page);
				
				request.setAttribute("list", b_list);
				request.setAttribute("pagination", b_pagination);

				view = "board/list";
				break;
				
			case "/board-insert.do":
				view = "board/insert";
				break;
				
			case "/board-insert-process.do":
				Board board = new Board();
				board.setB_title(request.getParameter("title"));
				board.setB_content(request.getParameter("content"));
				board.setB_date(request.getParameter("date"));
				board.setB_writer(request.getParameter("writer"));
				board.setU_idx(Integer.parseInt(request.getParameter("u_idx")));
				board.setB_group_idx(0);
				board.setB_layer_idx(0);
				
				boardService = BoardService.getInstance();
				boardService.insertBoard(board);
				
				view = "board/insert-result";
				break;
				
			case "/board-detail.do":
				String b_idx = request.getParameter("b_idx");
				boardService = BoardService.getInstance();
				board = boardService.getBoard(b_idx);
								
				request.setAttribute("board", board);
								
				view = "board/detail";
				break;
				
			case "/board-edit.do":
				b_idx = request.getParameter("b_idx");
				boardService = BoardService.getInstance();
				board = boardService.getBoard(b_idx);
				
				request.setAttribute("board", board);
				
				view = "board/edit";
				break;
				
			case "/board-edit-process.do":
				board = new Board();
				board.setB_idx(Integer.parseInt(request.getParameter("edit_b_idx")));
				board.setB_title(request.getParameter("edit_title"));
				board.setB_content(request.getParameter("edit_content"));
				board.setB_date(request.getParameter("edit_date"));
				board.setB_writer(request.getParameter("edit_writer"));
				board.setU_idx(Integer.parseInt(request.getParameter("edit_u_idx")));
				
				boardService = BoardService.getInstance();
				boardService.editBoard(board);
				
				view = "board/edit-result";
				break;
				
			case "/board-delete.do":
				b_idx = request.getParameter("b_idx");
				boardService = BoardService.getInstance();
				boardService.deleteBoard(b_idx);
				
				view = "board/delete-result";
				break;
				
			case "/board-reply.do":
				b_idx = request.getParameter("b_idx");
				boardService = BoardService.getInstance();
				board = boardService.getBoard(b_idx);
				
				request.setAttribute("board", board);
				
				view = "board/reply";
				break;
				
			case "/board-reply-process.do":
				board = new Board();
				board.setB_title(request.getParameter("b_title"));
				board.setB_content(request.getParameter("b_content"));
				board.setB_date(request.getParameter("b_date"));
				board.setB_writer(request.getParameter("b_writer"));
				board.setU_idx(Integer.parseInt(request.getParameter("u_idx")));
				board.setB_origin(Integer.parseInt(request.getParameter("b_origin")));
				board.setB_group_idx(Integer.parseInt(request.getParameter("b_group_idx")));
				board.setB_layer_idx(Integer.parseInt(request.getParameter("b_layer_idx")));
				
				boardService = BoardService.getInstance();
				boardService.replyBoard(board);
				
				view = "board/reply-result";
				break;
				
			case "/comment-read.do":
				response.setContentType("application/json");

				b_idx = request.getParameter("b_idx");
				boardService = BoardService.getInstance();
				c_list = boardService.getComments(b_idx);
				
				gson = new GsonBuilder().setPrettyPrinting().create();
				jsonStr = gson.toJson(c_list);
				p_writer = response.getWriter();
				p_writer.print(jsonStr);
				p_writer.flush();
				
				view = null;
				break;
				
			case "/comment-write.do":
				response.setContentType("application/json");
				
				comment = new Comment();
				comment.setB_idx(Integer.parseInt(request.getParameter("b_idx")));
				comment.setU_idx(Integer.parseInt(request.getParameter("u_idx")));
				comment.setC_content(request.getParameter("c_content"));
				
				commentService = CommentService.getInstance();
				commentService.writeComment(comment);
				
				/*
				 * String c_date_str = request.getParameter("c_date"); SimpleDateFormat
				 * transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); Date c_date; try {
				 * c_date = transFormat.parse(c_date_str); comment.setC_date(c_date); } catch
				 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
				 * }
				 */
					
				view = null;
				break;
				
			case "/image-upload-pre.do":
				
				view = "board/image-upload-test";
				break;
			
			case "/image-upload-test.do":
				String realPath = request.getRealPath("upload");
				int maxSize = 1024 * 1024 * 10;
				MultipartRequest multipartRequest = new MultipartRequest(request, realPath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
				String i_name = multipartRequest.getOriginalFileName("fname");
				String i_real_name = multipartRequest.getFilesystemName("fname");
				imageService = ImageService.getInstance();
				imageService.insertImage(i_name, i_real_name);
				
				view = "/board/list";
				break;
		}
		
		if (view != null) {
			RequestDispatcher rd = request.getRequestDispatcher(view + ".jsp");
			rd.forward(request, response);
		}
	}
	
	String checkSession(HttpServletRequest request, HttpServletResponse response, String command) {
		HttpSession session = request.getSession();
		
		String[] authList = {
				"/logout.do",
				"/user-list.do",
				"/user-detail.do",
				"/user-insert.do",
				"/user-insert-process.do",
				"/user-edit.do",
				"/user-edit-process.do",
				"/board-list.do",
				"/board-detail.do",
				"/board-insert.do",
				"/board-insert-process.do",
				"/board-edit.do",
				"/board-edit-process.do",
				"/board-delete.do",
				"/board-reply.do"
		};
		
		for (String item : authList) {
			if (item.equals(command)) {
				if (session.getAttribute("user") == null) {
					command = "/access-denied.do";
				}
			}
		}
		
		return command;
	}
}
