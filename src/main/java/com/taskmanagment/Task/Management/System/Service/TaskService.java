package com.taskmanagment.Task.Management.System.Service;

import com.taskmanagment.Task.Management.System.DTO.RequestDTO.RequestDTO;
import com.taskmanagment.Task.Management.System.DTO.RequestDTO.UpdateTaskDTO;
import com.taskmanagment.Task.Management.System.DTO.ResponseDTO.OverDueTaskDTO;
import com.taskmanagment.Task.Management.System.DTO.ResponseDTO.StatisticDTO;
import com.taskmanagment.Task.Management.System.Enum.Priority;
import com.taskmanagment.Task.Management.System.Enum.Status;
import com.taskmanagment.Task.Management.System.Exception.StatusNotFoundException;
import com.taskmanagment.Task.Management.System.Exception.TaskNotFoundException;
import com.taskmanagment.Task.Management.System.Exception.UserNotFoundException;
import com.taskmanagment.Task.Management.System.Model.Task;
import com.taskmanagment.Task.Management.System.Model.User;
import com.taskmanagment.Task.Management.System.Repository.TaskRepository;
import com.taskmanagment.Task.Management.System.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserRepository userRepository;

    public Task save(RequestDTO requestDTO,long userId) {
        User user = userRepository.findById(userId).orElseThrow(()->
                 new UserNotFoundException(userId));

        Task task = new Task();
        task.setTitle(requestDTO.getTitle());
        task.setDescription(requestDTO.getDescription());
        task.setPriority(requestDTO.getPriority());
        task.setOverDue(requestDTO.getOverDue());
        task.setStatus(Status.TODO);
        task.setCreated_at(LocalDate.now());
        task.setUsers(user);

        return taskRepository.save(task);

    }

    public Task getSpecificTask(long userId, long taskId) {
         if(!this.userRepository.existsById(userId)) {
             throw new UserNotFoundException(userId);
         }else {
             Task task = taskRepository.getSpecificTask(userId, taskId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"User %d doesn't have task %d ".formatted(userId, taskId)));
             return task;
         }
    }

    public Task updateStatus(long userId, long taskId, Status status) {
        Task task = getSpecificTask(userId,taskId);
        if(task.getStatus().equals(Status.COMPLETED)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Task Already Completed. Can't be Modified");
        }else {
            task.setStatus(status);
            taskRepository.save(task);
            return task;
        }
    }


    public String deleteTask(long userId, long taskId) {
        Task task = getSpecificTask(userId,taskId);
        taskRepository.delete(task);
        return "deleted successfully";

    }

    public OverDueTaskDTO getOverDueTask(long userId) {
        User user = userRepository.findById(userId).orElseThrow(()->
                new UserNotFoundException(userId));

        List<Task> tasks = taskRepository.getOverDueTask(userId);
        OverDueTaskDTO overDueTaskDTO = new OverDueTaskDTO();
        overDueTaskDTO.setUserName(user.getName());
        overDueTaskDTO.setTotalTask(user.getTaskList().size());
        overDueTaskDTO.setOverDueTask(tasks.size());
        overDueTaskDTO.setOverDueTaskList(tasks);
        return overDueTaskDTO;
    }

    public List<Task> getDueTodayTask(long userId) {
        if(!this.userRepository.existsById(userId)) {
            throw new UserNotFoundException(userId);
        }
        List<Task> tasks = taskRepository.getDueTodayTask(userId);
        if(tasks.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No Due Today Task");
        }
        return tasks;
    }

    public List<Task> filterByStatus(long userId, String status) {
        if(!this.userRepository.existsById(userId)) {
            throw new UserNotFoundException(userId);
        }
        status = status.toUpperCase();
        Status status1;
        try{
            status1 = Status.valueOf(status);
        }catch (Exception e){
            throw new StatusNotFoundException(status);
        }
        List<Task> tasks = taskRepository.filterByStatus(userId,status);
        if(tasks.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"There is no Task that is %s status".formatted(status));
        }
        return tasks;
    }

    public List<Task> filterByPriority(long userId, String priority) {
        if(!this.userRepository.existsById(userId)) {
            throw new UserNotFoundException(userId);
        }

        priority = priority.toUpperCase();

        Priority priority1;
        try{
            priority1 = Priority.valueOf(priority);
        }catch (ResponseStatusException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Priority %s not found".formatted(priority));
        }
        List<Task> tasks = taskRepository.filterByPriority(userId,priority).orElseThrow(()->new ResponseStatusException(HttpStatus
                .NOT_FOUND
                ,"There is no Task that is %S priority"
                .formatted(priority1)));
        return tasks;
    }

    public Task searchByTitle(long userId, String title) {
        if(!this.userRepository.existsById(userId)) {
            throw new UserNotFoundException(userId);
        }
        Task tasks = taskRepository.searchByTitle(userId,title).orElseThrow(()-> new ResponseStatusException(HttpStatus
                .NOT_FOUND
                ,"There is no Task with %s title"
                .formatted(title)));
        return tasks;
    }

    public StatisticDTO statisticSummary(long userId) {
        if(!this.userRepository.existsById(userId)) {
            throw new UserNotFoundException(userId);
        }
        StatisticDTO dto = new StatisticDTO();
        dto.setTotalTask(taskRepository.countTotalTask(userId));
        dto.setCompletedTask(taskRepository.countCompletedTask(userId));
        dto.setPendingTask(taskRepository.countPendingTask(userId));
        dto.setOverDueTask(taskRepository.countOverDueTask(userId));

        return dto;
    }

    public Task updateDetail(long userId, long taskId, UpdateTaskDTO dto) {
        if(!this.userRepository.existsById(userId)) {
            throw new UserNotFoundException(userId);
        }

        Task task = taskRepository.findById(taskId).orElseThrow(()->new TaskNotFoundException(taskId));

        if(dto.getTitle()!=null){
            task.setTitle(dto.getTitle());
        }
        if(dto.getDescription()!=null){
            task.setDescription(dto.getDescription());
        }
        if(dto.getOverDue()!=null){
            task.setOverDue(dto.getOverDue());
        }
        if(dto.getStatus()!=null){
            task.setStatus(Status.valueOf(dto.getStatus()));
        }
        return taskRepository.save(task);

    }

}
