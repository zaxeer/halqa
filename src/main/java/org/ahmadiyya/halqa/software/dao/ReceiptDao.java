package org.ahmadiyya.halqa.software.dao;

import java.util.List;

import org.ahmadiyya.halqa.software.model.Receipt;

public interface ReceiptDao {

	public void addReceipt(Receipt p);

	public List<Receipt> listReceipt();

	public Receipt getPersonById(long id);

}
