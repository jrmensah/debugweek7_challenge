package com.example.week7_challenge.Controller;


import com.example.week7_challenge.repositories.JobSeekerRepository;
import com.example.week7_challenge.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	@Autowired
	UserRepository userRepository;

	@Autowired
	JobSeekerRepository jobSeekerRepository;

	@RequestMapping("/login")

	public String login() {

		return "login";

	}

	@RequestMapping("/")
	public String home(Model model) {

		model.addAttribute(new JobSeeker());
		return "Home";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationPage(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegistrationPage(
			@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {

		model.addAttribute("user", user);

		if (result.hasErrors()) {
			return "registration";
		} else {
			userService.saveUser(user);
			model.addAttribute("message", "User Account Successfully Created");
		}
		return "redirect:/jobseekerform";
	}


	@RequestMapping("/jobseekerform")
	public String jobseekerform(Model model)
	{
		model.addAttribute("jobseeker", new JobSeeker());
		return "jobseekerform";
	}


	@PostMapping("/jobseekerform")
	public String jobseekerform(@Valid JobSeeker jobSeeker, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "jobseekerform";
		}
		jobSeekerRepository.save(jobSeeker);
		return "redirect:/jobseekerlist";
	}


	@RequestMapping(value = "/jobseekerlist")
	public String jobseekerlist(Model model) {

		model.addAttribute("jobseekers",jobSeekerRepository.findAll());
		return "jobseekerlist";
	}

	@RequestMapping("/user")
	public String jobseekerlist(Model model, @RequestParam("firstName") String firstName,
 String lastName, String email, String degreeCompleted, String universityName, String yearsCompleted,
                         String jobTittle, String companyName, String yearsWorked, String skilledType, String proffesional_Level) {

		model.addAttribute("First", firstName+" "+lastName);
		model.addAttribute("email", email);
		model.addAttribute("education", degreeCompleted+" "+universityName+" "+yearsCompleted);
		model.addAttribute("work" , companyName +" "+yearsWorked);
		model.addAttribute("skill" , skilledType+", "+proffesional_Level);
		model.addAttribute(new JobSeeker());
		return "user";
	}

//	@RequestMapping ("/searchfirstName")
//	public String searchfirstName(@RequestParam("firstName") String firstName, Model model) {
//		model.addAttribute(jobSeekerRepository.findByFirstName(firstName));
//
//		return "user";
//	}
//
//
//	@RequestMapping ("/searchskillType")
//	public String searchskillType(@RequestParam("skilledType") String skilledType, Model model) {
//		model.addAttribute(jobSeekerRepository.findBySkilledType(skilledType));
//		return "user";
//	}

}









