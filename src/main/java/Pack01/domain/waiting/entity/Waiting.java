package Pack01.domain.waiting.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class Waiting {

    private Long waiting_id;
    private Long member_id;
    private LocalDate waiting_count;


    @Builder
    public Waiting(Long waiting_id, Long member_id, LocalDate waiting_count) {
        this.waiting_id = waiting_id;
        this.member_id = member_id;
        this.waiting_count = waiting_count;
    }
}
