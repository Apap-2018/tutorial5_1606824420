package com.apap.tutorial5.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial5.model.DealerModel;
import com.apap.tutorial5.repository.DealerDb;

/**
 * DealerServiceImpl
 */
@Service
@Transactional
public class DealerServiceImpl implements DealerService{
	@Autowired
	private DealerDb dealerDb;
	
	@Override
	public Optional<DealerModel> getDealerDetailById(Long id) {
		return dealerDb.findById(id);
	}
	
	@Override
	public void addDealer(DealerModel dealer) {
		dealerDb.save(dealer);
	}

	@Override
	public List<DealerModel> getAllDealer() {
		// TODO Auto-generated method stub
		return dealerDb.findAll();
	}

	@Override
	public DealerDb allDealer() {
		// TODO Auto-generated method stub
		return dealerDb;
	}

	@Override
	public void deleteDealer(DealerModel dealer) {
		dealerDb.delete(dealer);
	}
	@Override
	public void updateDealer(long id, Optional<DealerModel> newDealer) {
		DealerModel temp = dealerDb.getOne(id);
		temp.setAlamat(newDealer.get().getAlamat());
		temp.setNoTelp(newDealer.get().getNoTelp());
		dealerDb.save(temp);
	}
}