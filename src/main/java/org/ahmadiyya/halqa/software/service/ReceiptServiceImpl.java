package org.ahmadiyya.halqa.software.service;

import java.util.List;
import org.ahmadiyya.halqa.software.dao.ReceiptDao;
import org.ahmadiyya.halqa.software.model.Receipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReceiptServiceImpl implements ReceiptService {

	@Autowired
	private ReceiptDao receiptDao;

	@Transactional
	@Override
	public void addReceipt(Receipt p) {
		this.receiptDao.addReceipt(p);
	}

	@Transactional
	@Override
	public List<Receipt> listReceipts() {
		return this.receiptDao.listReceipt();
	}

	@Transactional
	@Override
	public Receipt getPersonById(long id) {
		return this.receiptDao.getPersonById(id);
	}

}
