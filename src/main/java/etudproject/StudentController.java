package etudproject;
import java.util.List;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/student") 
public class StudentController {

    @Get("/") 
    public List<Etudiant> index() {
    	Etudiant etudiant = new Etudiant();
  
        return etudiant.getMyList(); 
        
    }
}