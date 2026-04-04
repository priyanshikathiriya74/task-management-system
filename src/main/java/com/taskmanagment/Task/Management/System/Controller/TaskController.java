package com.taskmanagment.Task.Management.System.Controller;

import com.taskmanagment.Task.Management.System.DTO.RequestDTO.RequestDTO;
import com.taskmanagment.Task.Management.System.DTO.ResponseDTO.Response;
import com.taskmanagment.Task.Management.System.DTO.RequestDTO.UpdateTaskDTO;
import com.taskmanagment.Task.Management.System.Enum.Priority;
import com.taskmanagment.Task.Management.System.Enum.Status;
import com.taskmanagment.Task.Management.System.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("createTask/{userId}")
    public ResponseEntity<Response> createTask(@RequestBody RequestDTO requestDTO,
                                               @PathVariable long userId) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(new Response(this.taskService.save(requestDTO,userId),HttpStatus.CREATED,"Task completed Successfully"));
        }catch (ResponseStatusException ex){
           return ResponseEntity.status(ex.getStatusCode()).body(new Response(ex.getStatusCode(), ex.getMessage()));
        }
    }

    @GetMapping("getSpecificTask")
    public ResponseEntity<Response> getSpecificTask(@RequestParam long userId,
                                          @RequestParam long taskId){
        try{
            return ResponseEntity.ok(new Response(this.taskService.getSpecificTask(userId, taskId),HttpStatus.OK,"Success"));
        }catch (ResponseStatusException ex){
            return ResponseEntity.status(ex.getStatusCode()).body(new Response(ex.getStatusCode(),ex.getMessage()));

        }
    }

    @PatchMapping("updateStatus")
    public ResponseEntity<Response> updateStatus(@RequestParam long userId,
                                          @RequestParam long taskId,
                                          @RequestParam Status status){
        try{
            return ResponseEntity.ok(new Response(this.taskService.updateStatus(userId, taskId,status),HttpStatus.OK,"Success"));
        }catch(ResponseStatusException ex){
            return ResponseEntity.status(ex.getStatusCode()).body(new Response(ex.getStatusCode(),ex.getMessage()));
        }
    }

    @DeleteMapping("deleteTask")
    public ResponseEntity<Response> deleteTask(@RequestParam long userId,
                                          @RequestParam long taskId){
        try{
            return ResponseEntity.ok(new Response(this.taskService.deleteTask(userId, taskId),HttpStatus.OK,"Success"));
        }catch(ResponseStatusException ex){
            return ResponseEntity.status(ex.getStatusCode()).body(new Response(ex.getStatusCode(),ex.getMessage()));
        }
    }

    @GetMapping("seeOverDueTask")
    public ResponseEntity<Response> getOverDueTask(@RequestParam long userId){
        try {
            return ResponseEntity.ok(new Response(this.taskService.getOverDueTask(userId),HttpStatus.OK,"Success"));
        }catch (ResponseStatusException ex){
            return ResponseEntity.status(ex.getStatusCode()).body(new Response(ex.getStatusCode(),ex.getMessage()));
        }
    }

    @GetMapping("seeDueTodayTask")
    public ResponseEntity<Response> getDueTodayTask(@RequestParam long userId){
        try {
            return ResponseEntity.ok(new Response(this.taskService.getDueTodayTask(userId),HttpStatus.OK,"Success"));
        }catch (ResponseStatusException ex){
            return ResponseEntity.status(ex.getStatusCode()).body(new Response(ex.getStatusCode(),ex.getMessage()));
        }
    }

    @GetMapping("filterByStatus")
    public ResponseEntity<Response> filterByStatus(@RequestParam long userId,
                                            @RequestParam String status){
        try{
            return ResponseEntity.ok(new Response(this.taskService.filterByStatus(userId, status),HttpStatus.OK,"Success"));
        }catch (ResponseStatusException ex){
            return ResponseEntity.status(ex.getStatusCode()).body(new Response(ex.getStatusCode(),ex.getMessage()));
        }
    }

    @GetMapping("filterByPriority")
    public ResponseEntity<Response> filterByPriority(@RequestParam long userId,
                                            @RequestParam String priority){
        try{
            return ResponseEntity.ok(new Response(this.taskService.filterByPriority(userId, priority),HttpStatus.OK,"Success"));
        }catch (ResponseStatusException ex){
            return ResponseEntity.status(ex.getStatusCode()).body(new Response(ex.getStatusCode(),ex.getMessage()));
        }
    }

    @GetMapping("SearchByTitle")
    public ResponseEntity<Response> searchByTitle(@RequestParam long userId,
                                              @RequestParam String title){
        try{
            return ResponseEntity.ok(new Response(this.taskService.searchByTitle(userId, title),HttpStatus.OK,"Success"));
        }catch (ResponseStatusException ex){
            return ResponseEntity.status(ex.getStatusCode()).body(new Response(ex.getStatusCode(),ex.getMessage()));
        }
    }

    @GetMapping("getStatisticSummary")
    public ResponseEntity<Response> statisticSummary(@RequestParam long userId){
        try{
            return ResponseEntity.ok(new Response(this.taskService.statisticSummary(userId),HttpStatus.OK,"Success"));
        }catch (ResponseStatusException ex){
            return ResponseEntity.status(ex.getStatusCode()).body(new Response(ex.getStatusCode(),ex.getMessage()));
        }
    }

    @PatchMapping("updateTask")
    public ResponseEntity<Response> updateTask(@RequestParam long userId,
                                        @RequestParam long taskId,
                                        @RequestBody UpdateTaskDTO dto){
        try {
            return ResponseEntity.ok(new Response(this.taskService.updateDetail(userId,taskId,dto),HttpStatus.OK,"Success"));
        }catch (ResponseStatusException ex){
            return ResponseEntity.status(ex.getStatusCode()).body(new Response(ex.getStatusCode(),ex.getMessage()));
        }
    }
}

