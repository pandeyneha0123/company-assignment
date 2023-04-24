package com.yebelo.service;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.yebelo.model.categoryValue;
import com.yebelo.repository.categoryValueRepository;

import jakarta.transaction.Transactional;

@Service
public class NumberServiceImpl implements NumberService {
  @Autowired
  private categoryValueRepository catVal;
  
  @Bean
  public void setEntity(){
	   catVal.save(new categoryValue("prince",1l));
	   catVal.save(new categoryValue("neha",1l));
  }
  @Override
  public Long[] fetchNextNumber(Long id) {
	  Long[] arr= new  Long[2];
	  Optional<categoryValue> precat = catVal.findById(id);
	  if(!precat.isEmpty()) {
		  categoryValue categoryValue = precat.get();
		  Long value=categoryValue.getValue();
		  Long newvalue=getNextNumber(value+1);
		  
		  categoryValue.setValue(newvalue);
		  arr[0]=value;
		  arr[1]=newvalue;
		  catVal.save(categoryValue);
	  }
	  
  	return arr;
  }
 


   Long getNextNumber(Long value) {
    Long delay = 0l;
    while (!isSumOfDigitsOne(value)) {
      value++;
      //System.out.println(value);
      delay += 5000; // 5 seconds

    }
    try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    return value;
  }

  private boolean isSumOfDigitsOne(long value) {
	  HashMap<Integer,Integer> l= new HashMap<>();
    int sum = 0;
    while(value > 0){
    	
		while (value > 0) {
			
		      sum += value % 10;
		      value /= 10;
		 }
		if(sum==1) {
			return true;
		}
		else if(l.containsKey(sum)) {
			return false;
		}
		else {
			l.put(sum, 1);
			value=sum;
			sum=0;
		}
		
    }
    
    return (sum == 1);
  }

}
	   

