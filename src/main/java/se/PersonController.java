package se;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	@Autowired
	private PersonRepository repository;
    @RequestMapping("/test")
    public String test(@RequestParam(value="name", defaultValue="World") String name) {
        return "{\"id\":\"hello\"}";
    }
    
    @RequestMapping("/persons")
    public Iterable<Person> persons(@RequestParam(value="name", defaultValue="World") String name) {
        return repository.findAll();
    }    

    @RequestMapping("/person/{id}")
    public Person get(@PathVariable("id") int id) {
        return repository.findOne(id);
    } 

    @RequestMapping(value = "/person" , method = RequestMethod.POST)
    public @ResponseBody Person create(@RequestBody Person item) {
        return repository.save(item);
    }

    @RequestMapping(value = "/person" , method = RequestMethod.PUT)
    public @ResponseBody Person update(@RequestBody Person item) {
    	return repository.save(item);
    } 
    
    @RequestMapping(value = "/person" , method = RequestMethod.DELETE)
    public void delete(@RequestBody Person item) {
    	repository.delete(item);
        //do business logic
    } 
}
