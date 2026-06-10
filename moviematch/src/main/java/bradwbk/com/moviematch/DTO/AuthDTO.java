package bradwbk.com.moviematch.DTO;

import java.time.LocalDateTime;

public record AuthDTO (
    String token,
    LocalDateTime expires)
{}
