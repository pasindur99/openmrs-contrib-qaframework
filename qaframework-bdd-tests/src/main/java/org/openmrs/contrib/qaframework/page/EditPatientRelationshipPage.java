/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 * 
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.contrib.qaframework.page;

import org.openmrs.contrib.qaframework.helper.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class EditPatientRelationshipPage extends Page {

	private static final String NAME = "John";
	private static final By SELECT_RELATIONSHIP_TYPE = By.id("relationship_type");
	private static final By PERSON_NAME = By.xpath("//ul[@id='relationship']/p[2]/input[1]");
	private static final By NEXT_BUTTON = By.id("next-button");
	private static final By CONFIRM_BUTTON = By.id("registration-submit");

	public EditPatientRelationshipPage(Page parent) {
		super(parent);
	}

	public void clickOnSelectRelationshipType() throws InterruptedException {
		clickOn(SELECT_RELATIONSHIP_TYPE);
		Select relationshipType = new Select(driver.findElement(By.id("relationship_type")));
		relationshipType.selectByVisibleText("Doctor");
		setTextToFieldNoEnter(PERSON_NAME, NAME);
		clickOn(NEXT_BUTTON);
		clickOn(CONFIRM_BUTTON);
	}

	@Override
	public String getPageUrl() {
		return "/registrationapp/editSection.page";
	}
}
