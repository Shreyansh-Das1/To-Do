package org.personal.todo2;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class endpoint {
    private taskrepo taskrep;
    public endpoint(taskrepo taskrep) {
        this.taskrep = taskrep;
    }
    @GetMapping("/getall")
    public @ResponseBody Iterable<task> getall() {
        return taskrep.findAll();
    }

    @GetMapping("/get")
    public @ResponseBody Object get(@RequestBody Long Id) {
        return taskrep.findById(Id);
    }

    @PatchMapping("/patch")
    public @ResponseBody String complete(@RequestBody Long Id) {
         task task =taskrep.findById(Id).orElseThrow();
         task.setCompleted(!task.isCompleted());
         taskrep.findById(Id).orElseThrow().setCompleted(task.isCompleted());
         return !task.isCompleted() +" changed to "+ task.isCompleted();
    }

    @PostMapping("/addtask")
    public @ResponseBody task addtask(@RequestBody String description) {
        task task = new task(description);
        return taskrep.save(task);}

    @DeleteMapping("/deletetask")
    public @ResponseBody String deletetask(@RequestBody Long id) {
        task task = taskrep.findById(id).orElseThrow();
        taskrep.delete(task);
        return "Task ID: " + id + " Deleted";
    }
}
