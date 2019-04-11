package etudproject;
import java.util.List;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello") 
public class HelloController {

    @Get(produces = MediaType.ALL) 
    public List<Etudiant> index() {
    	Etudiant etudiant = new Etudiant();
   
        return etudiant.getMyList(); 
        
    }
}