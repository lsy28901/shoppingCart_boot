package supercoding.mall.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    FOOD("음식"),
    CLOTHES("의류"),
    ETC("잡화"),
    DEVICE("전자기기");

    private final String categoryName;
}
