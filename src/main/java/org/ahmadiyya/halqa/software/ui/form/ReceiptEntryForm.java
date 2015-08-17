package org.ahmadiyya.halqa.software.ui.form;

import org.ahmadiyya.halqa.software.model.Receipt;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.form.AbstractForm;
import org.vaadin.viritin.layouts.MFormLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;

import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.TextField;

public class ReceiptEntryForm extends AbstractForm <Receipt>{
	
	private static final long serialVersionUID = 1L;
	TextField id = new MTextField("Receipt id");
    TextField memberId = new MTextField("Member Id");
    TextField wassiyatId = new MTextField("Wasiyyat Id");
    TextField memberName = new MTextField("Member name");
    DateField receiptDate = new DateField("Receipt Date");
    TextField aam = new MTextField("Chanda aam");
    

    public ReceiptEntryForm(Receipt receiptEntry) {
        setSizeUndefined();
        setEntity(receiptEntry);
    }

	@Override
	protected Component createContent() {
		
		receiptDate.setDateFormat("dd.MM.yyyy");
		 return new MVerticalLayout(
	                new MFormLayout(
	                        id,
	                        memberId,
	                        wassiyatId,
	                        memberName,
	                        receiptDate,
	                        aam
	                ).withWidth(""),
	                getToolbar()
	        ).withWidth("");
	}

}
