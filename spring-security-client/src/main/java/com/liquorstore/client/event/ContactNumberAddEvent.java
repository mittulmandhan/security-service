package com.liquorstore.client.event;

import com.liquorstore.client.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class ContactNumberAddEvent extends ApplicationEvent {

    User user;

    public ContactNumberAddEvent(User user) {
        super(user);
        this.user = user;
    }
}
