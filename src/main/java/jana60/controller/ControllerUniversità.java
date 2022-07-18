package jana60.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jana60.model.Degrees;
import jana60.model.University;
import jana60.repository.UniversityRepository;
import jana60.repository.DegreesRepository;


@Controller
@RequestMapping("/")
public class ControllerUniversità{
	
	@Autowired 
	private UniversityRepository repo;
	@Autowired
	private DegreesRepository repo2;
	
	@GetMapping("/index")
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
	@GetMapping("/degrees/{id}")
	public String degrees(Model model,@PathVariable(name = "id") Integer departmentsPrimaryKey) {
		University currentDepartment = repo.findById(departmentsPrimaryKey).get();
		model.addAttribute("DegreesList" ,currentDepartment);
		return "degrees";
	}
}