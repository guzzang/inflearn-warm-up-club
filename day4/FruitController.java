package com.group.libraryapp.controller.homework.day4;

import com.group.libraryapp.dto.homework.day4.mapper.FruitStatusTotalAmount;
import com.group.libraryapp.dto.homework.day4.request.FruitCreateRequest;
import com.group.libraryapp.dto.homework.day4.request.FruitUpdateRequest;
import com.group.libraryapp.dto.homework.day4.response.FruitSalesAmountResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitController {

    private final JdbcTemplate jdbcTemplate;

    public FruitController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitCreateRequest request){
        String sql = "INSERT INTO fruit(name, warehousingdate, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    @PutMapping("/api/v1/fruit")
    public void updateFruit(@RequestBody FruitUpdateRequest request){
        String sql = "UPDATE fruit SET isSold = True WHERE id = ?";
        jdbcTemplate.update(sql, request.getId());
    }

    @GetMapping("/api/v1/fruit")
    public FruitSalesAmountResponse getSalesAmount(@RequestParam String name){
        String sql = "SELECT isSold, SUM(price) AS totalPrice FROM fruit WHERE name = ? GROUP BY isSold";
        List<FruitStatusTotalAmount> query = jdbcTemplate.query(sql, (rs, rowNum) -> {
            boolean isSold = rs.getBoolean("isSold");
            long totalPrice = rs.getLong("totalPrice");
            return new FruitStatusTotalAmount(isSold, totalPrice);
        }, name);

        long salesAmount = 0;
        long notSalesAmount = 0;

        for (FruitStatusTotalAmount result : query) {
            if(result.isSold()){
                salesAmount = result.getTotalPrice();
            }
            else{
                notSalesAmount = result.getTotalPrice();
            }
        }

        FruitSalesAmountResponse response = new FruitSalesAmountResponse(salesAmount, notSalesAmount);
        return response;

    }





}
