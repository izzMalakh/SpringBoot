package com.codingdojo.clubb.services;

import org.springframework.stereotype.Service;

import com.codingdojo.clubb.models.Borrow;
import com.codingdojo.clubb.repositories.BorrowRepository;



@Service
public class BorrowService {
	public final BorrowRepository borrRepo;
	
	public BorrowService(BorrowRepository borrRepo) {
		this.borrRepo = borrRepo;
	}
	
	public Borrow addBorrow(Borrow borrow) {
		return borrRepo.save(borrow);
	}
}