package com.example.demoP;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {
@Autowired
private PersonRepository p;
@GetMapping("/categories")
public Page<Person>a1(@RequestParam int page,
		@RequestParam int size){
	return p.findAll(PageRequest.of(page, size));
}
@GetMapping("/sorting")
public List<Person>a2(@RequestParam String sortBy){
	Sort sort =Sort.by(sortBy);
	return p.findAll(sort);
}

@GetMapping("/categories/{id}")
public Person a4(@PathVariable int id) {
	return p.findById(id).orElse(null);
}
@PostMapping("/categories")
public Person a5(@RequestBody Person person) {
	return p.save(person);
}
@PutMapping("/categories/{id}")
public Person a6(@PathVariable int id,@RequestBody Person person) {
	return p.findById(id).map(e->{e.setCategory(person.getCategory());
	return p.save(e);
})
			.orElse(null);
}
@DeleteMapping("/categories/{id}")
public void a7(@PathVariable int id) {
	p.deleteById(id);
}
@Autowired
private BankRepository b;

@GetMapping("/product")
public Page<Bank>b1(@RequestParam int page,
		@RequestParam int size){
	return b.findAll(PageRequest.of(page, size));
}
@GetMapping("/sorting")
public List<Bank>b2(@RequestParam String sortBy){
	Sort sort =Sort.by(sortBy);
	return b.findAll(sort);
}

@GetMapping("/product/{id}")
public Bank b4(@PathVariable int id) {
	return b.findById(id).orElse(null);
}
@PostMapping("/product")
public Bank b5(@RequestBody Bank bank) {
	return b.save(bank);
}
@PutMapping("/product/{id}")
public Bank b6(@PathVariable int id,@RequestBody Bank bank) {
	return b.findById(id).map(e->{e.setProduct(bank.getProduct());
	return b.save(e);
})
			.orElse(null);
}
@DeleteMapping("/product/{id}")
public void b7(@PathVariable int id) {
	b.deleteById(id);
}
}
