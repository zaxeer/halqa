package org.ahmadiyya.halqa.software.ui;

import org.ahmadiyya.halqa.software.model.Receipt;
import org.ahmadiyya.halqa.software.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.fields.MTable;
import org.vaadin.viritin.label.RichText;
import org.vaadin.viritin.layouts.MHorizontalLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;

import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

public class ReceiptEntryView extends VerticalLayout implements View {
	
	@Autowired
	ReceiptService repo;

	private MTable<Receipt> list = new MTable<>(Receipt.class)
			.withProperties("id", "memberId", "wassiyatId", "memberName",
					"receiptDate", "aam")
			.withColumnHeaders("id", "memberId", "wassiyatId", "memberName",
					"receiptDate", "aam")
			.setSortableProperties("id", "memberId").withFullWidth();

	private Button addNew = new MButton(FontAwesome.PLUS, this::add);// new
																		// Button("Add");//
																		// MButton(FontAwesome.PLUS,
																		// this.add);

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
		list.setBeans(repo.listReceipts());
		// A dead simple in memory listing would be:
		// list.setBeans(repo.findAll());

		// Lazy binding with SortableLazyList: memory and query efficient
		// connection from Vaadin Table to Spring Repository
		// Note that fetching strategies can be given to MTable constructor as
		// well.
		// Use this approach if you expect you'll have lots of data in your
		// table.

		// list.setBeans(new SortableLazyList<>(
		// // entity fetching strategy
		// (firstRow, asc, sortProperty) -> repo.findAllBy(
		// new PageRequest(
		// firstRow / PAGESIZE,
		// PAGESIZE,
		// asc ? Sort.Direction.ASC : Sort.Direction.DESC,
		// // fall back to id as "natural order"
		// sortProperty == null ? "id" : sortProperty
		// )
		// ),
		// // count fetching strategy
		// () -> (int) repo.count(),
		// PAGESIZE
		// ));
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
