package jana60.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jana60.model.Degrees;
import jana60.model.Teacher;
import jana60.model.University;
import jana60.repository.UniversityRepository;
import jana60.repository.DegreesRepository;
import jana60.repository.TeacherRepository;


@Controller
@RequestMapping("/")
public class ControllerUniversità{
	
	@Autowired 
	private UniversityRepository repo;
	@Autowired
	private DegreesRepository repo2;
	@Autowired
	private TeacherRepository repo3;
	
	@GetMapping("/")
	public String index (Model model)
	{
		return "index";
	}

	@GetMapping("/department")
	public String home(Model model) {
		List<University> DepartmentsList =(List<University>)repo.findAll();
		model.addAttribute("DepartmentsList" ,DepartmentsList);
		return "home";
	}
	
	@GetMapping("/degrees")
	public String degrees (Model model) {
		List<Degrees>degreesList =(List<Degrees>)repo2.findAll();
		model.addAttribute("degreesList" ,degreesList);
		return "degrees";
	}
	
	@GetMapping("/department/{id}")
	public String departmentsDetails (Model model,@PathVariable(name = "id") Integer departmentsPrimaryKey) {
		University currentDepartment = repo.findById(departmentsPrimaryKey).get();
		model.addAttribute("department" ,currentDepartment);
		return "homeDetails";
	}
	@GetMapping("/teacher")
	public String teachersList(Model model)
	{
		model.addAttribute("TeachersList" , repo3.findAll());
		return "teacher";
	}

	@GetMapping("/teacher/{teacherId}")
	public String teachersDetail(Model model,
			@PathVariable(name = "teacherId") Integer teachersPrimaryKey)
	{
		Teacher curDep = repo3.findById(teachersPrimaryKey).get();
		model.addAttribute("teacher", curDep);
		return "teacherDetails";
	}
}