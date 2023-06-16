package Pack01.global.schedule;

import Pack01.domain.member.application.MemberReadService;
import Pack01.domain.member.application.MemberWriteService;
import Pack01.domain.rental.application.RentalReadService;
import Pack01.domain.rental.application.RentalWriteService;
import Pack01.domain.waiting.application.WaitingWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Schedule {
    private final RentalReadService rentalReadService;
    private final RentalWriteService rentalWriteService;
    private final MemberWriteService memberWriteService;
    private final MemberReadService memberReadService;
    private final WaitingWriteService waitingWriteService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void execute() {
        waitingWriteService.updateWaiting();
        memberWriteService.increaseWarningCount(rentalReadService.findAllByExpireMembers());
        memberReadService.findByWaringCountUser();
        rentalWriteService.deleteExpiredRentals();
    }

}
