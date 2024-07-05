package org.personal.todo2;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class api {
    private taskrepo taskrep;
    public api(taskrepo taskrep) {
        this.taskrep = taskrep;
    }
    @GetMapping("/getall")
    public @ResponseBody Iterable<task> getall() {
        return taskrep.findAll();
    }
    @GetMapping("/gettask/{id}")
    public  @ResponseBody task gettask(@PathVariable Long id) {  return taskrep.findById(id).orElseThrow();}


    @PostMapping("/addtask")
    public @ResponseBody task addtask(@RequestBody String description) {
        task task = new task(description);
        return taskrep.save(task);}

    @DeleteMapping("/deletetask/{id}")
    public void deletetask(@RequestBody Long id) {
        task task = taskrep.findById(id).orElseThrow();
        taskrep.delete(task);
    }
    @DeleteMapping("/deleteall")
    public void deleteall()
    {
        taskrep.deleteAll();
    }
}
