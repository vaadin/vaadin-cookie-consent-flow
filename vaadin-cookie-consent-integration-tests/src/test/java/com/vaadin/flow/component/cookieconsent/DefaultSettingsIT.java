package com.vaadin.flow.component.cookieconsent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.vaadin.flow.component.confirmdialog.examples.DefaultSettings;
import com.vaadin.flow.component.cookieconsent.testbench.CookieConsentElement;

public class DefaultSettingsIT extends AbstractParallelTest {

    @Test
    public void test() throws Exception {
        open(DefaultSettings.class, WINDOW_SIZE_SMALL);
        final CookieConsentElement element = $(CookieConsentElement.class)
                .get(0);
        assertNotNull(element);
        final WebElement dismiss = element.getDismissLinkElement();
        assertNotNull(dismiss);
        assertEquals("Got it!", dismiss.getText());
        dismiss.click();
        Thread.sleep(1000);
        assertFalse(element.isDisplayed());
    }

}
