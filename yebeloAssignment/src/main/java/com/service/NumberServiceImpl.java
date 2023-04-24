package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.categoryValue;
import com.repository.categoryValueRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class NumberServiceImpl implements NumberService {

  @Autowired
  private categoryValueRepository catVal;

  @Override
  public int fetchNextNumber(String categoryCode) {
    categoryValue categoryValue = catVal.findMaxValueByCategoryCode(categoryCode);

    int fetchedValue = (categoryValue != null) ? categoryValue.getValue() : 0;
    int nextValue = getNextNumber(fetchedValue + 1);

    if (categoryValue == null) {
      categoryValue = new categoryValue(categoryCode, nextValue);
    } else {
      categoryValue.setValue(nextValue);
    }

    catVal.save(categoryValue);

    return nextValue;
  }

  private int getNextNumber(int value) {
    int delay = 0;
    while (!isSumOfDigitsOne(value)) {
      value++;
      delay += 5000; // 5 seconds
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    try {
      Thread.sleep(delay);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return value;
  }

  private boolean isSumOfDigitsOne(int value) {
    int sum = 0;
    while (value > 0) {
      sum += value % 10;
      value /= 10;
    }
    return (sum == 1);
  }

}
