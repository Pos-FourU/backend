package Pack01.global.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SendMailSchedule {

    @Scheduled(cron = "0 0 0 * * ?") // 매일 00시에 실행
    public void SendMail() {

    }
}
