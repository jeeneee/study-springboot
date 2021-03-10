package me.jeeneee.springboot.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import me.jeeneee.springboot.config.auth.LoginUser;
import me.jeeneee.springboot.config.auth.dto.SessionUser;
import me.jeeneee.springboot.service.posts.PostsService;
import me.jeeneee.springboot.web.dto.PostsResponseDto;

@RequiredArgsConstructor
@Controller
public class IndexController {

	private final PostsService postsService;
	private final HttpSession httpSession;

	@GetMapping("/")
	public String index(Model model, @LoginUser SessionUser user) {
		model.addAttribute("posts", postsService.findAllDesc());
		if (user != null) {
			model.addAttribute("userName", user.getName());
		}
		return "index";
	}

	@GetMapping("/posts/save")
	public String postsSave() {
		return "posts-save";
	}

	@GetMapping("/posts/update/{id}")
	public String postsUpdate(@PathVariable Long id, Model model) {
		PostsResponseDto dto = postsService.findById(id);
		model.addAttribute("post", dto);
		return "posts-update";
	}
}
