package com.group.libraryapp.dto.homework.day2.request;

import java.util.ArrayList;
import java.util.List;

public class NumberListRequest {
    private List<Integer> numbers = new ArrayList<>();

    public NumberListRequest(){}

    public NumberListRequest(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
