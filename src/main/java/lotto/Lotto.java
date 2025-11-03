package lotto;


import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        List<Integer> distinctList = numbers.stream().distinct().toList();
        if(distinctList.size() != numbers.size()) throw new IllegalArgumentException("[ERROR] 로또 번호는 중복숫자가 없어야 합니다.");
    }

    public List<Integer> getNumbers() {return numbers;}
}
