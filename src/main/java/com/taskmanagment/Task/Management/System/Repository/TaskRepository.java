package com.taskmanagment.Task.Management.System.Repository;

import com.taskmanagment.Task.Management.System.Enum.Status;
import com.taskmanagment.Task.Management.System.Model.Task;
import org.hibernate.annotations.QueryCacheLayout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface TaskRepository extends JpaRepository<Task,Long> {
    @Query(value = "select t.* from task t join user_info u on u.id = t.user_id where t.user_id = :user_id and t.id = :task_id",nativeQuery = true)
    Optional<Task> getSpecificTask(@Param("user_id")long userId, @Param("task_id") long taskId);


    @Query(value = "select t.* from task t join user_info u on u.id = t.user_id where t.user_id =:user_id and t.over_due < curdate()",nativeQuery = true)
    List<Task> getOverDueTask(@Param("user_id")long userId);

    @Query(value = "select t.* from task t join user_info u on u.id = t.user_id where t.user_id = :user_id and t.over_due = curdate()",nativeQuery = true)
    List<Task> getDueTodayTask(@Param("user_id")long userId);

    @Query(value = "select t.* from task t join user_info u on u.id = t.user_id where t.user_id = :user_id and t.status=:status",nativeQuery = true)
    List<Task> filterByStatus(@Param("user_id")long userId,@Param("status") String status);

    @Query(value = "select t.* from task t join user_info u on u.id = t.user_id where t.user_id = :user_id and t.priority=:priority",nativeQuery = true)
    Optional<List<Task>> filterByPriority(@Param("user_id")long userId,@Param("priority") String priority);

    @Query(value = "select t.* from task t join user_info u on u.id = t.user_id where t.user_id = :user_id and t.title=:title",nativeQuery = true)
    Optional<Task> searchByTitle(@Param("user_id")long userId,@Param("title") String title);

    @Query(value = "select count(*) from task where user_id = ?1",nativeQuery = true)
    long countTotalTask(long userId);

    @Query(value = "select count(*) from task where user_id = ?1 and status = 'COMPLETED'",nativeQuery = true)
    long countCompletedTask(long userId);

    @Query(value = "select count(*) from task where user_id = ?1 and status <> 'COMPLETED'",nativeQuery = true)
    long countPendingTask(long userId);

    @Query(value = "select count(*) from task where user_id = ?1 and over_due < curdate()",nativeQuery = true)
    long countOverDueTask(long userId);
}
