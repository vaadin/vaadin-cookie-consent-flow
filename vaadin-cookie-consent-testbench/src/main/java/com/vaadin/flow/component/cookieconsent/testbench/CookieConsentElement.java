package com.vaadin.flow.component.cookieconsent.testbench;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import com.google.common.base.Strings;
import com.vaadin.flow.component.cookieconsent.CookieConsent.Position;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.elementsbase.Element;

@Element("vaadin-cookie-consent")
public class CookieConsentElement extends TestBenchElement {

    public WebElement getDismissLinkElement() {
        return getElementFromContainer(By.className("cc-dismiss"));
    }

    public WebElement getLearnMoreLinkElement() {
        return getElementFromContainer(By.className("cc-link"));
    }

    public String getMessage() {
        return getAttribute("message");
    }

    public String getDismissLabel() {
        return getAttribute("dismiss");
    }

    public String getLearnMoreLabel() {
        return getAttribute("learnMore");
    }

    public String getLearnMoreLink() {
        return getAttribute("learnMoreLink");
    }

    public String getCookieName() {
        return getAttribute("cookieName");
    }

    public Position getPosition() {
        final String attributeValue = getAttribute("position");
        final boolean hasValue = !Strings.isNullOrEmpty(attributeValue);
        return hasValue ? Position.valueOf(attributeValue.replace('-', '_').toUpperCase())
                : null;
    }

    public WebElement getContainer() {
        return getDriver().findElement(By.className("cc-window"));
    }
 
    @Override
    public SearchContext getContext() {
        return getContainer();
    }

    WebElement getElementFromContainer(By by) {
        final WebElement container = getContainer();
        return container != null ? container.findElement(by) : null;

    }

}
