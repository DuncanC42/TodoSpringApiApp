package udemy.mytodoapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;


@Controller
@SessionAttributes("name")
public class TodoControllerJpa {

//    private TodoService todoService;

    private TodoRepository todoRepository;

    public TodoControllerJpa(/*TodoService todoService, */TodoRepository todoRepository) {
//        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    @RequestMapping(value = "list-todos")
    public String listAllTodos(ModelMap model) {
        String username = getLoggedInUsername(model);
//        List<Todo> todos = todoService.findByUsername(model.get("name").toString());

        List<Todo> todoList = todoRepository.findByUsername(username);
        model.addAttribute("todos", todoList);
        return "listTodos";
    }

    private String getLoggedInUsername(ModelMap model) {
        return (String) model.get("name");
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model){
        String username = (String) model.get("name");
        Todo todo = new Todo(0, username, "", LocalDate.now(), false);
        model.put("todo", todo); //put the todo in the model
        return "todo";
    }
    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result){

        if(result.hasErrors()){
            return "todo";
        }
        String username = getLoggedInUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);
//        todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
        return "redirect:list-todos";
    }



    @RequestMapping(value="delete-todo")
    public String deleteTodo(@RequestParam long id){
        todoRepository.deleteById(id);
//        todoService.removeTodo(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value="update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam long id, ModelMap model) {
        Todo todo = todoRepository.findById(id).get();
//        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){

        if(result.hasErrors()){
            return "todo";
        }
        String username = (String) model.get("name");
        todo.setUsername(username);
        todoRepository.save(todo);
//        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }
}
