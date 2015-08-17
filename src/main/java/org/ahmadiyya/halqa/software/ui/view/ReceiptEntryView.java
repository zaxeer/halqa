package org.ahmadiyya.halqa.software.ui.view;

import java.util.List;
import java.util.Optional;

import org.ahmadiyya.halqa.software.model.Receipt;
import org.ahmadiyya.halqa.software.service.ReceiptService;
import org.ahmadiyya.halqa.software.ui.form.ReceiptEntryForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.fields.MTable;
import org.vaadin.viritin.label.RichText;
import org.vaadin.viritin.layouts.MHorizontalLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;

import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;


public class ReceiptEntryView extends VerticalLayout implements View {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	ReceiptService repo;

	private MTable<Receipt> list = new MTable<>(Receipt.class)
			.withProperties("id", "memberId", "wassiyatId", "memberName",
					"receiptDate", "aam")
			.withColumnHeaders("id", "memberId", "wassiyatId", "memberName",
					"receiptDate", "aam")
			.setSortableProperties("id", "memberId").withFullWidth();

	private Button addNew = new MButton(FontAwesome.PLUS, this::add);

	@Override
	public void enter(ViewChangeEvent event) {
		addComponent(new MVerticalLayout(
				new RichText().withMarkDownResource("/welcome.md"),
				new MHorizontalLayout(addNew), list).expand(list));
		listEntities();
		list.addMValueChangeListener(e -> adjustActionButtonState());

	}

	protected void adjustActionButtonState() {
		boolean hasSelection = list.getValue() != null;
		// edit.setEnabled(hasSelection);
		// delete.setEnabled(hasSelection);
	}

	static final int PAGESIZE = 45;

	private void listEntities() {
		Optional<List<Receipt>> receipts = Optional.ofNullable(repo.listReceipts());
		receipts.ifPresent(list::setBeans); //list.setBeans(repo.listReceipts()); 
		adjustActionButtonState();

	}

	public void add(Button.ClickEvent clickEvent) {
		edit(new Receipt());
	}

	public void edit(ClickEvent e) {
		edit(list.getValue());
	}

	protected void edit(final Receipt receiptEntry) {
		ReceiptEntryForm phoneBookEntryForm = new ReceiptEntryForm(receiptEntry);
		phoneBookEntryForm.openInModalPopup();
		phoneBookEntryForm.setSavedHandler(this::saveEntry);
		phoneBookEntryForm.setResetHandler(this::resetEntry);
	}

	public void saveEntry(Receipt entry) {
		repo.addReceipt(entry);
		listEntities();
		closeWindow();
	}

	public void resetEntry(Receipt entry) {
		listEntities();
		closeWindow();
	}

	protected void closeWindow() {
		
		getUI().getWindows().stream().forEach(w -> getUI().removeWindow(w));
	}

}
