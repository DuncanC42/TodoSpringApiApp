package udemy.mytodoapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

    private AuthentificationService authentificationService;

    public LoginController(AuthentificationService authentificationService) {
        this.authentificationService = authentificationService;
    }

    private Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String gotoLoginPage(ModelMap model){
        model.put("name", "Duncan");
        return "welcome";
    }

    /*Inutile car on vire vers Spring security*/
//    @RequestMapping(value="/", method = RequestMethod.POST)
//    public String gotoWelcomePage(@RequestParam String name,
//                                  @RequestParam String password,
//                                  ModelMap model){
//
//        if(authentificationService.authenticate(name, password)){
//            model.put("name", name);
////            model.put("password", password);
//
//            return "welcome";
//        }
//        model.put("errorMessage", "Invalid Credentials, please try again");
//        return "welcome";
//
//    }


}
