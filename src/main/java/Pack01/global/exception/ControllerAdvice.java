package Pack01.global.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@RestControllerAdvice
public class ControllerAdvice {
//    @ExceptionHandler(RuntimeException.class)
//    public ModelAndView handleRuntimeException(){
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("error");
//        return mav;
//    }
    @ExceptionHandler(FourUAdminException.class)
    public ModelAndView handleFourUAdminException(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("erroradmin");
        return mav;
    }

    @ExceptionHandler(FourUPerMissionException.class)
    public ModelAndView handleFourUPerMissionException(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("noPermission");
        return mav;
    }
//    @ExceptionHandler(FourUUserException.class)
//    public ModelAndView handleFourUUserException(){
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("erroruser");
//        return mav;
//    }
}
