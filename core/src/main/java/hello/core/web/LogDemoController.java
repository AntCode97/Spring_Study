package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    //private final MyLogger myLogger;  //이 빈은 생성자 의존주입을 하기 때문에, 스프링에서 생성될 떄 의존주입이 이루어진다.
    //하지만 Mylogger는 request빈이기 때문에 request가 들어오지 않으면 생성되지 않는다. 그래서 그냥 생성자 의존주입을 하면 존재하지 않는 빈을 주입하려 하기 때문에
    //오류가 발생한다. 이것을 Provider를 사용해서 후에 주입하게 함으로써 해결할 수 있다.
    //private final ObjectProvider<MyLogger> myLoggerProvider ;
    private final MyLogger myLogger; //proxyMode를 이용해서 Provider를 사용하는 것처럼 사용할 수 있다.
    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){
        String requestURL = request.getRequestURL().toString();
   //     MyLogger myLogger = myLoggerProvider.getObject();
        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "ok";
    }

}
