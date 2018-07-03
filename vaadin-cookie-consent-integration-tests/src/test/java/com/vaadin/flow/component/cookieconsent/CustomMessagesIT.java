package com.vaadin.flow.component.cookieconsent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vaadin.flow.component.confirmdialog.examples.CustomMessages;
import com.vaadin.flow.component.cookieconsent.testbench.CookieConsentElement;

public class CustomMessagesIT extends AbstractParallelTest {

    @Test
    public void test() throws Exception {
        open(CustomMessages.class, WINDOW_SIZE_SMALL);
        final CookieConsentElement element = $(CookieConsentElement.class)
                .get(0);
        assertNotNull(element);
        assertEquals(CustomMessages.POSITION, element.getPosition());
        assertEquals(CustomMessages.MESSAGE, element.getMessage());
        assertEquals(CustomMessages.DISMISS_LABEL, element.getDismissLabel());
        assertEquals(CustomMessages.LEARN_MORE_LABEL,
                element.getLearnMoreLabel());
        assertEquals(CustomMessages.LEARN_MORE_LINK,
                element.getLearnMoreLink());
        final WebElement dismiss = element.getDismissLinkElement();
        dismiss.click();
        Thread.sleep(1000);
        WebElement container = getDriver()
                .findElement(By.className("cc-window"));
        assertFalse(container.isDisplayed());
    }

}
