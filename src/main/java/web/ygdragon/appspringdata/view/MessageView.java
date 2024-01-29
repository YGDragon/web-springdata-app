package web.ygdragon.appspringdata.view;

import org.springframework.stereotype.Service;

@Service
public class MessageView {

    public void displayInfo(String message) {
        System.out.println(message);
    }
}
