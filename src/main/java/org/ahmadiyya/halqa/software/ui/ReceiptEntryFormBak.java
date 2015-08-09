package org.ahmadiyya.halqa.software.ui;

import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

public class ReceiptEntryFormBak  extends CustomComponent {
	
	 // Member that will bind to the "name" property
    TextField name = new TextField("Name");
    
    // Member that will bind to the "age" property 
    @PropertyId("age")
    TextField ageField = new TextField("Age");
    
    public ReceiptEntryFormBak() {
        FormLayout layout = new FormLayout();
        layout.addComponent(name);
        layout.addComponent(ageField);
        
        PropertysetItem item = new PropertysetItem();
        item.addItemProperty("name", new ObjectProperty<String>(name.getValue()));
        item.addItemProperty("age", new ObjectProperty<String>(ageField.getValue()));
        
        // Now use a binder to bind the members
        FieldGroup binder = new FieldGroup(item);
        binder.bindMemberFields(this);

        setCompositionRoot(layout);
    }

}
