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
	private UserRepository userRepository;

	@Autowired
	private JobSeekerRepository jobSeekerRepository;

	@RequestMapping("/login")

	public String login() {

		return "index";

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
		return "Home";
	}


	@RequestMapping("/jobseekerform")
	public String getJobSeekerForm(Model model)
	{
		model.addAttribute("jobseeker", new JobSeeker());
		return "jobseekerform";
	}


	@PostMapping("/jobseekerform")
	public String processJobSeekerForm(@Valid JobSeeker jobSeeker, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "jobseekerform";
		}
		jobSeekerRepository.save(jobSeeker);
		return "redirect:/jobseekerlist";
	}


	@RequestMapping("/jobseekerlist")
	public String getJobSeekerList(Model model) {

		model.addAttribute("jobseekers",jobSeekerRepository.findAll());
		return "jobseekerlist";
	}

	@RequestMapping("/user")
	public String getUser(Model model, @RequestParam("firstName") String firstName,
 String lastName, String email, String degreeCompleted, String universityName, String yearsCompleted,
                         String jobTitle, String companyName, String yearsWorked, String skilledType, String professional_Level) {

		model.addAttribute("First", firstName+" "+lastName);
		model.addAttribute("email", email);
		model.addAttribute("education", degreeCompleted+" "+universityName+" "+yearsCompleted);
		model.addAttribute("work" , companyName +" "+yearsWorked);
		model.addAttribute("skill" , skilledType+", "+professional_Level);
		model.addAttribute(new JobSeeker());
		return "user";
	}
//
//	@RequestMapping ("/searchFirstName")
//	public String searchFirstName(@RequestParam("firstName") String firstName, Model model) {
//		model.addAttribute(jobSeekerRepository.findByFirstName(firstName));
//
//		return "user";
//	}
//
//
//	@RequestMapping ("/searchSkillType")
//	public String searchSkillType(@RequestParam("skilledType") String skilledType, Model model) {
//		model.addAttribute(jobSeekerRepository.findBySkilledType(skilledType));
//		return "user";
//	}

	@RequestMapping("/admin")
	public String admin(){
		return "index";
	}

	@RequestMapping("/logout")
	public String logout(){
		return "login";
	}

}









