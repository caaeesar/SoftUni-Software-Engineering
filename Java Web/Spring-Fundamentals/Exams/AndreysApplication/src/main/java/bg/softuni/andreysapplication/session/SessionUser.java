package bg.softuni.andreysapplication.session;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@Getter
@Setter
public class SessionUser {


    private boolean isLogged;

}
