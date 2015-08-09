package org.ahmadiyya.halqa.software.service;

import java.util.List;
import org.ahmadiyya.halqa.software.model.Receipt;

public interface ReceiptService {

	public void addReceipt(Receipt p);

	public List<Receipt> listReceipts();

	public Receipt getPersonById(long id);

}
