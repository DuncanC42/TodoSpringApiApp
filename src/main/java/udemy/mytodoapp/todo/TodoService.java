package udemy.mytodoapp.todo;

import jakarta.validation.Valid;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<Todo>();
    private static int idTodo = 0;
    static{
        todos.add(new Todo(++idTodo, "Duncan", "Learn Spring MVC", LocalDate.now(), false));
        todos.add(new Todo(++idTodo, "Duncan", "Learn Struts", LocalDate.now().plusYears(3), false));
        todos.add(new Todo(++idTodo, "in28minutes", "Learn Hibernate", LocalDate.now(), false));
    }

    public List<Todo> findByUsername(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUsername().equalsIgnoreCase(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean isDone){
        todos.add(new Todo(++idTodo, username, description, targetDate, isDone));
    }

    public void removeTodo(long idTodo){
        /*Delete concurrence*/
//        for(Todo todo : todos){
//            if(todo.getId() == idTodo){
//                todos.remove(todo);
//            }
//        }
        /*better choice*/
        Predicate<? super Todo> predicate = todo -> todo.getId() == idTodo;
        todos.removeIf(predicate);
    }

    public Todo findById(long id) {
        Predicate <? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        removeTodo(todo.getId());
        todos.add(todo);
    }
}
