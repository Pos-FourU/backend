package Pack01.domain.waiting.application;

import Pack01.domain.waiting.repository.WaitingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class WaitingWriteServiceImp implements WaitingWriteService {
    private final WaitingRepository waitingRepository;


    @Override
    public void updateWaiting() {
        waitingRepository.updateWaiting();
    }
}
