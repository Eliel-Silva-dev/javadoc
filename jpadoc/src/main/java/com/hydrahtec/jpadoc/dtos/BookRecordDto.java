package com.hydrahtec.jpadoc.dtos;

import java.util.List;
import java.util.UUID;

public record BookRecordDto(
        String title,
        UUID publisherId,
        List<UUID> authorIds,
        String reviewComment
) {
}
